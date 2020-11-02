package com.example.marsview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GaleriaListRecyclerViewAdapter : RecyclerView.Adapter<GaleriaListViewHolder>() {
    val listaGaleria : List<String> = listOf<String>("Imagen 1", "Imagen 2", "Imagen 3")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriaListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.galeria_data_view_holder,parent, false)
        return GaleriaListViewHolder(view)
    }

    override fun onBindViewHolder(holder: GaleriaListViewHolder, position: Int) {
        holder.imagenRover.text = listaGaleria[position]
    }

    override fun getItemCount(): Int {
        return listaGaleria.size
    }

}
