package com.example.marsview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_imagen.*

class Imagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen)
        val path = intent.getStringExtra("urlimagen")?.replace("http://","https://")
        val imagenvista = findViewById<ImageView>(R.id.imvfoto)


        btnatras.setOnClickListener {
            onBackPressed()
        }

        Picasso.get().load("$path")
            .into(imagenvista)



    }
}