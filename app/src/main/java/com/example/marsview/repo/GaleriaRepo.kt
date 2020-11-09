package com.example.marsview.repo

import com.example.marsview.service.GaleriaResponse
import com.example.marsview.service.RoverService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GaleriaRepo(private val roverServicio: RoverService, private val nombreRover: String) {
    fun listarfotos(callBack: (List<GaleriaResponse.GaleriaResponseItem>?)->Unit){
        val galeriaCall= roverServicio.listarfotos(nombreRover)
        galeriaCall.enqueue(object: Callback<GaleriaResponse> {
            override fun onFailure(call: Call<GaleriaResponse>, t: Throwable) {
                callBack(null)
            }

            override fun onResponse(
                call: Call<GaleriaResponse>,
                response: Response<GaleriaResponse>
            ) {
                val body= response?.body()
                callBack(body?.photos)
            }

        })
    }
}