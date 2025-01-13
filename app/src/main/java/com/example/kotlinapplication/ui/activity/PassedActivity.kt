package com.example.kotlinapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapplication.R

class PassedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_passed)
        // Find all views
        val displayName = findViewById<TextView>(R.id.displayName)
        val displayEmail = findViewById<TextView>(R.id.displayEmail)
        val displayPassword = findViewById<TextView>(R.id.displayPassword)
        val displayGender = findViewById<TextView>(R.id.displayGender)
        val displayCountry = findViewById<TextView>(R.id.displayCountry)
        val displayCheckBox = findViewById<TextView>(R.id.displayCheckBox)
        val backButton = findViewById<Button>(R.id.backButton)
        // Get the data passed from the previous activity
        val intentObj = intent // getIntent
        val getFullName = intentObj.getStringExtra("fullName")
        val getEmail = intentObj.getStringExtra("email")
        val getPassword = intentObj.getStringExtra("password")
        val getGender = intentObj.getStringExtra("gender")
        val getCountry = intentObj.getStringExtra("country")
        val getCheckBox = intentObj.getBooleanExtra("termsAccepted", false)  // Retrieve checkbox state as boolean
        // Set the text for the TextViews with labels and values
        displayName.text = getFullName
        displayEmail.text = "Email: $getEmail"
        displayPassword.text = "Password: $getPassword"
        displayGender.text = "Gender: ${getGender?.toUpperCase()}"
        displayCountry.text = "Country: $getCountry"
        displayCheckBox.text = "Terms Accepted: ${if (getCheckBox) "Yes" else "No"}"
        // Set the click listener for the back button
        backButton.setOnClickListener {
            val previousIntent = Intent(this, PassingActivity::class.java)
            startActivity(previousIntent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}