<!-- File: src/components/Movie.vue -->
<script setup>
import { ref, onMounted, computed } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'


const movies = ref([])
const message = ref('Loading movies...')
const searchQuery = ref('')
const selectedGenre = ref('')

// Fetch all movies
const fetchMovies = async () => {
  try {
    const response = await axios.get('http://localhost:8080/movieapplication/movies/all')
    movies.value = response.data
    message.value = movies.value.length > 0 ? '' : 'No movies available'
  } catch (error) {
    message.value = `❌ Error: ${error.message}`
    console.error('Fetch Error:', error)
  }
}

// Filter movies by search and genre
const filteredMovies = computed(() => {
  return movies.value.filter(movie => {
    const matchesSearch =
      !searchQuery.value || movie.title.toLowerCase().includes(searchQuery.value.toLowerCase())
    const matchesGenre =
      !selectedGenre.value || movie.genre.includes(selectedGenre.value)
    return matchesSearch && matchesGenre
  })
})

const router = useRouter()

// Navigate to Showtime page
const selectMovie = (movie) => {
  router.push(`/showtimes?movieId=${movie.movieId}`)
}

onMounted(() => {
  fetchMovies()
})
</script>

<template>
  <div class="movies-container">
    <!-- Header -->
    <div class="header">
      <h1 class="movies-title">🎬 Movies</h1>
      <p class="movies-subtitle">
        Explore our selection of the latest blockbusters and timeless classics. Find your perfect movie experience.
      </p>
    </div>

    <!-- Search & Filters -->
    <div class="search-filters">
      <div class="search-bar">
        <input
          v-model="searchQuery"
          type="text"
          placeholder="Search movies by title..."
        />
      </div>

      <div class="genres-filters">
        <button
          v-for="genre in ['All', 'Sci-Fi', 'Adventure', 'Drama', 'Horror', 'Thriller', 'Mystery', 'Romance', 'Comedy', 'Action', 'Crime', 'Family']"
          :key="genre"
          @click="selectedGenre = genre === 'All' ? '' : genre"
          :class="{ 'active': selectedGenre === genre || (genre === 'All' && !selectedGenre) }"
        >
          {{ genre }}
        </button>
      </div>
    </div>

    <!-- Message -->
    <p v-if="message" class="error-message">{{ message }}</p>

    <!-- Movies Grid -->
    <div class="grid">
      <div
        v-for="movie in filteredMovies"
        :key="movie.movieId"
        @click="selectMovie(movie)"
        class="card"
        @mouseenter="e => e.target.style.transform = 'scale(1.03)'"
        @mouseleave="e => e.target.style.transform = 'scale(1)'"
      >
        <!--Movie Poster -->
        <div class="poster">
          <img
            :src="`https://picsum.photos/seed/${movie.movieId}/300/450`"
            alt="movie.title"
          />
          <div class="rating-badge">
            <span>★ {{ movie.rating || 4.5 }}</span>
          </div>
        </div>

        <!--Movie Info -->
        <div class="info">
          <h3 class="title">{{ movie.title }}</h3>
          <div class="genres-tags">
            <span
              v-for="genre in movie.genre.split(', ')"
              :key="genre"
            >
              {{ genre }}
            </span>
          </div>
          <div class="details">
            <span>⏱ {{ movie.duration }}</span>
            <span>📅 {{ movie.year }}</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.movies-container {
  max-width: 1200px;
  margin: 0 auto;
  font-family: 'Arial', sans-serif;
  background-color: #000000;
  color: white;
  padding: 30px;
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.5);
  min-height: 100vh; /* keeps layout in place */
}

.header {
  text-align: left;
  margin-bottom: 20px;
  position: sticky;
  top: 0;
  background: #000000;
  z-index: 10;
  padding-bottom: 10px;
}

.search-filters {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 15px;
  margin-bottom: 20px;
}

.search-bar {
  width: 300px;
}

.search-bar input {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 6px;
  background: #2d2d2d;
  color: white;
  font-size: 14px;
}

.genres-filters {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
}

.genres-filters button {
  padding: 6px 12px;
  border: 1px solid #444;
  border-radius: 6px;
  background: #2d2d2d;
  color: #ccc;
  cursor: pointer;
  font-size: 12px;
  transition: all 0.2s ease;
}

.genres-filters button:hover,
.genres-filters button.active {
  background: #03DAC6;
  color: white;
  border-color: #03dac6;
}

.error-message {
  text-align: center;
  color: #CF6679;
  font-size: 14px;
  margin-bottom: 20px;
}

/* Grid Layout */
.grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 25px;
  padding: 10px;
  box-sizing: border-box;
  min-height: 300px;
}

.card {
  border: 1px solid #333;
  border-radius: 10px;
  overflow: hidden;
  background-color: #1f1f1f;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  cursor: pointer;
}

.poster {
  position: relative;
  height: 300px;
  background: linear-gradient(45deg, #3700B3, #03DAC6);
  display: flex;
  align-items: center;
  justify-content: center;
}

.poster img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.rating-badge {
  position: absolute;
  top: 10px;
  right: 10px;
  background: #FFD700;
  color: black;
  padding: 2px 6px;
  border-radius: 6px;
  font-size: 10px;
  font-weight: bold;
}

.info {
  padding: 15px;
}

.title {
  margin: 0;
  color: #BB86FC;
  font-size: 18px;
  font-weight: bold;
}

.genres-tags {
  display: flex;
  gap: 4px;
  margin-bottom: 8px;
  flex-wrap: wrap;
}

.genres-tags span {
  background: #444;
  color: #ccc;
  padding: 2px 8px;
  border-radius: 4px;
  font-size: 10px;
}

.details {
  display: flex;
  gap: 10px;
  color: #ccc;
  font-size: 12px;
}

body {
  background-color: #000;
  margin: 0;
  padding: 0;
}
</style>
