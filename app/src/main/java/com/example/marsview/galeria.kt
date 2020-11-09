package com.example.marsview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marsview.repo.GaleriaRepo
import com.example.marsview.service.GaleriaResponse
import com.example.marsview.service.RoverService
import kotlinx.android.synthetic.main.activity_galeria.*

class galeria : AppCompatActivity(), FotoSeleccionRecyclerViewClickListener {
    lateinit var rcvGalerialist : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)
        val nombrerover = intent.getStringExtra("NOMBREROVER")

        val roverservice = RoverService.instance
        val galeriarepo = GaleriaRepo(roverservice, nombrerover.toString())
        val galerialistadapter = GaleriaListRecyclerViewAdapter(this)

        galeriarepo.listarfotos {
            if(it != null){
                galerialistadapter.listaGaleria=it
                galerialistadapter.notifyDataSetChanged()
            }
        }

        rcvGalerialist = rcvGaleria
        rcvGalerialist.layoutManager = LinearLayoutManager(this)
        rcvGalerialist.adapter = galerialistadapter
    }

    fun irAtras(view: View) {
        onBackPressed()
    }

    fun verFoto(view: View){
        val foto = Intent(view.context, Imagen::class.java)
        startActivity(foto)
    }

    override fun fotoItemClicked(foto: GaleriaResponse.GaleriaResponseItem) {
        val fotointent = Intent(this, Imagen::class.java)
        fotointent.putExtra("urlimagen",foto.img_src)
        startActivity(fotointent)
    }
}