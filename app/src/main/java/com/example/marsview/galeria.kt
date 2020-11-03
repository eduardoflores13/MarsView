package com.example.marsview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    fun irAtras(view: View) {
        onBackPressed()
    }

    fun verFoto(view: View){
        val foto = Intent(view.context, Imagen::class.java)
        startActivity(foto)
    }
}