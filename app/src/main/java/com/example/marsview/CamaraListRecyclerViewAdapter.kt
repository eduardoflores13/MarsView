package com.example.marsview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marsview.service.CameraResponse

class CamaraListRecyclerViewAdapter : RecyclerView.Adapter<CamaraListViewHolder>() {
    var listacamaras = listOf<CameraResponse.RoverRespuesta.CameraItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamaraListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.camara_lista_view_holder,parent,false)
        return CamaraListViewHolder(view)

    }

    override fun onBindViewHolder(holder: CamaraListViewHolder, position: Int) {
       holder.nombreCamara.text = listacamaras[position].full_name
    }

    override fun getItemCount(): Int {
        return listacamaras.size
    }

}
