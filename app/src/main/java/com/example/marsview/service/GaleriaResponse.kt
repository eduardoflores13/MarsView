package com.example.marsview.service

data class GaleriaResponse (val photos:List<GaleriaResponseItem> ){
    class GaleriaResponseItem(
        val id: Int,
        val earth_date: String,
        val img_src: String
    )
}

