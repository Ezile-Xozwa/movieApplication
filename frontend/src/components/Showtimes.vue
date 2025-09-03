<!-- File: src/components/Showtimes.vue -->
<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

const route = useRoute()
const router = useRouter()

// Get movieId from route
const movieId = route.query.movieId
const movie = ref({})
const showtimes = ref([])
const message = ref('Loading showtimes...')

// Fetch movie and its showtimes
const fetchMovie = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/movieapplication/movies/read/${movieId}`)
    movie.value = response.data
  } catch (error) {
    message.value = `❌ Could not load movie: ${error.message}`
  }
}

const fetchShowtimes = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/movieapplication/showtimes/movie/${movieId}`)
    showtimes.value = response.data.slice(0, 3) // ← Only show first 3 showtimes
    message.value = showtimes.value.length > 0 ? '' : 'No showtimes available for this movie.'
  } catch (error) {
    message.value = `❌ Error: ${error.message}`
    console.error('Fetch Showtimes Error:', error)
  }
}

// Go to Seat Selection
const selectShowtime = (showtime) => {
  router.push(`/seats?showtimeId=${showtime.showtimeId}&movieId=${movieId}`)
}

const goBackToMovies = () => {
  router.push('/movies')
}

// const goToReview = () => {
//   router.push('/review')
// }

const goToReview = () => {
  router.push(`/review?movieId=${movie.value.movieId}`)
}

onMounted(async() => {
  if (!movieId) {
    message.value = '❌ No movie selected. Go back to Movies.'
    return
  }

  try {
    await fetchMovie()
    await fetchShowtimes()
  } catch (error) {
    message.value = `❌ Failed to load data: ${error.message}`
    console.error('Load Error', error)
  }
  
})

</script>

<template>
  <div class="showtimes-container">
    <!-- Header -->
    <div class="header">
      <button @click="goBackToMovies" class="back-button">
  ← Back
</button>
    </div>

    <!-- Movie Card -->
    <!-- <div class="movie-card"> -->
    <div v-if="movie.title" class="movie-card">
      <img
        :src="`https://picsum.photos/seed/${movie.movieId}/300/450`"
        alt="Movie Poster"
        class="movie-poster"
      />

      <div class="movie-info">
        <h1 class="movie-title">{{ movie.title }}</h1>
        <div class="movie-meta">
          <span class="rating-badge">
            ★ {{ movie.rating || 4.5 }}
          </span>
          <span class="duration">⏱ {{ movie.duration }}</span>
          <span class="year">📅 2025</span>
        </div>
        <div class="genres">
          <span v-for="genre in movie.genre.split(', ')" :key="genre" class="genre-tag">
            {{ genre }}
          </span>
        </div>
        <p class="description">
          {{ movie.description || 'A thrilling adventure awaits.' }}
        </p>
        <button class="review-btn" @click="goToReview">
          Review
        </button>
      </div>
    </div>

    <!-- Showtimes Section -->
    <!--<div class="section">-->
    <div v-if="movie.title" class="section">
      <h2 class="section-title">📅 Showtimes</h2>
      <p v-if="message" class="error-message">{{ message }}</p>

      <div class="showtimes-list">
        <div
          v-for="showtime in showtimes"
          :key="showtime.showtimeId"
          @click="selectShowtime(showtime)"
          class="showtime-item"
        >
          <div class="showtime-header">
            <span class="date">
              {{ new Date(showtime.date).toLocaleDateString() }}
            </span>
            <span class="time">
              {{ new Date(showtime.startTime).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }) }}
            </span>
          </div>
          <button class="select-btn">Select Seats</button>
        </div>
      </div>
    </div>

    <!-- Loading or Error Message -->
<div v-else class="error-message">
  {{ message || 'Loading movie details...' }}
</div>

  </div>
</template>

<style scoped>
.showtimes-container {
  max-width: 1000px;
  margin: 40px auto;
  font-family: 'Arial', sans-serif;
  background-color: #000;
  color: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.5);
  min-height: 100vh;
}

.header {
  display: flex;
  gap: 10px;
  align-items: center;
  margin-bottom: 30px;
}

.back-button {
  padding: 6px 12px;
  background: #333;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 14px;
}

.movie-card {
  display: flex;
  gap: 30px;
  background: linear-gradient(45deg, #3700B3, #03DAC6);
  padding: 20px;
  border-radius: 12px;
  margin-bottom: 40px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.3);
}

.movie-poster {
  width: 300px;
  height: 450px;
  object-fit: cover;
  border-radius: 8px;
}

.movie-info {
  flex: 1;
  padding: 20px;
}

.movie-title {
  color: #BB86FC;
  margin: 0;
  font-size: 2em;
  margin-bottom: 10px;
}

.movie-meta {
  display: flex;
  gap: 10px;
  margin-bottom: 10px;
  font-size: 14px;
}

.rating-badge {
  background: #FFD700;
  color: black;
  padding: 2px 6px;
  border-radius: 6px;
  font-size: 12px;
  font-weight: bold;
}

.duration, .date {
  color: #ccc;
}

.genres {
  display: flex;
  gap: 6px;
  margin-bottom: 15px;
}

.genre-tag {
  background: #444;
  color: #ccc;
  padding: 2px 8px;
  border-radius: 6px;
  font-size: 12px;
}

.description {
  color: #ccc;
  line-height: 1.5;
  margin-bottom: 20px;
}

.review-btn {
  width: 100%;
  padding: 10px;
  background: #03DAC6;
  color: black;
  border: none;
  border-radius: 6px;
  font-weight: bold;
  cursor: pointer;
}

.section {
  margin-top: 40px;
}

.section-title {
  text-align: left;
  color: #BB86FC;
  font-size: 1.5em;
  margin-bottom: 20px;
}

.error-message {
  text-align: center;
  color: #CF6679;
  font-size: 14px;
  margin-bottom: 20px;
}

.showtimes-list {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.showtime-item {
  border: 1px solid #333;
  border-radius: 10px;
  padding: 15px;
  background: #1f1f1f;
  transition: transform 0.2s ease;
  cursor: pointer;
}

.showtime-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.date {
  color: #ccc;
  font-size: 14px;
}

.time {
  color: #BB86FC;
  font-size: 16px;
  font-weight: bold;
}

.select-btn {
  width: 100%;
  padding: 8px;
  background: #03DAC6;
  color: black;
  border: none;
  border-radius: 6px;
  font-weight: bold;
  cursor: pointer;
}
</style>