package com.example.marsview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CamaraListRecyclerViewAdapter : RecyclerView.Adapter<CamaraListViewHolder>() {
    val listacamaras : List<String> = listOf<String>("Camara 1", "Camara 2", "Camara 3")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamaraListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.camara_lista_view_holder,parent,false)
        return CamaraListViewHolder(view)

    }

    override fun onBindViewHolder(holder: CamaraListViewHolder, position: Int) {
       holder.nombreCamara.text = listacamaras[position]
    }

    override fun getItemCount(): Int {
        return listacamaras.size
    }

}
