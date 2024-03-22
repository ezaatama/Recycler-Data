package com.kotlin.recyclerview.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.recyclerview.R
import com.kotlin.recyclerview.adapter.AddedDataAdapter
import com.kotlin.recyclerview.databinding.ActivityRecyclerAddedDataBinding
import com.kotlin.recyclerview.models.Person

class RecyclerAddedData : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerAddedDataBinding
    private val listPerson= ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerAddedDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvAddedData.setHasFixedSize(true)
        binding.rvAddedData.layoutManager = LinearLayoutManager(this)

        listPerson.add(Person("Reza", "ezatama33@gmail.com"))
        listPerson.add(Person("Putra", "putra@gmail.com"))
        listPerson.add(Person("Pratama", "pratama@gmail.com"))
        listPerson.add(Person("Arlot", "arlot@gmail.com"))
        listPerson.add(Person("Paquito", "paquito@gmail.com"))
        listPerson.add(Person("Yin", "yin@gmail.com"))

        val personAdapter = AddedDataAdapter(listPerson)
        //KONFIGURASI CLICKABLE
        personAdapter.setOnClickCallback(object: AddedDataAdapter.onClickCallback{
            override fun itemClicked(data: Person) {
                showAlert(data)
            }
        })
        binding.rvAddedData.adapter = personAdapter
    }

    private fun showAlert(data: Person) {
        Toast.makeText(this, "you clicked " + data.name, Toast.LENGTH_SHORT).show()
    }
}