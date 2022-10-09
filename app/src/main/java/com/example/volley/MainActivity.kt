package com.example.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request.Method
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.volley.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchJson()
    }

    private fun fetchJson() {
        var url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"
        var mq = Volley.newRequestQueue(this)
        var jsonObjectR: JsonObjectRequest = JsonObjectRequest(Method.GET, url, null,
            { response ->
                binding.txtView.text = response?.toString()
            }
        ) { error ->
            println(error.message)
        }

        mq.add(jsonObjectR)
    }
}