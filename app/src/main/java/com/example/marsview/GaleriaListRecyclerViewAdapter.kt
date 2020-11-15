package com.example.marsview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marsview.service.GaleriaResponse
import com.squareup.picasso.Picasso

interface FotoSeleccionRecyclerViewClickListener {
    fun fotoItemClicked(foto: GaleriaResponse.GaleriaResponseItem)
}



class GaleriaListRecyclerViewAdapter(
    val clickListener: FotoSeleccionRecyclerViewClickListener
) : RecyclerView.Adapter<GaleriaListViewHolder>() {
    var listaGaleria : List<GaleriaResponse.GaleriaResponseItem> = listOf<GaleriaResponse.GaleriaResponseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriaListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.galeria_data_view_holder,parent, false)
        return GaleriaListViewHolder(view)
    }

    override fun onBindViewHolder(holder: GaleriaListViewHolder, position: Int) {
        val ruta = listaGaleria[position].img_src?.replace("http://","https://")
        val fechaFoto = listaGaleria[position].earth_date
        Picasso.get().load("$ruta")
            .into(holder.imagenRover)
        holder.idfoto.text = listaGaleria[position].id.toString()
        holder.fechafoto.text = fechaEspaniol(fechaFoto)
        holder.botonfoto.setOnClickListener {
            clickListener.fotoItemClicked(listaGaleria[position])
        }
    }

    override fun getItemCount(): Int {
        return listaGaleria.size
    }

    fun fechaEspaniol(fechaingles : String?): String {
        val listaFecha = fechaingles?.split("-")
        var fechaEspaniol = listaFecha?.get(2) + "/" + listaFecha?.get(1) + "/" + listaFecha?.get(0)
        return fechaEspaniol
    }

}
