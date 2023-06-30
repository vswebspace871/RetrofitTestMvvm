package com.example.retrofittestmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittestmvvm.repository.MemesRepository
import com.example.retrofittestmvvm.viewmodel.MemesViewModel
import com.example.retrofittestmvvm.viewmodel.MemesViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var memesViewModel: MemesViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adaper: MemesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        adaper = MemesAdapter(ArrayList())
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = RetrofitClient.getService()

        val memesRepository = MemesRepository(apiInterface)

        memesViewModel = ViewModelProvider(this, MemesViewModelFactory(memesRepository))
            .get(MemesViewModel::class.java)

        memesViewModel.memes.observe(this) {
            if (it != null) {
                adaper = MemesAdapter(it.data.memes)
                recyclerView.adapter = adaper
            }
        }
    }
}