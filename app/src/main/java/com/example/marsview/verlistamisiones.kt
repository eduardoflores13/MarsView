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

class verlistamisiones : AppCompatActivity() {
    lateinit var rcvMisionesLista : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verlistamisiones)

        val roverService = RoverService.instance
        val roverRepo = RoverRepo(roverService)
        val roverListAdapter = MisionesListaRecyclerViewAdapter()

        roverRepo.listarRover {
            if(it != null){
                roverListAdapter.listMisiones = it
                roverListAdapter.notifyDataSetChanged()
            }
        }

        rcvMisionesLista = rcvmisiones

        rcvMisionesLista.layoutManager = LinearLayoutManager(this)

        rcvMisionesLista.adapter = roverListAdapter

    }

    fun irAtras(view: View) {
        onBackPressed()
    }

    fun vermision(view: View){
        val vermision = Intent(view.context, informacionrover::class.java)
        startActivity(vermision)
    }
}