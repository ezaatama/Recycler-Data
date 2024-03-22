package com.kotlin.recyclerview.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.recyclerview.R
import com.kotlin.recyclerview.adapter.JsonDataAdapter
import com.kotlin.recyclerview.databinding.ActivityRecyclerJsonBinding
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.StandardCharsets
import com.kotlin.recyclerview.models.Pahlawan

class RecyclerJson : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerJsonBinding
    private var listPahlawan = mutableListOf<Pahlawan>()
    private lateinit var mAdapter: JsonDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getListPahlawan()
        setUpRecycler()
    }

    private fun setUpRecycler() {
        binding.rvJsonData.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mAdapter
        }
    }

    private fun getListPahlawan() {
        try {
            val inputStream = assets.open("pahlawan.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)

            inputStream.close()
            val strContent = String(buffer, StandardCharsets.UTF_8)
            try {
                val jsonObject: JSONObject = JSONObject(strContent)
                val jsonArray = jsonObject.getJSONArray("daftar_pahlawan")
                for (i in 0 until jsonArray.length()) {
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataApi = Pahlawan()
                    dataApi.nama = jsonObjectData.getString("nama")
                    dataApi.namaLengkap = jsonObjectData.getString("nama2")
                    dataApi.image = jsonObjectData.getString("img")
                    listPahlawan.add(dataApi)
                }
                mAdapter = JsonDataAdapter(listPahlawan)
            } catch (e: JSONException) {
                Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_SHORT).show()            }
        } catch (e: JSONException) {
            Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}