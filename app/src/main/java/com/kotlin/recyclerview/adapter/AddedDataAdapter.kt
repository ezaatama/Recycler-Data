package com.kotlin.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.recyclerview.databinding.PersonBinding
import com.kotlin.recyclerview.models.Person

class AddedDataAdapter(private val listData: ArrayList<Person>): RecyclerView.Adapter<AddedDataAdapter.DataViewHolder>() {
    private lateinit var OnClickCallback: onClickCallback

    class DataViewHolder(val binding: PersonBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(PersonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listData.count()
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val (name, email) = listData[position]
        holder.binding.txtName.text = name
        holder.binding.txtEmail.text = email

        holder.itemView.setOnClickListener {
            OnClickCallback.itemClicked(listData[holder.adapterPosition])
        }
    }

    //SET CLICKABLE AREA
    fun setOnClickCallback(data: onClickCallback) {
        this.OnClickCallback = data
    }

    interface onClickCallback {
        fun itemClicked(data: Person)
    }
}