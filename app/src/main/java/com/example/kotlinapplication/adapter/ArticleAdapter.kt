package com.example.kotlinapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapplication.R
import com.example.kotlinapplication.model.ArticleModel
import com.example.kotlinapplication.ui.activity.DescriptionActivity

class ArticleAdapter(
    private val articleDataList: ArrayList<ArticleModel>,
    private val articleContext: Context
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val articleImage: ImageView = view.findViewById(R.id.articleImage)
        val articleName: TextView = view.findViewById(R.id.articleName)
        val articleCardView = view.findViewById<CardView>(R.id.articleCardLayout)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(articleContext).inflate(R.layout.article_file, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = articleDataList[position]
        holder.articleImage.setImageResource(module.articleImage)
        holder.articleName.text = module.articleName
        holder.articleCardView.setOnClickListener{
            val intent = Intent(articleContext, DescriptionActivity::class.java)
            intent.putExtra("Name", module.articleName)
            intent.putExtra("Image", module.articleImage)
            intent.putExtra("Description", module.articleDescription)
            articleContext.startActivity(intent)
            Toast.makeText(articleContext, module.articleName, Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount(): Int {
        return articleDataList.size
    }
}