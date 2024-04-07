package com.example.findyourspot.Interface

import com.example.findyourspot.DataClass.FlightDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = ""
const val API_KEY = ""

interface FlightInterface {
    @GET("")
    fun getTransport(
        @Query("destination") destination: String,
        @Query("StartCity") startCity:String,
        @Query("Date") date:String
    ):Call<List<FlightDetails>>
}

object FlightService{
    val FlightInstance:FlightInterface
    init {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        FlightInstance=retrofit.create(FlightInterface::class.java)
    }

}