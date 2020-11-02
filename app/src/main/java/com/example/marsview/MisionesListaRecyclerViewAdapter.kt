package com.example.marsview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MisionesListaRecyclerViewAdapter : RecyclerView.Adapter<ListaMisionesViewHolder>() {
    val listMisiones = listOf<String>("Rover 1", "Rover 2", "Rover 3", "Rover 4", "Rover 5")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaMisionesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mision_data_view_holder, parent,false)
        return ListaMisionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaMisionesViewHolder, position: Int) {
        holder.nombreRover.text = listMisiones[position]
    }

    override fun getItemCount(): Int {
        return listMisiones.size
    }

}
