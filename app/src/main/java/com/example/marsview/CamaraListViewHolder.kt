package com.example.marsview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CamaraListViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    val nombreCamara = itemView.findViewById<TextView>(R.id.txvcamara)

}
