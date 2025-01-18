package com.example.kotlinapplication.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapplication.R
import com.example.kotlinapplication.adapter.ArticleAdapter
import com.example.kotlinapplication.databinding.ActivityArticleBinding
import com.example.kotlinapplication.model.ArticleModel

class ArticleActivity : AppCompatActivity() {
    lateinit var binding: ActivityArticleBinding
    lateinit var itemAdapter: ArticleAdapter
    lateinit var articleDataList: ArrayList<ArticleModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the data list
        articleDataList = ArrayList()
        articleDataList.add(ArticleModel(R.drawable.qr_code, "QR Code Generator"))
        articleDataList.add(ArticleModel(R.drawable.crud_operation, "CRUD Operation in MySQL"))
        articleDataList.add(ArticleModel(R.drawable.plagiarism_checker, "Plagiarism Checker"))
        articleDataList.add(ArticleModel(R.drawable.data_science, "Data Analysis Project"))
        articleDataList.add(ArticleModel(R.drawable.numpy_pandas_matplotlib, "NumPy, Pandas, and Matplotlib"))
        articleDataList.add(ArticleModel(R.drawable.backend_development, "Backend Development"))

        // Initialize the adapter
        itemAdapter = ArticleAdapter(articleDataList, this)

        // Set up RecyclerView
        binding.articleRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.articleRecyclerView.adapter = itemAdapter

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}