package com.example.marsview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marsview.service.RoverResponse

interface RoverSeleccionRecyclerViewClickListener{
    fun listItemClicked(rover: RoverResponse.RoverItem)
}

class MisionesListaRecyclerViewAdapter(val clickListener: RoverSeleccionRecyclerViewClickListener) : RecyclerView.Adapter<ListaMisionesViewHolder>() {
    var listMisiones = listOf<RoverResponse.RoverItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaMisionesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mision_data_view_holder, parent,false)
        return ListaMisionesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaMisionesViewHolder, position: Int) {
        holder.nombreRover.text = listMisiones[position].name
        holder.fechaLanzamientoRover.text = fechaEspaniol(listMisiones[position].launch_date)
        holder.fechaLlegadaRover.text = fechaEspaniol(listMisiones[position].landing_date)
        holder.botonMision.setOnClickListener{
            clickListener.listItemClicked(listMisiones[position])
        }
    }

    override fun getItemCount(): Int {
        return listMisiones.size
    }

    fun fechaEspaniol(fechaingles : String): String {
        val listaFecha = fechaingles.split("-")
        var fechaEspaniol = listaFecha[2] + "/" + listaFecha[1] + "/" + listaFecha[0]
        return fechaEspaniol
    }



}
