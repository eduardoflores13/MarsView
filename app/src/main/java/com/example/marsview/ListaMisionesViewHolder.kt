package com.example.marsview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaMisionesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nombreRover = itemView.findViewById<TextView>(R.id.txvnombremision)
}
