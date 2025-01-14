package com.example.kotlinapplication.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.kotlinapplication.R
import com.example.kotlinapplication.databinding.ActivityHomeBinding
import com.example.kotlinapplication.ui.fragment.FirstFragment
import com.example.kotlinapplication.ui.fragment.SecondFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // to show the first fragment screen by default
        replaceFragment(FirstFragment())
        binding.firstBtn.setOnClickListener {
            replaceFragment(FirstFragment())
        }
        binding.secondBtn.setOnClickListener {
            replaceFragment(SecondFragment())
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    // function to implement fragments
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.frameLayout.id, fragment)
        fragmentTransaction.commitNow()
    }
}