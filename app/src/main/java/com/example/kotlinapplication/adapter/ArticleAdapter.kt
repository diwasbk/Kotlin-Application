package com.example.kotlinapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapplication.R
import com.example.kotlinapplication.model.ArticleModel

class ArticleAdapter(
    private val articleDataList: ArrayList<ArticleModel>,
    private val articleContext: Context
) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val articleImage: ImageView = view.findViewById(R.id.articleImage)
        val articleName: TextView = view.findViewById(R.id.articleName)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(articleContext).inflate(R.layout.article_file, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = articleDataList[position]
        holder.articleImage.setImageResource(module.articleImage)
        holder.articleName.text = module.articleName
    }
    override fun getItemCount(): Int {
        return articleDataList.size
    }
}