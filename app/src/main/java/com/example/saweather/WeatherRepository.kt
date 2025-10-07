package com.yourteam.saweather

import kotlinx.coroutines.delay

class WeatherRepository {
    private val apiKey = "YOUR_API_KEY"

    private val saCities = mapOf(
        "Durban" to Pair(-29.8579, 31.0292),
        "Johannesburg" to Pair(-26.2041, 28.0473),
        "Cape Town" to Pair(-33.9249, 18.4241),
        "Pretoria" to Pair(-25.7479, 28.2293)
    )

    suspend fun getWeather(city: String = "Durban"): WeatherResponse? {
        return try {
            if (apiKey == "YOUR_API_KEY") {
                delay(1000)
                return getSampleWeather()
            }

            val coordinates = saCities[city] ?: saCities["Durban"]!!
            WeatherApi.instance.getWeatherData(
                coordinates.first,
                coordinates.second,
                "metric",
                apiKey
            )
        } catch (e: Exception) {
            getSampleWeather()
        }
    }

    private fun getSampleWeather(): WeatherResponse {
        return WeatherResponse(
            current = CurrentWeather(
                temperature = 21.0,
                feelsLike = 21.0,
                humidity = 73,
                uvIndex = 2.0,
                windSpeed = 5.0,
                weather = listOf(WeatherDescription("Clouds", "partly cloudy"))
            ),
            daily = listOf(
                DailyWeather(
                    date = System.currentTimeMillis() / 1000,
                    temperature = Temperature(15.0, 29.0),
                    weather = listOf(WeatherDescription("Clouds", "partly cloudy"))
                )
            )
        )
    }

    fun getCities(): List<String> {
        return saCities.keys.toList()
    }
}