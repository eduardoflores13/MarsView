package com.example.marsview.repo

import com.example.marsview.service.RoverResponse
import com.example.marsview.service.RoverService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoverRepo (private val roverService: RoverService) {

    fun listarRover(callBack: (List<RoverResponse.RoverItem>?)-> Unit){
        val roverCall = roverService.listarRover()
        roverCall.enqueue(object: Callback<RoverResponse> {
            override fun onResponse(call: Call<RoverResponse>, response: Response<RoverResponse>) {
                val body = response?.body()
                callBack(body?.rovers)
            }

            override fun onFailure(call: Call<RoverResponse>, t: Throwable) {
                callBack(null)
            }

        })
    }


}