<!-- File: src/components/Register.vue -->
<script setup>
import { ref } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'

const router = useRouter()

// Form data
const name = ref('')
const surname = ref('')
const email = ref('')
const password = ref('')
const confirmPassword = ref('')
const phoneNumber = ref('')
const dateOfBirth = ref('')
const gender = ref('')

const error = ref('')

// Validate form
const validateForm = () => {
  if (!name.value || !surname.value || !email.value || !password.value || !phoneNumber.value || !dateOfBirth.value || !gender.value) {
    error.value = 'All fields are required'
    return false
  }
  if (password.value !== confirmPassword.value) {
    error.value = 'Passwords do not match'
    return false
  }
  if (password.value.length < 6) {
    error.value = 'Password must be at least 6 characters'
    return false
  }
  if (!/^\d{10}$/.test(phoneNumber.value)) {
    error.value = 'Phone number must be 10 digits'
    return false
  }
  return true
}

const registerUser = async () => {
  if (!validateForm()) return

  const userData = {
    userId: 'user-' + Date.now(),
    name: name.value,
    surname: surname.value,
    email: email.value,
    password: password.value,
    phoneNumber: phoneNumber.value,
    dateOfBirth: dateOfBirth.value,
    gender: gender.value
  }

  try {
    // Step 1: Create User
    const userResponse = await axios.post('http://localhost:8080/movieapplication/users/create', userData)
    console.log('✅ User created:', userResponse.data)

    // Step 2: Create Login
    const loginData = {
      loginId: userData.userId,
      email: userData.email,
      password: userData.password,
      role: "Customer",
      user: { userId: userData.userId }
    }

    try {
      const loginResponse = await axios.post('http://localhost:8080/movieapplication/logins/create', loginData)
      console.log('✅ Login created:', loginResponse.data)
    } catch (loginErr) {
      console.error('⚠️ Login creation failed:', loginErr)
      // Still continue — user exists
    }

    alert('✅ Account created! Please log in.')
    router.push('/') // Go back to login

  } catch (err) {
    error.value = 'Registration failed. Try again.'
    console.error('Registration error:', err)
    if (err.response) {
      console.error('Response data:', err.response.data)
    }
  }
}
</script>

<template>
  <!-- Header -->
  <div style="text-align: center; margin-bottom: 40px;">
    <img src="https://picsum.photos/seed/cinebook/200/50" alt="CineBook Logo" style="width: 100px; height: auto;" />
    <p style="color: #ccc; font-size: 12px; margin-top: 5px;">Book your movie experience in seconds</p>
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
    <!-- Tabs -->
    <div style="display: flex; border-bottom: 1px solid #333;">
      <button
        @click="$router.push('/')"
        style="
          flex: 1;
          padding: 10px;
          background: #1f1f1f;
          color: #ccc;
          border: none;
          border-bottom: 2px solid #333;
          cursor: pointer;
          font-size: 12px;
        "
      >
        Sign In
      </button>
      <button
        style="
          flex: 1;
          padding: 10px;
          background: #BB86FC;
          color: white;
          border: none;
          border-bottom: 2px solid #BB86FC;
          cursor: pointer;
          font-size: 12px;
        "
      >
        Register
      </button>
    </div>

    <!-- Form -->
    <div style="margin-top: 20px;">
      <h2 style="color: #BB86FC; margin: 0 0 10px 0;">Create an account</h2>
      <p style="color: #ccc; font-size: 12px; margin: 0 0 20px 0;">Enter your full details to register</p>

      <!-- Name & Surname -->
      <div style="display: flex; gap: 10px; margin-bottom: 15px;">
        <div style="flex: 1;">
          <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">First Name</label>
          <input
            v-model="name"
            type="text"
            placeholder="John"
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
        <div style="flex: 1;">
          <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">Surname</label>
          <input
            v-model="surname"
            type="text"
            placeholder="Doe"
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

      <!-- Phone Number -->
      <div style="margin-bottom: 15px;">
        <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">Phone Number</label>
        <input
          v-model="phoneNumber"
          type="tel"
          placeholder="0712345678"
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

      <!-- Date of Birth -->
      <div style="margin-bottom: 15px;">
        <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">Date of Birth</label>
        <input
          v-model="dateOfBirth"
          type="date"
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

      <!-- Gender -->
      <div style="margin-bottom: 15px;">
        <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">Gender</label>
        <select
          v-model="gender"
          style="
            width: 100%;
            padding: 10px;
            border: 1px solid #555;
            border-radius: 6px;
            background-color: #2d2d2d;
            color: white;
            font-size: 14px;
          "
        >
          <option value="" disabled>Select gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
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

      <!-- Confirm Password -->
      <div style="margin-bottom: 15px;">
        <label style="display: block; color: #ccc; font-size: 12px; margin-bottom: 5px;">Confirm Password</label>
        <input
          v-model="confirmPassword"
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

      <!-- Error -->
      <div v-if="error" style="color: #CF6679; font-size: 12px; margin-bottom: 15px;">
        {{ error }}
      </div>

      <!-- Register Button -->
      <button
        @click="registerUser"
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
        📤 Create Account
      </button>
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