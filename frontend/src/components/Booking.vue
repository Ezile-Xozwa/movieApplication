<!-- File: src/components/Booking.vue -->
<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import axios from 'axios'

const route = useRoute()

// Data
const booking = ref({})
const movieTitle = ref('Loading...')
const showtimeDate = ref('Loading...')
const showtimeTime = ref('Loading...')
const seatLabel = ref('Loading...')
const totalAmount = ref(0)
const userName = ref('Guest')

onMounted(async () => {
  const bookingId = route.query.bookingId
  if (!bookingId) {
    alert('No booking found!')
    return
  }

  try {
    // Step 1: Fetch booking (includes user, showtime, seat)
    const res = await axios.get(`http://localhost:8080/movieapplication/bookings/read/${bookingId}`)
    booking.value = res.data

    const showtime = res.data.showtime
    const seat = res.data.seat
    const user = res.data.user

    // Validate
    if (!showtime || !seat || !user) {
      alert('Invalid booking data')
      return
    }

    // Step 2: Extract showtime details
    const showtimeDateObj = new Date(showtime.date)
    showtimeDate.value = isNaN(showtimeDateObj) ? 'Invalid Date' : showtimeDateObj.toLocaleDateString()
    showtimeTime.value = showtime.startTime || 'Unknown Time'

    // Step 3: Fetch movie from showtime.movieId
    const movieRes = await axios.get(`http://localhost:8080/movieapplication/movie/read/${showtime.movieId}`)
    movieTitle.value = movieRes.data.title || 'Unknown Movie'

    // Step 4: Set seat label
    seatLabel.value = `${seat.seatRow}${seat.seatNumber}`

    // Step 5: Set user name
    userName.value = `${user.name} ${user.surname}`

    // Step 6: Total from query (passed from Payment)
    totalAmount.value = parseFloat(route.query.total) || 0

  } catch (error) {
    console.error('Failed to load booking:', error)
    alert('Could not load booking details.')
  }
})
</script>

<template>
  <!-- Header -->
  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
    <button @click="$router.back()" style="padding:6px 12px; background:#333; color:white; border:none; border-radius:6px; cursor:pointer;">
      ← Back
    </button>
    <h2 style="color: #BB86FC; margin: 0;">🎟️ Booking Confirmed</h2>
    <div style="width: 80px;"></div>
  </div>

  <!-- Main Container -->
  <div style="max-width:900px; margin:0 auto; background:#121212; color:white; padding:40px; border-radius:12px;">
    <div style="background:#1f1f1f; padding:30px; border-radius:10px; border:2px dashed #03DAC6; text-align:center;">
      <h1 style="color:#03DAC6;">🎟️ Booking Confirmed!</h1>
      <p>Thank you for booking with us.</p>

      <!-- QR Code (Simulated) -->
      <div style="background:white; width:150px; height:150px; margin:20px auto; padding:10px; border-radius:8px;">
        <div style="color:black; font-size:12px; text-align:center;">
          🎫<br>QR<br>CODE
        </div>
      </div>

      <!-- Booking Info -->
      <div style="text-align:left; margin:20px 0; color:#ccc; font-size:15px;">
        <p><strong>Booking ID:</strong> {{ booking.bookingId }}</p>
        <p><strong>Movie:</strong> {{ movieTitle }}</p>
        <p><strong>Date & Time:</strong> {{ showtimeDate }} at {{ showtimeTime }}</p>
        <p><strong>Seat:</strong> {{ seatLabel }}</p>
        <p><strong>Booked For:</strong> {{ userName }}</p>
        <p><strong>Total Paid:</strong> R{{ totalAmount.toFixed(2) }}</p>
      </div>

      <!-- Notes -->
      <div style="margin-top:30px; color:#03DAC6; font-size:14px;">
        <p>✅ Please arrive 15 minutes early</p>
        <p>📱 Show this screen or your email at the entrance</p>
      </div>
    </div>

    <!-- Print Button -->
    <div style="text-align:center; margin-top:30px;">
      <button @click="window.print()" style="padding:10px 20px; background:#BB86FC; color:white; border:none; border-radius:6px; cursor:pointer;">
        🖨️ Print Booking
      </button>
    </div>
  </div>
</template>