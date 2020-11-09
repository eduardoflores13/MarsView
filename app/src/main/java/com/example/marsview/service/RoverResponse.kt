package com.example.marsview.service

import android.os.Parcel
import android.os.Parcelable

data class RoverResponse(
    val rovers: List<RoverItem>
) {
    class RoverItem(
        val name: String,
        val landing_date: String,
        val launch_date: String,
        val status: String,
        val max_date: String,
        val total_photos: Int
    ){

    }
}