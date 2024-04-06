package com.example.findyourspot.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.findyourspot.DataClass.FlightList
import com.example.findyourspot.Interface.FlightService
import com.example.findyourspot.R
import com.example.findyourspot.other.DetailPass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightsFragment : Fragment(), DetailPass {
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getFlights()
        return inflater.inflate(R.layout.fragment_flights, container, false)
    }

    private fun getFlights(){
        val flight=FlightService.FlightInstance.getTransport("","","")
        flight.enqueue(object : Callback<FlightList> {
            override fun onResponse(call: Call<FlightList>, response: Response<FlightList>) {
                val news=response.body()
                if (news!=null){
//                    adapter= NewsAdapter(this@MainActivity,news.articles)
//                    rv.adapter=adapter
//                    rv.layoutManager= LinearLayoutManager(this@MainActivity)

                }
            }
            override fun onFailure(call: Call<FlightList>, t: Throwable) {
                Log.d("Thodi BT ho gyi hai","Error")
            }

        })
    }
    override fun onDataPassed(city: String, season: String, Date: AppCompatButton, rating: String) {

    }

}