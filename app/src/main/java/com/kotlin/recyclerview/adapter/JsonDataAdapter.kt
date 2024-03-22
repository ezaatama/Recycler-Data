package com.kotlin.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.recyclerview.databinding.ItemJsonBinding
import com.kotlin.recyclerview.models.Pahlawan

class JsonDataAdapter(private val listJson: MutableList<Pahlawan>): RecyclerView.Adapter<JsonDataAdapter.DataViewHolder>() {
    class DataViewHolder(val binding: ItemJsonBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(ItemJsonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listJson.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.apply {
            tvNamaPahlawan.text = listJson[position].nama
            tvNamaLengkap.text = listJson[position].namaLengkap
            Glide.with(holder.itemView.context)
                .load(listJson[position].image)
                .override(1000, 1000)
                .into(imgPahlawan)
        }
    }

}