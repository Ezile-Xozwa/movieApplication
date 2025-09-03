<!-- File: src/components/Seat.vue -->
<script setup>
import { ref, onMounted, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const route = useRoute()
const router = useRouter()

// Get query params
const movieId = route.query.movieId
const showtimeId = route.query.showtimeId

const message = ref('Select your seat')
const seats = ref([])
const selectedSeats = ref(new Set())

// Seat price
const seatPrice = 120 // R120 per seat
const totalPrice = computed(() => selectedSeats.value.size * seatPrice)

// Fetch all seats
const fetchSeats = async () => {
  console.log('🚀 Fetching seats...')
  try {
    const response = await axios.get('http://localhost:8080/movieapplication/seats/all')
    console.log('✅ Seats loaded:', response.data)
    seats.value = response.data
  } catch (error) {
    message.value = `❌ Error: ${error.message}`
    console.error('Fetch Error:', error)
  }
}

// Toggle seat selection
const toggleSeat = (seat) => {
  if (seat.status === 'Booked') return

  if (selectedSeats.value.has(seat.seatId)) {
    selectedSeats.value.delete(seat.seatId)
  } else {
    selectedSeats.value.add(seat.seatId)
  }
}

// Confirm booking
const confirmSelection = async () => {
  if (selectedSeats.value.size === 0) return

  // ✅ Add this to pass data to SnackOrder
  const seatIds = Array.from(selectedSeats.value)
  const seatTotal = seatPrice * seatIds.length
  //const seatTotal = seatPrice * selectedSeats.value.size


  const selectedSeatObjects = seats.value.filter(s => selectedSeats.value.has(s.seatId))
  for (const seat of selectedSeatObjects) {
    const updated = { ...seat, status: 'Booked' }
    try {
      await axios.put('http://localhost:8080/movieapplication/seats/update', updated)
    } catch (error) {
      alert(`Failed to book seat ${seat.seatRow}${seat.seatNumber}`)
    }
  }

  router.push({
    path: '/snackOrder',
    query: {
      showtimeId,
      movieId,
      seatIds: JSON.stringify(seatIds),
      seatTotal: seatTotal.toString()
    }
  })

  selectedSeats.value.clear()
  fetchSeats()
  message.value = '✅ Seats booked successfully!'
  

}

// Clear all selections
const clearSelection = () => {
  selectedSeats.value.clear()
  message.value = 'Selection cleared'
}

// Group seats by row
const getSeatsByRow = (row) => {
  return seats.value
    .filter(seat => seat.seatRow === row)
    .sort((a, b) => a.seatNumber - b.seatNumber)
}

// Rows to display
const rows = ['A', 'B', 'C', 'D', 'E']

// Back to Showtimes
const goBack = () => {
  router.push(`/showtimes?movieId=${movieId}`)
}

// Fetch seats when component mounts
onMounted(() => {
  console.log('🔧 Seat component mounted')
  fetchSeats()
})
</script>

<template>
  <!-- Header -->
  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
    <button @click="goBack" class="back-button" style="
      padding: 6px 12px;
      background: #333;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      font-size: 14px;
    ">
      ← Back
    </button>
    <h2 style="color: #BB86FC; margin: 0;">Now Booking</h2>
    <div style="width: 80px;"></div> <!-- Spacer -->
  </div>

  <!-- Movie & Showtime Info -->
  <div style="text-align: center; margin-bottom: 20px; color: #ccc; font-size: 14px;">
    <p><strong>Movie ID:</strong> {{ movieId }}</p>
    <p><strong>Showtime ID:</strong> {{ showtimeId }}</p>
  </div>

  <!-- Main Container -->
  <div style="
    max-width: 900px;
    margin: 0 auto;
    font-family: 'Arial', sans-serif;
    background-color: #121212;
    color: white;
    padding: 20px;
    border-radius: 12px;
    box-shadow: 0 4px 20px rgba(0,0,0,0.5);
  ">

    <h1 style="color: #BB86FC;">🎬 Select Your Seat</h1>
    <p style="color: #ccc;">Click on an available seat to book it</p>

    <!-- Price Summary -->
    <div style="background: #333; padding: 10px; border-radius: 6px; margin: 10px 0;">
      <p style="margin: 0; font-size: 16px;">
        Selected: <strong>{{ selectedSeats.size }}</strong> seat(s) × R{{ seatPrice }} = 
        <strong style="color: #03DAC6;">R{{ totalPrice }}</strong>
      </p>
    </div>

    <!-- Action Buttons -->
    <div style="margin: 20px 0; display: flex; gap: 10px; justify-content: center;">
      <button
          @click="confirmSelection"
          :disabled="selectedSeats.size === 0"
          :style="{
            padding: '10px 20px',
            backgroundColor: selectedSeats.size > 0 ? '#03DAC6' : '#555',
            color: 'black',
            border: 'none',
            borderRadius: '4px',
            cursor: selectedSeats.size > 0 ? 'pointer' : 'not-allowed'
          }"
      >
        ✅ Confirm ({{ selectedSeats.size }})
      </button>

      <button
          @click="clearSelection"
          :disabled="selectedSeats.size === 0"
          :style="{
            padding: '10px 20px',
            backgroundColor: '#CF6679',
            color: 'white',
            border: 'none',
            borderRadius: '4px',
            cursor: 'pointer'
          }"
      >
        🗑 Clear All
      </button>
    </div>

    <!-- Screen Label -->
    <div style="
      width: 80%;
      margin: 40px auto;
      text-align: center;
      padding: 10px;
      background: #333;
      color: white;
      font-weight: bold;
      border-radius: 6px;
      position: relative;
      top: 20px;
      z-index: 0;
    ">
      🎞 Screen
    </div>

    <!-- Seating Grid -->
    <div v-if="seats && seats.length > 0" :style="{ marginTop: '60px', display: 'grid', gap: '15px' }">
      <div
          v-for="seatRow in rows"
          :key="seatRow"
          :style="{ display: 'flex', alignItems: 'center', gap: '10px' }"
      >
        <!-- Row Label -->
        <div :style="{
          width: '30px',
          fontWeight: 'bold',
          color: '#BB86FC',
          fontSize: '18px'
        }">
          {{ seatRow }}
        </div>

        <!-- Seats in Row -->
        <div :style="{ display: 'flex', gap: '10px', flex: 1, justifyContent: 'center' }">
          <div
              v-for="seat in getSeatsByRow(seatRow)"
              :key="seat.seatId"
              @click="toggleSeat(seat)"
              :style="{
                width: '40px',
                height: '40px',
                borderRadius: '6px',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                fontSize: '14px',
                fontWeight: 'bold',
                cursor: seat.status === 'Available' && !selectedSeats.has(seat.seatId) ? 'pointer' : 'not-allowed',
                backgroundColor: seat.status === 'Booked'
                  ? '#CF6679'
                  : selectedSeats.has(seat.seatId)
                    ? '#BB86FC'
                    : '#03DAC6',
                color: 'black',
                transition: 'all 0.2s ease'
              }"
          >
            {{ seat.seatNumber }}
          </div>
        </div>
      </div>
    </div>

    <!-- Loading Message -->
    <p v-else style="text-align: center; color: #ccc; font-size: 16px; margin-top: 60px;">
      🪑 Loading seats...
    </p>

    <!-- Legend -->
    <div style="margin-top: 40px; display: flex; justify-content: center; gap: 30px; font-size: 14px;">
      <div style="display: flex; align-items: center; gap: 8px;">
        <div style="width: 20px; height: 20px; background-color: #03DAC6; border-radius: 4px;"></div>
        <span>Available</span>
      </div>
      <div style="display: flex; align-items: center; gap: 8px;">
        <div style="width: 20px; height: 20px; background-color: #BB86FC; border-radius: 4px;"></div>
        <span>Selected</span>
      </div>
      <div style="display: flex; align-items: center; gap: 8px;">
        <div style="width: 20px; height: 20px; background-color: #CF6679; border-radius: 4px;"></div>
        <span>Booked</span>
      </div>
    </div>
  </div>
</template>

<style>
body {
  background-color: #000;
  margin: 0;
  padding: 0;
}
</style>