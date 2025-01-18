package com.example.kotlinapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapplication.R
import com.example.kotlinapplication.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {

    lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize View Binding
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the data passed from the previous activity
        val image = intent.getIntExtra("Image", -1)
        val name = intent.getStringExtra("Name")
        val description = intent.getStringExtra("Description")

        // Set the data to the views using binding
        binding.showName.text = name
        binding.showImage.setImageResource(image)
        binding.showDescription.text = description

        // Handle back arrow click
        binding.backArrow.setOnClickListener {
            val intent = Intent(this, ArticleActivity::class.java)
            startActivity(intent)
            finish()
        }
        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}