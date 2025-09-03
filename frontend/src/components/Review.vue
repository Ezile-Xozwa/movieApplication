<!-- src/components/Review.vue -->
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
    <h2 style="color: #BB86FC; margin: 0;">📝 Write a Review</h2>
    <div style="width: 80px;"></div>
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

    <!-- New Review Form -->
    <div style="background-color: #1f1f1f; padding: 20px; border-radius: 8px; margin-bottom: 30px;">
      <h3 style="color: #BB86FC; margin: 0 0 15px 0;">Rate This Movie</h3>

      <form @submit.prevent="submitReview" style="display: flex; flex-direction: column; gap: 15px;">
        <!-- Rating -->
        <div>
          <label style="display: block; margin-bottom: 5px; color: #ccc; font-size: 14px;">Rating (1-5 Stars)</label>
          <select
            v-model="rating"
            style="
              width: 100%;
              padding: 10px;
              border: 1px solid #555;
              border-radius: 4px;
              background-color: #2d2d2d;
              color: white;
              font-size: 14px;
            "
            required
          >
            <option value="" disabled>Select a rating</option>
            <option value="1">1 - Poor</option>
            <option value="2">2 - Fair</option>
            <option value="3">3 - Good</option>
            <option value="4">4 - Very Good</option>
            <option value="5">5 - Excellent</option>
          </select>
        </div>

        <!-- Comment -->
        <div>
          <label style="display: block; margin-bottom: 5px; color: #ccc; font-size: 14px;">Your Review</label>
          <textarea
            v-model="comment"
            rows="4"
            placeholder="Share your thoughts..."
            style="
              width: 100%;
              padding: 10px;
              border: 1px solid #555;
              border-radius: 4px;
              background-color: #2d2d2d;
              color: white;
              font-size: 14px;
              resize: vertical;
            "
            required
          ></textarea>
        </div>

        <!-- Spoiler Toggle -->
        <div>
          <label style="display: block; margin-bottom: 5px; color: #ccc; font-size: 14px;">Does this review contain spoilers?</label>
          <div style="display: flex; gap: 20px; align-items: center;">
            <label style="color: #ccc;">
              <input type="radio" v-model="spoiler" :value="true" /> Yes
            </label>
            <label style="color: #ccc;">
              <input type="radio" v-model="spoiler" :value="false" /> No
            </label>
          </div>
        </div>

        <!-- Submit Button -->
        <button
          type="submit"
          style="
            padding: 12px;
            background-color: #03DAC6;
            color: black;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
          "
        >
          📤 Submit Review
        </button>
      </form>
    </div>

    <!-- Previous Reviews -->
    <div style="background-color: #1f1f1f; padding: 20px; border-radius: 8px;">
      <h3 style="color: #BB86FC; margin: 0 0 15px 0;">Recent Reviews</h3>

      <!-- No Reviews -->
      <div v-if="reviews.length === 0" style="text-align: center; color: #ccc; font-style: italic; padding: 20px;">
        🎬 No reviews yet. Be the first to share!
      </div>

      <!-- Scrollable Reviews List -->
      <div style="
        max-height: 300px;
        overflow-y: auto;
        border: 1px solid #333;
        border-radius: 6px;
        padding: 10px;
        background-color: #1a1a1a;
      ">
        <div
          v-for="review in reviews"
          :key="review.reviewId"
          style="
            background-color: #2d2d2d;
            padding: 12px;
            border-radius: 6px;
            margin-bottom: 10px;
            border-left: 3px solid #BB86FC;
          "
        >
          <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 6px;">
            <strong style="color: #BB86FC;">{{ review.movie?.title || 'Unknown Movie' }}</strong>
            <span style="font-size: 14px;" v-html="renderStars(review.rating)"></span>
          </div>
          <p style="margin: 5px 0; color: #ccc; font-size: 14px;">“{{ review.comment }}”</p>
          <small style="color: #777; font-size: 12px;">
            {{ new Date(review.timestamp).toLocaleDateString() }}
            <span v-if="review.spoiler === 'SPOILER'" style="color: #CF6679; font-weight: bold;"> 🔒 Spoiler</span>
          </small>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

// Form data
const rating = ref('')
const comment = ref('')
const spoiler = ref(false)
const reviews = ref([])

// Get movieId from route (you should pass it)
const movieId = route.query.movieId || '6cadafeb-be52-4eca-9582-77113e5f2e27'
const userId = localStorage.getItem('userId') || 'user-123' // Should come from login

// 🔥 Add this line to debug
console.log('🔍 Current userId in Review.vue:', userId)

// Load reviews
const loadReviews = async () => {
  try {
    const response = await axios.get('http://localhost:8080/movieapplication/reviews/all')
    reviews.value = response.data.filter(r => r.movie?.movieId === movieId)
  } catch (error) {
    console.error('Failed to load reviews:', error)
    alert('Could not load reviews.')
  }
}

// Submit review
const submitReview = async () => {
  if (!rating.value || !comment.value) {
    alert('Please fill in all fields')
    return
  }

  const payload = {
    reviewId: 'rev-' + Date.now(),
    user: { userId: userId },
    movie: { movieId: movieId },
    rating: Number(rating.value),
    comment: comment.value,
    timestamp: new Date().toISOString(),
    spoiler: spoiler.value ? 'SPOILER' : 'NOT_SPOILER'
  }

  try {
    const response = await axios.post('http://localhost:8080/movieapplication/reviews/create', payload)
    reviews.value.unshift(response.data)
    rating.value = ''
    comment.value = ''
    spoiler.value = false
    alert('✅ Thank you for your review!')
  } catch (error) {
    console.error('Error submitting review:', error)
    alert('Failed to submit review.')
  }
}

// Render stars
const renderStars = (rating) => {
  const full = '★'.repeat(Math.floor(rating))
  const half = rating % 1 >= 0.5 ? '★' : ''
  const empty = '☆'.repeat(5 - Math.ceil(rating))
  return full + half + empty
}

// Go back
const goBack = () => {
  router.back()
}

onMounted(() => {
  loadReviews()
})
</script>

<style scoped>
body {
  background-color: #000;
  margin: 0;
  padding: 0;
}

/* Custom scrollbar */
div[style*="overflow-y: auto"]::-webkit-scrollbar {
  width: 6px;
}

div[style*="overflow-y: auto"]::-webkit-scrollbar-track {
  background: #1a1a1a;
  border-radius: 10px;
}

div[style*="overflow-y: auto"]::-webkit-scrollbar-thumb {
  background: #03DAC6;
  border-radius: 10px;
}
</style>