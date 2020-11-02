package com.example.marsview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_listamisiones.*

class Listamisiones : AppCompatActivity() {

    lateinit var rcvMisionesLista : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listamisiones)

        rcvMisionesLista = rcvmisiones

        rcvMisionesLista.layoutManager = LinearLayoutManager(this)

        rcvMisionesLista.adapter = MisionesListaRecyclerViewAdapter()

    }
}