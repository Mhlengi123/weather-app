package com.yourteam.saweather

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        val title = TextView(this).apply {
            text = "📅 10-Day Forecast - Durban"
            textSize = 24f
        }

        val days = listOf("Today", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Mon", "Tue")
        val temps = listOf("21°", "22°", "23°", "24°", "25°", "24°", "23°", "22°", "21°", "20°")

        days.forEachIndexed { index, day ->
            val dayLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(16, 8, 16, 8)
            }

            val tvDay = TextView(this).apply {
                text = day
                textSize = 16f
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val tvTemp = TextView(this).apply {
                text = temps[index]
                textSize = 16f
            }

            dayLayout.addView(tvDay)
            dayLayout.addView(tvTemp)
            layout.addView(dayLayout)
        }

        layout.addView(title)
        setContentView(layout)
    }
}