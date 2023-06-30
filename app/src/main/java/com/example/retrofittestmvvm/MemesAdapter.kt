package com.example.retrofittestmvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofittestmvvm.model.Meme

class MemesAdapter(
    private val list: List<Meme>
) : RecyclerView.Adapter<MemesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var modelM: Meme
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        fun bind(model: Meme) {
            modelM = model
            Glide.with(itemView.context).load(model.url).into(imageView)
        }

    }



}
