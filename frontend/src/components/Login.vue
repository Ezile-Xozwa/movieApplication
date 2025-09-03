<!-- File: src/components/Login.vue -->
<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const router = useRouter()

// Form data
const email = ref('')
const password = ref('')
const error = ref('')

// Submit login
const login = async () => {
  if (!email.value || !password.value) {
    error.value = 'Please enter email and password'
    return
  }

  try {
    // Step 1: Find login by email
    const response = await axios.get(`http://localhost:8080/movieapplication/logins/email/${email.value}`)
    const loginData = response.data

    // Step 2: Check password
    if (loginData.password === password.value) {
      console.log('✅ Login successful:', loginData)

      const userId = loginData.user?.userId
  if (!userId) {
    error.value = 'Login failed: user data missing'
    return
  }

  // ✅ Correct: Save real userId
  localStorage.setItem('userId', userId)
      
      // ✅ Fix: Use userId from user, not login
  localStorage.setItem('user', JSON.stringify({
    userId: userId,           // ✅ Correct
    email: loginData.email,
    role: loginData.role
  }))

      router.push('/movies')
    } else {
      error.value = 'Invalid password'
    }
  } catch (err) {
    error.value = 'Account not found. Please register.'
    console.error('Login failed:', err)
  }
}
</script>

<template>
  <!-- Header -->
  <div style="text-align: center; margin-bottom: 40px;">
    <h1 style="color: #BB86FC; margin: 0;">🎬 CineBook</h1>
    <p style="color: #ccc; font-size: 12px; margin-top: 5px;">Book your movie experience</p>
  </div>

  <!-- Card -->
  <div style="
    max-width: 400px;
    margin: 0 auto;
    background-color: #1f1f1f;
    border-radius: 12px;
    box-shadow: 0 4px 20px rgba(0,0,0,0.5);
    padding: 30px;
    border: 1px solid #333;
  ">
    <h2 style="color: #BB86FC; margin: 0 0 10px 0;">Welcome back</h2>
    <p style="color: #ccc; font-size: 12px; margin: 0 0 20px 0;">Enter your credentials to sign in</p>

    <!-- Error -->
    <div v-if="error" style="color: #CF6679; font-size: 12px; margin-bottom: 15px;">
      {{ error }}
    </div>

    <!-- Email -->
    <div style="margin-bottom: 15px;">
      <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">Email</label>
      <input
        v-model="email"
        type="email"
        placeholder="name@example.com"
        style="
          width: 100%;
          padding: 10px;
          border: 1px solid #555;
          border-radius: 6px;
          background-color: #2d2d2d;
          color: white;
          font-size: 14px;
        "
      />
    </div>

    <!-- Password -->
    <div style="margin-bottom: 15px;">
      <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">Password</label>
      <input
        v-model="password"
        type="password"
        placeholder="••••••••"
        style="
          width: 100%;
          padding: 10px;
          border: 1px solid #555;
          border-radius: 6px;
          background-color: #2d2d2d;
          color: white;
          font-size: 14px;
        "
      />
    </div>

    <!-- Login Button -->
    <button
      @click="login"
      style="
        width: 100%;
        padding: 12px;
        background: #BB86FC;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 14px;
        font-weight: bold;
        cursor: pointer;
      "
    >
      📤 Sign In
    </button>

    <!-- Register Link -->
    <div style="margin-top: 15px; text-align: center;">
      <small style="color: #ccc;">Don't have an account?</small>
      <br />
      <a
        href="#"
        @click="$router.push('/register')"
        style="color: #03DAC6; font-size: 14px; text-decoration: underline; cursor: pointer;"
      >
        Create one
      </a>
    </div>
  </div>

  <!-- Footer -->
  <div style="text-align: center; margin-top: 30px; color: #ccc; font-size: 10px;">
    © 2025 CineBook. All rights reserved.
  </div>
</template>

<style scoped>
body {
  background-color: #000;
  margin: 0;
  padding: 20px;
  font-family: 'Arial', sans-serif;
}
</style>