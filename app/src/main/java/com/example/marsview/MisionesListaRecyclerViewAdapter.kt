package com.example.marsview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marsview.service.RoverResponse

class MisionesListaRecyclerViewAdapter : RecyclerView.Adapter<ListaMisionesViewHolder>() {
    var listMisiones = listOf<RoverResponse.RoverItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaMisionesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mision_data_view_holder, parent,false)
        return ListaMisionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaMisionesViewHolder, position: Int) {
        holder.nombreRover.text = listMisiones[position].toString()
        holder.fechaLanzamientoRover.text = listMisiones[position].toString()
        holder.fechaLlegadaRover.text = listMisiones[position].toString()

    }

    override fun getItemCount(): Int {
        return listMisiones.size
    }

}
