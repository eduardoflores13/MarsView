package com.example.marsview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_galeria.*

class galeria : AppCompatActivity() {
    lateinit var rcvGalerialist : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)

        rcvGalerialist = rcvGaleria
        rcvGalerialist.layoutManager = LinearLayoutManager(this)
        rcvGalerialist.adapter = GaleriaListRecyclerViewAdapter()
    }
}