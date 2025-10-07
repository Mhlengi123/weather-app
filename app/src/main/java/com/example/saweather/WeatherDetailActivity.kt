package com.yourteam.saweather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.yourteam.saweather.databinding.ActivityWeatherDetailBinding

class WeatherDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherDetailBinding
    private val TAG = "WeatherDetailActivity"
    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            // Use XML layout with buttons
            binding = ActivityWeatherDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            Log.d(TAG, "WeatherDetailActivity with XML layout loaded")

            // Check if user is actually logged in
            checkUserAuthentication()

            setupWeatherData()
            setupClickListeners()

            Toast.makeText(this, "Welcome to SAWeather! 🎉", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            Log.e(TAG, "Error loading dashboard: ${e.message}", e)
            Toast.makeText(this, "Error loading dashboard", Toast.LENGTH_LONG).show()
            // Fall back to simple layout
            createFallbackLayout()
        }
    }

    private fun checkUserAuthentication() {
        val currentUser = auth.currentUser
        if (currentUser == null) {
            Log.w(TAG, "User not authenticated, redirecting to login")
            redirectToLogin()
            return
        }
        Log.d(TAG, "User authenticated: ${currentUser.email}")
    }

    private fun setupWeatherData() {
        // Set sample weather data
        binding.tvLocation.text = "Durban, South Africa"
        binding.tvTemperature.text = "21°C"
        binding.tvCondition.text = "Partly Cloudy"
        binding.tvHumidity.text = "💧 Humidity: 73%"
        binding.tvWind.text = "💨 Wind: 5 km/h"

        // Display current user email if available
        val currentUser = auth.currentUser
        currentUser?.email?.let { email ->
            binding.tvUserEmail.text = "Logged in as: $email"
        }
    }

    private fun setupClickListeners() {
        // Locations Button
        binding.btnLocations.setOnClickListener {
            Toast.makeText(this, "Opening Locations...", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(this, LocationsActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Locations screen coming soon", Toast.LENGTH_SHORT).show()
            }
        }

        // Forecast Button
        binding.btnForecast.setOnClickListener {
            Toast.makeText(this, "Opening 10-Day Forecast...", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(this, ForecastActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Forecast screen coming soon", Toast.LENGTH_SHORT).show()
            }
        }

        // Air Quality Button
        binding.btnAirQuality.setOnClickListener {
            Toast.makeText(this, "Opening Air Quality...", Toast.LENGTH_SHORT).show()
            try {
                val intent = Intent(this, AirQualityActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Air Quality screen coming soon", Toast.LENGTH_SHORT).show()
            }
        }

        // Refresh Button
        binding.btnRefresh.setOnClickListener {
            Toast.makeText(this, "Refreshing weather data...", Toast.LENGTH_SHORT).show()
            // Simulate refresh
            binding.tvTemperature.text = "22°C"
            binding.tvCondition.text = "Sunny"
        }

        // Logout Button - UPDATED WITH PROPER FIREBASE LOGOUT
        binding.btnLogout.setOnClickListener {
            logoutUser()
        }
    }

    private fun logoutUser() {
        Log.d(TAG, "Attempting to logout user")

        try {
            // Get current user info before logout for the message
            val currentUser = auth.currentUser
            val userEmail = currentUser?.email ?: "User"

            // Sign out from Firebase
            auth.signOut()

            Log.d(TAG, "Firebase signOut completed")

            // Verify user is actually logged out
            val userAfterLogout = auth.currentUser
            if (userAfterLogout == null) {
                Log.d(TAG, "✅ User successfully logged out from Firebase")

                // Navigate back to LoginActivity with logout flag
                val intent = Intent(this, LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra("FROM_LOGOUT", true)
                }

                startActivity(intent)
                finish()

                Toast.makeText(this, "Goodbye, $userEmail! 👋", Toast.LENGTH_LONG).show()
            } else {
                Log.e(TAG, "❌ User still logged in after signOut")
                Toast.makeText(this, "Logout failed. Please try again.", Toast.LENGTH_LONG).show()
            }

        } catch (e: Exception) {
            Log.e(TAG, "Logout failed: ${e.message}", e)
            Toast.makeText(this, "Logout error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun redirectToLogin() {
        Log.d(TAG, "Redirecting to login screen")
        val intent = Intent(this, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }

    private fun createFallbackLayout() {
        // Fallback if XML layout fails
        android.widget.TextView(this).apply {
            text = "Dashboard loaded but layout issue.\n\nButtons should be visible now!\n\nIf you still don't see buttons, there might be an issue with the XML layout file."
            textSize = 16f
            setPadding(50, 50, 50, 50)
            setContentView(this)
        }
    }

    override fun onBackPressed() {
        // Optional: Show confirmation dialog when back button is pressed
        // Or just let it behave normally
        super.onBackPressed()
    }
}