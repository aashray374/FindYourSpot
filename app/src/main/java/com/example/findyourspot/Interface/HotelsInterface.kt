package com.example.findyourspot.Interface

import com.example.findyourspot.DataClass.HotelsList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL=""
const val API_KEY=""
interface HotelsInterface {
    @GET("")
    fun getHotels(
        @Query("City") city:String,
    ):Call<HotelsList>

}

object HotelService {
    val HotelInstance: HotelsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        HotelInstance = retrofit.create(HotelsInterface::class.java)
    }
}