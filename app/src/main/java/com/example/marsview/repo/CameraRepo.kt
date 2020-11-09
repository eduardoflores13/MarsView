package com.example.marsview.repo

import com.example.marsview.service.CameraResponse
import com.example.marsview.service.RoverService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CameraRepo(private val cameraService : RoverService, private val roverRecibido : String) {
    fun listarCamaras(callBack:(List<CameraResponse.RoverRespuesta.CameraItem>?)->Unit){
        val cameracall = cameraService.listarcamaras(roverRecibido)
        cameracall.enqueue(object: Callback<CameraResponse>{
            override fun onResponse(
                call: Call<CameraResponse>,
                response: Response<CameraResponse>
            ) {
                val body = response?.body()
                callBack(body?.rover?.cameras)
            }

            override fun onFailure(call: Call<CameraResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }
}