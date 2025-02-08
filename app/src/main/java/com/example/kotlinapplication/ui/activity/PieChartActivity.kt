package com.example.kotlinapplication.ui.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapplication.R
import com.example.kotlinapplication.databinding.ActivityPieChartBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class PieChartActivity : AppCompatActivity() {

    lateinit var binding: ActivityPieChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize binding
        binding = ActivityPieChartBinding.inflate(layoutInflater)
        setContentView(binding.root) // Use the root view from binding

        // Find PieChart view by binding
        val pieChart: PieChart = binding.pieChart

        // Pie chart data
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(80f, "Physics"))
        entries.add(PieEntry(60f, "Chemistry"))
        entries.add(PieEntry(70f, "Maths"))
        entries.add(PieEntry(90f, "Computer"))

        // Create PieDataSet without a label
        val dataSet = PieDataSet(entries, "") // Removed the label
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS.toList())  // Color scheme
        dataSet.valueTextSize = 14f  // Text size for labels
        dataSet.valueTextColor = Color.WHITE // Text color for labels
        dataSet.setValueFormatter(PercentFormatter()) // Show percentages in labels
        dataSet.setValueTypeface(Typeface.DEFAULT_BOLD) // Make labels bold

        // Create PieData
        val pieData = PieData(dataSet)

        // Configure PieChart settings
        pieChart.description.isEnabled = false
        pieChart.setUsePercentValues(true) // Show values in percentage
        pieChart.animateY(1000) // Smooth animation
        pieChart.data = pieData
        pieChart.setEntryLabelColor(Color.WHITE) // Set labels to white
        pieChart.setEntryLabelTypeface(Typeface.DEFAULT_BOLD) // Make labels bold
        pieChart.invalidate() // Refresh the chart

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
