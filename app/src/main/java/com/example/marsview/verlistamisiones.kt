package com.example.marsview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_verlistamisiones.*

class verlistamisiones : AppCompatActivity() {
    lateinit var rcvMisionesLista : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verlistamisiones)

        rcvMisionesLista = rcvmisiones

        rcvMisionesLista.layoutManager = LinearLayoutManager(this)

        rcvMisionesLista.adapter = MisionesListaRecyclerViewAdapter()

    }

    fun irAtras(view: View) {
        onBackPressed()
    }

    fun vermision(view: View){
        val vermision = Intent(view.context, informacionrover::class.java)
        startActivity(vermision)
    }
}