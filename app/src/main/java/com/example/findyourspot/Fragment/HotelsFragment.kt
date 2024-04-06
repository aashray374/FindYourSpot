package com.example.findyourspot.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.findyourspot.DataClass.FlightList
import com.example.findyourspot.DataClass.HotelsList
import com.example.findyourspot.Interface.FlightService
import com.example.findyourspot.Interface.HotelService
import com.example.findyourspot.R
import com.example.findyourspot.other.DetailPass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HotelsFragment : Fragment(), DetailPass {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getHotels()
        return inflater.inflate(R.layout.fragment_hotels, container, false)

    }

    private fun getHotels(){
        val hotel= HotelService.HotelInstance.getHotels("")
        hotel.enqueue(object : Callback<HotelsList> {
            override fun onResponse(call: Call<HotelsList>, response: Response<HotelsList>) {
                val news=response.body()
                if (news!=null){
//                    adapter= NewsAdapter(this@MainActivity,news.articles)
//                    rv.adapter=adapter
//                    rv.layoutManager= LinearLayoutManager(this@MainActivity)

                }
            }
            override fun onFailure(call: Call<HotelsList>, t: Throwable) {
                Log.d("Thodi BT ho gyi hai","Error")
            }

        })
    }

    override fun onDataPassed(city: String, season: String, Date: AppCompatButton, rating: String) {
        TODO("Not yet implemented")
    }
}