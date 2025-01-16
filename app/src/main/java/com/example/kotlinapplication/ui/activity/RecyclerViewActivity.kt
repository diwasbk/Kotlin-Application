package com.example.kotlinapplication.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapplication.R
import com.example.kotlinapplication.adapter.ItemAdapter
import com.example.kotlinapplication.databinding.ActivityRecyclerViewBinding
import com.example.kotlinapplication.model.ModelClass

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var dataList: ArrayList<ModelClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Initialize the data list
        dataList = ArrayList()
        dataList.add(ModelClass(R.drawable.image_third, "Bouddhanath"))
        dataList.add(ModelClass(R.drawable.image_second,"Sunset"))
        dataList.add(ModelClass(R.drawable.image_first, "Mountain"))
        dataList.add(ModelClass(R.drawable.image_fourth, "Birds"))
        dataList.add(ModelClass(R.drawable.image_fifth, "Village"))
        // Initialize the adapter
        itemAdapter = ItemAdapter(dataList, this)
        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = itemAdapter
        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}