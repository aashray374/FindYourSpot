package com.example.findyourspot.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.findyourspot.DataClass.FlightDetails
import com.example.findyourspot.Interface.FlightService
import com.example.findyourspot.databinding.FragmentFlightsBinding
import com.example.findyourspot.other.DetailPass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlightsFragment : Fragment(), DetailPass {

    private lateinit var binding: FragmentFlightsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=FragmentFlightsBinding.inflate(layoutInflater,container,false)

    getFlights()

    return binding.root
    }

    private fun getFlights(){
        val flight=FlightService.FlightInstance.getTransport("","","")
        flight.enqueue(object : Callback<FlightDetails> {
            override fun onResponse(call: Call<FlightDetails>, response: Response<FlightDetails>) {
                val news=response.body()
                if (news!=null){


                }
            }
            override fun onFailure(call: Call<FlightDetails>, t: Throwable) {
                Log.d("Thodi BT ho gyi hai","Error")
            }

        })
    }
    override fun onDataPassed(city: String, season: String, Date: AppCompatButton, rating: String) {

    }

}