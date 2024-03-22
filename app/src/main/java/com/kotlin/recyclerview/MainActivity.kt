package com.kotlin.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.recyclerview.databinding.ActivityMainBinding
import com.kotlin.recyclerview.recycler.RecyclerAddedData
import com.kotlin.recyclerview.recycler.RecyclerJson
import com.kotlin.recyclerview.recycler.RecyclerObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTitle.text = "Latihan Recycler View"

        binding.btnRecyclerAdded.setOnClickListener {
            val intentDestination = Intent(this@MainActivity, RecyclerAddedData::class.java)
            startActivity(intentDestination)
        }

        binding.btnRecyclerJson.setOnClickListener {
            val intentDestination = Intent(this@MainActivity, RecyclerJson::class.java)
            startActivity(intentDestination)
        }

        binding.btnRecyclerObject.setOnClickListener {
            val intentDestination = Intent(this@MainActivity, RecyclerObject::class.java)
            startActivity(intentDestination)
        }
    }
}