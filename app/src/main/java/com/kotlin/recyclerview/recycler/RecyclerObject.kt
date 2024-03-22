package com.kotlin.recyclerview.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.recyclerview.R
import com.kotlin.recyclerview.adapter.ObjectDataAdapter
import com.kotlin.recyclerview.databinding.ActivityRecyclerObjectBinding

class RecyclerObject : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerObjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecycler()
    }

    private fun setUpRecycler() {
        binding.rvAnimal.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = ObjectDataAdapter()
        }
    }
}