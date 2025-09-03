<!-- File: src/components/Payment.vue -->
<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const route = useRoute()
const router = useRouter()

// Query params
const movieId = route.query.movieId
const showtimeId = route.query.showtimeId

// Order summary
const seatIds = ref([])
const seatTotal = ref(0)
const snackTotal = ref(0)
const grandTotal = ref(0)

// Form data
const cardNumber = ref('')
const expiryDate = ref('')
const cvv = ref('')
const cardholderName = ref('')

// Movie & Showtime
const movieTitle = ref('Loading...')
const showtimeDate = ref('Loading...')
const showtimeTime = ref('Loading...')

// Fetch movie/showtime
const fetchMovieAndShowtime = async () => {
  try {
    const movieRes = await axios.get(`http://localhost:8080/movieapplication/movie/read/${movieId}`)
    movieTitle.value = movieRes.data.title
  } catch (e) {
    movieTitle.value = 'Movie ID: ' + movieId
  }

  try {
    const showtimeRes = await axios.get(`http://localhost:8080/movieapplication/showtime/read/${showtimeId}`)
    const date = new Date(showtimeRes.data.date)
    showtimeDate.value = date.toLocaleDateString()
    showtimeTime.value = showtimeRes.data.startTime
  } catch (e) {
    showtimeDate.value = 'Date N/A'
    showtimeTime.value = 'Time N/A'
  }
}

// Format inputs
const formatCardNumber = (e) => {
  let v = e.target.value.replace(/\s/g, '').replace(/[^0-9]/g, '')
  if (v.length > 16) v = v.slice(0, 16)
  v = v.replace(/(\d{4})/g, '$1 ').trim()
  e.target.value = v
  cardNumber.value = v
}

const formatExpiryDate = (e) => {
  let v = e.target.value.replace(/[^0-9]/g, '')
  if (v.length > 4) v = v.slice(0, 4)
  if (v.length === 2) v += '/'
  e.target.value = v
  expiryDate.value = v
}

const formatCVV = (e) => {
  let v = e.target.value.replace(/[^0-9]/g, '')
  if (v.length > 3) v = v.slice(0, 3)
  e.target.value = v
  cvv.value = v
}

// Back
const goBack = () => router.push(`/snackOrder?showtimeId=${showtimeId}&movieId=${movieId}`)

// Pay & Create Booking
const payNow = async () => {
  if (!cardNumber.value || !expiryDate.value || !cvv.value || !cardholderName.value) {
    alert('Please fill all fields')
    return
  }

  const cleanCard = cardNumber.value.replace(/\s/g, '')
  if (cleanCard.length !== 16) return alert('Card must be 16 digits')
  if (cvv.value.length !== 3) return alert('CVV must be 3 digits')
  if (grandTotal.value <= 0) return alert('Invalid amount')

  // ✅ Save Booking to DB
  const bookingId = 'b-' + Date.now()
  const userId = localStorage.getItem('userId') || 'user-123'

  // const bookingData = {
  //   bookingId,
  //   userId,
  //   showtimeId,
  //   seatId: seatIds.value[0] // Use first seat (extend later)
  // }
  const bookingData = {
  bookingId,
  user: { userId },             // ✅ match JPA mapping
  showtime: { showtimeId },     // ✅ nested object
  seat: { seatId: seatIds.value[0] }
}

  try {
    await axios.post('http://localhost:8080/movieapplication/bookings/create', bookingData)
    console.log('✅ Booking saved:', bookingData)
  } catch (err) {
    console.error('❌ Failed to save booking:', err)
  }

  alert(`✅ Payment successful! Total: R${grandTotal.value.toFixed(2)}`)

  // Go to booking
  router.push({
    path: '/booking',
    query: {
      bookingId,
      total: grandTotal.value,
      movieId,
      showtimeId
    }
  })
}

// Init
onMounted(() => {
  seatIds.value = route.query.seatIds ? JSON.parse(route.query.seatIds) : []
  seatTotal.value = parseFloat(route.query.seatTotal) || 0
  snackTotal.value = parseFloat(route.query.snackTotal) || 0
  grandTotal.value = parseFloat(route.query.grandTotal) || 0

  fetchMovieAndShowtime()
})
</script>

<template>
  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
    <button @click="goBack" style="padding:6px 12px; background:#333; color:white; border:none; border-radius:6px; cursor:pointer;">
      ← Back
    </button>
    <h2 style="color: #BB86FC; margin: 0;">💳 Payment</h2>
    <div style="width: 80px;"></div>
  </div>

  <div style="max-width:900px; margin:0 auto; background:#121212; color:white; padding:30px; border-radius:12px;">
    <div style="display:flex; gap:30px;">
      <!-- Payment Form -->
      <div style="flex:1; background:#1f1f1f; padding:20px; border-radius:8px;">
        <h3 style="color:#ccc;">Payment Details</h3>
        <input v-model="cardNumber" @input="formatCardNumber" placeholder="1234 5678 9778 9787"
               style="width:100%; padding:10px; background:#2d2d2d; color:white; border:1px solid #555;" />
        <div style="display:flex; gap:10px; margin:15px 0;">
          <input v-model="expiryDate" @input="formatExpiryDate" placeholder="12/24"
                 style="flex:1; padding:10px; background:#2d2d2d; color:white; border:1px solid #555;" />
          <input v-model="cvv" @input="formatCVV" placeholder="471"
                 style="flex:1; padding:10px; background:#2d2d2d; color:white; border:1px solid #555;" />
        </div>
        <input v-model="cardholderName" placeholder="John Anthony"
               style="width:100%; padding:10px; background:#2d2d2d; color:white; border:1px solid #555;" />
        <button @click="payNow" :disabled="!cardNumber" style="width:100%; padding:12px; background:#BB86FC; color:white; border:none; margin-top:15px;">
          💳 Pay R{{ grandTotal.toFixed(2) }}
        </button>
      </div>

      <!-- Order Summary -->
      <div style="flex:1; background:#1f1f1f; padding:20px; border-radius:8px;">
        <h3 style="color:#ccc;">Order Summary</h3>
        <p><strong>{{ movieTitle }}</strong></p>
        <p>{{ showtimeDate }} at {{ showtimeTime }}</p>
        <p>Seats: {{ seatIds.join(', ') }}</p>
        <div style="border-top:1px solid #444; padding-top:10px;">
          <div style="display:flex; justify-content:space-between;"><span>Ticket Subtotal</span> <span>R{{ seatTotal }}</span></div>
          <div style="display:flex; justify-content:space-between;"><span>Snack Subtotal</span> <span>R{{ snackTotal }}</span></div>
          <div style="display:flex; justify-content:space-between; font-weight:bold; margin-top:10px;"><strong>Total</strong> <strong>R{{ grandTotal }}</strong></div>
        </div>
      </div>
    </div>
  </div>
</template>