package com.example.findyourspot.Interface

import com.example.findyourspot.DataClass.HotelClass
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//      https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?cityCode=JBP&radius=5&radiusUnit=KM&hotelSource=ALL

const val BASE_URL="test.api.amadeus.com"
const val API_KEY="GOqJZc7HbKcfzhnWGavbpOSc92INpRz7"
interface HotelsInterface {
    @GET(" https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?")
    fun getHotels(
        @Query("City") city:String,
    ):Call<List<HotelClass>>

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