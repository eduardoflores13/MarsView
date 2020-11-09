package com.example.marsview.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface RoverService {
    //LLamado para obtener los rovers
    @GET("rovers?api_key=ECobQCnzj1PEvt7FM4JCGE0XjwLCJzUicyJVOdYc")
    fun listarRover(): Call<RoverResponse>


    //LLamada para obtener las cámaras del rover

    @GET("rovers/{rover}?api_key=ECobQCnzj1PEvt7FM4JCGE0XjwLCJzUicyJVOdYc")
    fun listarcamaras(@Path("rover") rover:String):Call<CameraResponse>

    @GET("rovers/{rover}/photos?sol=1000&api_key=ECobQCnzj1PEvt7FM4JCGE0XjwLCJzUicyJVOdYc")
    fun listarfotos(@Path("rover")rover:String):Call<GaleriaResponse>

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