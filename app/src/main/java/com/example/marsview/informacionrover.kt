package com.example.marsview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_informacionrover.*

class informacionrover : AppCompatActivity() {
    lateinit var rcvCamaralist : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacionrover)

        rcvCamaralist = rcvcamaras
        rcvCamaralist.layoutManager = LinearLayoutManager(this)
        rcvCamaralist.adapter = CamaraListRecyclerViewAdapter()
    }

    fun irAtras(view: View) {
        onBackPressed()
    }

    fun verGaleria(view: View) {
        val galeria = Intent(this, galeria::class.java)
        startActivity(galeria)
    }
}