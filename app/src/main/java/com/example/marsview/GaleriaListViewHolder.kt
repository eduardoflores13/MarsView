package com.example.marsview

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class GaleriaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imagenRover = itemView.findViewById<ImageView>(R.id.imagen)
    val idfoto = itemView.findViewById<TextView>(R.id.txtid)
    val fechafoto = itemView.findViewById<TextView>(R.id.txtfechafoto)
    val botonfoto = itemView.findViewById<Button>(R.id.btngaleria)

}
