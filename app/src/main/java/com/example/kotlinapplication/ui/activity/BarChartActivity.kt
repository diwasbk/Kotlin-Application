package com.example.kotlinapplication.ui.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapplication.R
import com.example.kotlinapplication.databinding.ActivityBarChartBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class BarChartActivity : AppCompatActivity() {

    lateinit var binding: ActivityBarChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize binding to connect UI elements
        binding = ActivityBarChartBinding.inflate(layoutInflater)
        setContentView(binding.root) // Use the root view from binding

        // Find the BarChart view from the layout
        val barChart: BarChart = binding.barChart

        // Define labels for the X-axis
        val labels = listOf("Physics", "Chemistry", "Maths", "Computer")

        // Prepare the data for the chart
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(0f, 80f)) // Physics
        entries.add(BarEntry(1f, 60f)) // Chemistry
        entries.add(BarEntry(2f, 70f)) // Maths
        entries.add(BarEntry(3f, 90f)) // Computer

        // Create a dataset for the chart (with no label here)
        val dataSet = BarDataSet(entries, "")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList() // Set colors for the bars
        dataSet.valueTextSize = 14f // Set text size for the bar values
        dataSet.valueTextColor = Color.WHITE // Set text color for the values
        dataSet.valueTypeface = Typeface.DEFAULT_BOLD // Set text style for values

        // Create the BarData using the dataset
        val barData = BarData(dataSet)

        // Set up the BarChart
        barChart.description.isEnabled = false // Disable chart description text
        barChart.animateY(1000) // Animate the chart when it loads
        barChart.data = barData // Set the data for the chart
        barChart.setFitBars(true) // Make sure bars fit inside the chart
        barChart.invalidate() // Refresh the chart

        // **Set X-axis labels from the labels list**
        val xAxis = barChart.xAxis // Get the X-axis of the chart
        xAxis.valueFormatter = object : com.github.mikephil.charting.formatter.IndexAxisValueFormatter() {
            // This method uses the labels list to convert the numbers on the X-axis to text labels
            override fun getFormattedValue(value: Float): String {
                return labels.getOrNull(value.toInt()) ?: "" // Get the label or return an empty string if out of range
            }
        }

        // Set X-axis position and make sure labels align with bars
        xAxis.position = XAxis.XAxisPosition.BOTTOM // Put the labels at the bottom of the chart
        xAxis.granularity = 1f // Ensure the X-axis granularity is set to 1 (so it won't repeat labels)

        // This part handles the padding for the system bars (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
