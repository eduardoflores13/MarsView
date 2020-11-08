package com.example.marsview.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RoverService {
    @GET("rovers?api_key=ECobQCnzj1PEvt7FM4JCGE0XjwLCJzUicyJVOdYc")

    fun listarRover(): Call<RoverResponse>

    companion object{
        val instance: RoverService by lazy{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<RoverService>(RoverService::class.java)
        }
    }


}