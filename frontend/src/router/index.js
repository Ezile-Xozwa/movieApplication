// File: src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'

// Import your components
import Movies from '../components/Movie.vue'
import Showtimes from '../components/Showtimes.vue'
import Seat from '../components/Seat.vue'  // ← Add this
import SnackOrder from '../components/SnackOrder.vue'
import Payment from '../components/Payment.vue'
import Review from '../components/Review.vue' // ✅ Add this line


// Define routes
const routes = [
  {
    path: '/movies',
    name: 'Movies',
    component: Movies
  },
  {
    path: '/showtimes',
    name: 'Showtimes',
    component: Showtimes
  },
  {
    path: '/seats',  // ← Must match the URL
    name: 'Seats',
    component: Seat  // ← Now registered
  },
  /*{
  path: '/snacks',
  name: 'Snacks',
  component: SnackOrder
}*/
{
    path: '/snackOrder',  // ← Fixed: was '/snacks'
    name: 'SnackOrder',
    component: SnackOrder
  },
  {
  path: '/payment',
  name: 'Payment',
  component: Payment
},
{
  path: '/booking',
  name: 'Booking',
  component: () => import('../components/Booking.vue')
},
{
  path: '/review',
  name: 'Review',
  component: Review
},
{
  path: '/register',
  name: 'Register',
  component: () => import('../components/Register.vue')
},
{
  path: '/',
  name: 'Login',
  component: () => import('../components/Login.vue')
}
]

// Create router
const router = createRouter({
  history: createWebHistory(), // Uses clean URLs like /showtimes instead of #/showtimes
  routes
})

export default router