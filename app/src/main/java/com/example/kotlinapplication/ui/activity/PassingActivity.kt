package com.example.kotlinapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapplication.R
import com.google.android.material.textfield.TextInputLayout

class PassingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing)
        enableEdgeToEdge()
        // Initialize all the views
        val fullNameInput = findViewById<TextInputLayout>(R.id.fullName).editText
        val emailInput = findViewById<TextInputLayout>(R.id.email).editText
        val passwordInput = findViewById<TextInputLayout>(R.id.password).editText
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val checkBoxTerms = findViewById<CheckBox>(R.id.checkBox)
        val signupButton = findViewById<Button>(R.id.buttonSignup)
        // Setup Spinner (dropdown) for selecting country
        val spinnerCountry = findViewById<Spinner>(R.id.spinnerCountry)
        val countriesAdapter = ArrayAdapter.createFromResource(
            this, R.array.countries_array, android.R.layout.simple_spinner_item
        )
        // Define the style for the dropdown list items
        countriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountry.adapter = countriesAdapter
        // Set the action for the signup button when clicked
        signupButton.setOnClickListener {
            // Get the input values from the form fields
            val fullname = fullNameInput?.text?.toString().orEmpty()
            val email = emailInput?.text?.toString().orEmpty()
            val password = passwordInput?.text?.toString().orEmpty()
            // Determine the selected gender from the radio buttons
            val gender = when (radioGroupGender.checkedRadioButtonId) {
                R.id.radioButtonMale -> "Male"
                R.id.radioButtonFemale -> "Female"
                else -> "Not Specified"
            }
            // Get the selected country from the spinner
            val country = spinnerCountry.selectedItem?.toString().orEmpty()
            // Check whether the terms and conditions checkbox is checked
            val termsAccepted = checkBoxTerms.isChecked
            // Create an Intent to navigate to PassedActivity and pass data
            val intent = Intent(this, PassedActivity::class.java)
            intent.putExtra("fullName", fullname)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("gender", gender)
            intent.putExtra("country", country)
            intent.putExtra("termsAccepted", termsAccepted)  // Pass boolean value for terms acceptance
            // Start the PassedActivity and finish the current activity
            startActivity(intent)
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}