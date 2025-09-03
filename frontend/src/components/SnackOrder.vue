<!-- File: src/components/SnackOrder.vue -->
<script setup>
import { ref, onMounted, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const route = useRoute()
const router = useRouter()

// Get query params
const movieId = route.query.movieId
const showtimeId = route.query.showtimeId

// User's order
const order = ref({})
const selectedSeats = ref([]) // ← Will be passed from Seats
const seatTotal = ref(0) // ← Will be passed from Seats
const snackTotal = ref(0)
const grandTotal = computed(() => seatTotal.value + snackTotal.value)

//const snacks = ref([]) // ← This fixes it!
const snacks = ref([
  { id: 'popcorn', name: '🍿 Popcorn', price: 12.99 },
  { id: 'soda', name: '🥤 Soda', price: 8.99 },
  { id: 'nachos', name: '🧀 Nachos', price: 15.99 },
  { id: 'candy', name: '🍬 Candy', price: 6.99 },
  { id: 'hotdog', name: '🌭 Hotdog', price: 10.99 }
])

const specialInstructions = ref({})

// Sample snacks (later: fetch from API)
/*const snacks = ref([
  { id: 'popcorn', name: '🍿 Popcorn', price: 12.99 },
  { id: 'soda', name: '🥤 Soda', price: 8.99 },
  { id: 'nachos', name: '🧀 Nachos', price: 15.99 },
  { id: 'candy', name: '🍬 Candy', price: 6.99 },
  { id: 'hotdog', name: '🌭 Hotdog', price: 10.99 }
])*/

// const fetchSnacks = async () => {
//   try {
//     // ✅ Fetch all snack orders
//     const response = await axios.get('http://localhost:8080/movieapplication/snackorders/all')
    
//     // 🧮 Map to calculate price per snack
//     const snackMap = new Map()

//     response.data.forEach(order => {
//       const { snackId, quantity, totalPrice } = order
      
//       // Skip if invalid
//       if (!snackId || quantity <= 0) return

//       // Calculate price per unit
//       const unitPrice = totalPrice / quantity

//       // Only store the first one (we just need the price)
//       if (!snackMap.has(snackId)) {
//         snackMap.set(snackId, {
//           id: snackId,
//           name: snackId.charAt(0).toUpperCase() + snackId.slice(1), // "popcorn" → "Popcorn"
//           price: parseFloat(unitPrice.toFixed(2))
//         })
//       }
//     })

//     // ✅ Set snacks for UI
//     snacks.value = Array.from(snackMap.values())
//     console.log('🍟 Snacks loaded:', snacks.value)
//   } catch (error) {
//     console.error('Failed to load snacks:', error)
//     console.error('Response data:', error.response?.data)
//     console.error('Status:', error.response?.status)
//     // ✅ Fallback if API fails
//     snacks.value = [
//       { id: 'popcorn', name: 'Popcorn', price: 12.99 },
//       { id: 'soda', name: 'Soda', price: 8.99 },
//       { id: 'nachos', name: 'Nachos', price: 15.99 },
//       { id: 'candy', name: 'Candy', price: 6.99 },
//       { id: 'hotdog', name: 'Hotdog', price: 10.99 }
//     ]
//   }
// }

// onMounted(async () => {
//   console.log('🔧 SnackOrder mounted')
//   console.log('📦 Query:', route.query)

//   // Get seat data from query
//   const seatIds = route.query.seatIds ? JSON.parse(route.query.seatIds) : []
//   const total = route.query.seatTotal ? parseFloat(route.query.seatTotal) : 0

//   selectedSeats.value = seatIds
//   seatTotal.value = total

//   console.log('🚀 Seat total:', seatTotal.value)

//   // Fetch snacks first
//   await fetchSnacks()

//   // Initialize order quantities
//   snacks.value.forEach(snack => {
//     order.value[snack.id] = 0
//   })

//   calculateTotal() // Update totals
// })

onMounted(() => {
  console.log('🔧 SnackOrder mounted')
  console.log('📦 Query:', route.query)

  // Get seat data from query
  const seatIds = route.query.seatIds ? JSON.parse(route.query.seatIds) : []
  const total = route.query.seatTotal ? parseFloat(route.query.seatTotal) : 0

  selectedSeats.value = seatIds
  seatTotal.value = total

  // Initialize order quantities
  snacks.value.forEach(snack => {
    order.value[snack.id] = 0
  })

  calculateTotal()
})


// ✅ Add this function
const updateInstructions = (snackId, value) => {
  specialInstructions.value[snackId] = value || 'None'
}

// Update quantity
const updateQuantity = (snackId, change) => {
  if (!order.value[snackId]) order.value[snackId] = 0
  const newQty = order.value[snackId] + change
  if (newQty >= 0) {
    order.value[snackId] = newQty
    calculateTotal()
  }
}


// Calculate total
const calculateTotal = () => {
  let snacksTotal = 0
  snacks.value.forEach(snack => {
    snacksTotal += snack.price * order.value[snack.id]
  })
  snackTotal.value = snacksTotal
}

// Proceed to Payment
/*const proceedToPayments = () => {
  const orderItems = snacks.value
    .filter(s => order.value[s.id] > 0)
    .map(s => `${order.value[s.id]}x ${s.name}`)
    .join(', ')

  alert(
    `Order Summary:\n` +
    `Seats: ${selectedSeats.value.join(', ') || 'None'} (R${seatTotal.value})\n` +
    `Sections: ${orderItems || 'None'}\n` +
    `Total: R${grandTotal.value}\n\n` +
    `Proceeding to payment...`
  )
  // Later: router.push('/payment')
}*/

const proceedToPayment = async () => {
  const selectedSnacks = snacks.value
    .filter(s => order.value[s.id] > 0)
    .map(s => ({
      snackId: s.id,
      quantity: order.value[s.id],
      totalPrice: s.price * order.value[s.id]
    }))


    //MAYBE, MAYBE OR NOT
  // if (selectedSnacks.length === 0) {
  //   alert('Please select at least one snack')
  //   return
  // }

  // Use real bookingId from route or generate
  const bookingId = route.query.bookingId || 'temp-' + Date.now()

  for (const snack of selectedSnacks) {
    const payload = {
      snackOrderId: 'snack-' + Date.now() + '-' + snack.snackId,
      bookingId: bookingId,
      snackId: snack.snackId,
      quantity: snack.quantity,
      totalPrice: snack.totalPrice,
      orderTime: new Date().toISOString(),
      // ✅ Use user input or default to 'None'
      specialInstructions: specialInstructions.value[snack.snackId] || 'None'
    }

    try {
      await axios.post('http://localhost:8080/movieapplication/snackorders/create', payload)
      console.log('✅ Snack order saved:', payload)
    } catch (error) {
      console.error('❌ Failed to save snack order:', error)
      alert(`Failed to order ${snack.snackId}`)
    }
  }

router.push({
  path: '/payment',
  query: {
    movieId,
    showtimeId,
    seatIds: JSON.stringify(selectedSeats.value),
    seatTotal: seatTotal.value.toString(),
    snackTotal: snackTotal.value.toString(),
    grandTotal: grandTotal.value.toString()
  }
})

}
// Back to Seats
const goBack = () => {
  router.push(`/seats?showtimeId=${showtimeId}&movieId=${movieId}`)
}

// Initialize order quantities
/*onMounted(() => {
  console.log('🔧 SnackOrder mounted')
  console.log('📦 Query:', route.query)

  const seatIds = route.query.seatIds ? JSON.parse(route.query.seatIds) : []
  const total = route.query.seatTotal ? parseFloat(route.query.seatTotal) : 0

  selectedSeats.value = seatIds
  seatTotal.value = total

  snacks.value.forEach(snack => {
    order.value[snack.id] = 0
  })

  calculateTotal() // Initialize snackTotal
})*/

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
    <h2 style="color: #BB86FC; margin: 0;">🍿 Snack Order</h2>
    <div style="width: 80px;"></div> <!-- Spacer -->
  </div>

  <!-- Main Container -->
  <div style="
    max-width: 900px;
    margin: 0 auto;
    font-family: 'Arial', sans-serif;
    background-color: #121212;
    color: white;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0 4px 20px rgba(0,0,0,0.5);
  ">

    <!-- Order Summary (Top) -->
    <div style="
      background-color: #1f1f1f;
      padding: 15px;
      border-radius: 8px;
      margin-bottom: 30px;
      font-size: 14px;
    ">
      <p><strong>Seats:</strong> {{ selectedSeats.length > 0 ? selectedSeats.join(', ') : 'None' }} (R{{ seatTotal.value }})</p>
      <p><strong>Subtotal:</strong> R{{ snackTotal }}</p>
      <p><strong>Total (with seats):</strong> R{{ grandTotal }}</p>
    </div>

    <!-- Snacks List -->
    <div style="display: grid; gap: 20px; margin-bottom: 40px;">
      <div
          v-for="snack in snacks"
          :key="snack.id"
          style="
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 15px;
            background-color: #1f1f1f;
            border-radius: 8px;
            border: 1px solid #333;
          "
      >
        <div>
          <strong>{{ snack.name }}</strong>
          <span style="color: #03DAC6;"> — R{{ snack.price }}</span>
        </div>

       <!-- Quantity Controls -->
<div style="display: flex; align-items: center; gap: 10px;">
  <button @click="updateQuantity(snack.id, -1)">−</button>
  <span style="min-width: 30px; text-align: center;">{{ order[snack.id] || 0 }}</span>
  <button @click="updateQuantity(snack.id, 1)">+</button>
</div>

<!-- ✅ Special Instructions Input -->
<input
  type="text"
  placeholder="Special instructions (e.g. No ice)"
  style="width: 100%; margin-top: 10px; padding: 6px; border-radius: 4px; border: 1px solid #555;"
  @input="($event) => updateInstructions(snack.id, $event.target.value)"
/>

      </div>
    </div>

    <!-- Proceed Button -->
    <div style="text-align: center; margin-top: 30px;">
      <button
          @click="proceedToPayment"
          :disabled="seatTotal === 0"
          :style="{
            padding: '12px 30px',
            backgroundColor: seatTotal > 0 ? '#03DAC6' : '#555',
            color: seatTotal > 0 ? 'black' : 'gray',
            border: 'none',
            borderRadius: '6px',
            fontSize: '16px',
            fontWeight: 'bold',
            cursor: seatTotal > 0 ? 'pointer' : 'not-allowed'
          }"
      >
        💳 Proceed to Payment (R{{ grandTotal.value }})
      </button>
    </div>
  </div>
</template>

<style scoped>
body {
  background-color: #000;
  margin: 0;
  padding: 0;
}
</style>