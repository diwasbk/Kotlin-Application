package com.example.kotlinapplication.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinapplication.R

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.listView)
        val listItems = arrayOf("Programming & Algorithm",
            "Mathematics for Computer Science",
            "Software Design",
            "Computing ALL Project 1",
            "Object Oriented Programming",
            "Database Systems",
            "Creative Thinking for Business",
            "Computer Architecture and Networks",
            "Computing ALL Project 2",
            "Software Development",
            "Web Development",
            "Programming for Developers",
            "Android Application Development with Kotlin",
            "People and Computing",
            "Enterprise Project",
            "Data Science for Developers",
            "Be Your Own Boss",
            "Computing Project Preparation",
            "Web API Development",
            "Mobile Application Development",
            "Design Thinking and Innovation",
            "UX Design",
            "Security",
            "Individual Project")

        // data set in the listView
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = listAdapter

        // item click
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}