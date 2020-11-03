package com.example.marsview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun verMisiones(view: View) {
        val misiones = Intent(this, verlistamisiones::class.java)
        startActivity(misiones)
    }
}