package com.example.marsview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GaleriaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imagenRover = itemView.findViewById<TextView>(R.id.textgnombre)
}
