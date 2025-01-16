package com.example.kotlinapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapplication.R
import com.example.kotlinapplication.model.ModelClass

class ItemAdapter(
    private val dataList: ArrayList<ModelClass>,
    private val context: Context
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Bind your views here
        val image: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_file, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]
        // Bind data to your views here
        holder.image.setImageResource(module.image)
        holder.name.text = module.name
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
}