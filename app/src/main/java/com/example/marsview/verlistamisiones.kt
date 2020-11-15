package com.example.marsview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marsview.repo.RoverRepo
import com.example.marsview.service.RoverService
import com.example.marsview.service.RoverResponse
import kotlinx.android.synthetic.main.activity_verlistamisiones.*

class verlistamisiones : AppCompatActivity(), RoverSeleccionRecyclerViewClickListener {
    lateinit var rcvMisionesLista : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verlistamisiones)

        val roverService = RoverService.instance
        val roverRepo = RoverRepo(roverService)
        val roverListAdapter = MisionesListaRecyclerViewAdapter(this)

        roverRepo.listarRover {
            if(it != null){
                roverListAdapter.listMisiones = it
                roverListAdapter.notifyDataSetChanged()
            }
        }

        rcvMisionesLista = rcvmisiones

        rcvMisionesLista.layoutManager = LinearLayoutManager(this)

        rcvMisionesLista.adapter = roverListAdapter

        //Establecer el onclick listener para ir atrás

        btnatras.setOnClickListener {
            onBackPressed()
        }

    }


    fun vermision(rover:RoverResponse.RoverItem){
        val vermision = Intent(this, informacionrover::class.java)
        vermision.putExtra("NOMBREROVER", rover.name)
        vermision.putExtra("LAUNCHDATE", rover.launch_date)
        vermision.putExtra("LANDINGDATE", rover.landing_date)
        vermision.putExtra("STATUS", rover.status)
        vermision.putExtra("MAXDATE", rover.max_date)
        vermision.putExtra("TOTALFOTOS", rover.total_photos.toString())

        startActivity(vermision)
    }

    override fun listItemClicked(rover: RoverResponse.RoverItem) {
        vermision(rover)
    }
}


