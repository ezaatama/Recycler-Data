package com.kotlin.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.recyclerview.databinding.ItemObjectBinding
import com.kotlin.recyclerview.models.ObjectData

class ObjectDataAdapter: RecyclerView.Adapter<ObjectDataAdapter.DataViewHolder>() {
    private val listObjectAnimal = ObjectData.listObjectAnimal
    class DataViewHolder(val binding: ItemObjectBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(ItemObjectBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listObjectAnimal.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.apply {
            tvAnimal.text = listObjectAnimal[position].title
            Glide.with(holder.itemView.context)
                .load(listObjectAnimal[position].image)
                .override(1000, 1000)
                .into(tvImage)
        }
    }
}