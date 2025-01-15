package com.example.kotlinapplication.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.kotlinapplication.R
import com.example.kotlinapplication.adapter.TabAdapter
import com.example.kotlinapplication.databinding.ActivityOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {
    override fun onPause() {
        Log.d("lifecycle","Onpause -> I am called")
        super.onPause()
    }
    override fun onResume() {
        Log.d("lifecycle","Onresume -> I am called")
        super.onResume()
    }
    override fun onStart() {
        Log.d("lifecycle","ONStart -> I am called")
        super.onStart()
    }
    override fun onDestroy() {
        Log.d("lifecycle","Ondestroy -> I am called")
        super.onDestroy()
    }
    lateinit var binding : ActivityOrderBinding
    lateinit var adapter: TabAdapter
    // if  we want to put icon in the tab layout header
    val icons = arrayOf(
        R.drawable.baseline_directions_run_24,
        R.drawable.baseline_cancel_24,
        R.drawable.baseline_delivery_dining_24,
    )
    // if  we want to put text in the tab layout header
    val data = arrayOf("Active Order","Cancelled Order", "Delivered Order")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentManager: FragmentManager = supportFragmentManager
        adapter = TabAdapter(fragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tabs, position ->
            // Set both text and icon for the tabs
            tabs.text = data[position]
            tabs.icon = resources.getDrawable(icons[position], null)
        }.attach()
        Log.d("lifecycle", "Oncreate -> I am called")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}