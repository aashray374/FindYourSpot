package com.example.findyourspot.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.findyourspot.Adapter.FlightsAdapter
import com.example.findyourspot.Adapter.HotelAdapter
import com.example.findyourspot.DataClass.FlightDetails
import com.example.findyourspot.DataClass.HotelClass
import com.example.findyourspot.databinding.FragmentFlightsBinding
import com.example.findyourspot.other.DetailPass
import okhttp3.Request
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class FlightsFragment : Fragment(), DetailPass {

    private lateinit var binding: FragmentFlightsBinding
    private lateinit var adapter: FlightsAdapter
    private lateinit var flightlist: List<FlightDetails>
    private lateinit var YourDesti:String
    private lateinit var YourHome:String
    private lateinit var YourDate:AppCompatButton
    private lateinit var YourRating:String
    private lateinit var YourSeason:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentFlightsBinding.inflate(layoutInflater,container,false)
        Toast.makeText(requireContext(), "yoyoyoy", Toast.LENGTH_SHORT).show()

        binding.flightRv.layoutManager = LinearLayoutManager(requireContext())

        fetchDataFromAPI()
       return binding.root
    }

    private fun fetchDataFromAPI() {
        val url = "http://192.168.172.60:4000/flight?des=$YourDesti&src=$YourHome"
        val requestQueue = Volley.newRequestQueue(requireContext())

        val jsonObjectRequest = JsonObjectRequest(
            com.android.volley.Request.Method.GET,
            url,
            null,
            { response ->
                try {
                    val dataArray = response.getJSONArray("flight")
                    val tempList = mutableListOf<FlightDetails>()
                    for (i in 0 until dataArray.length()) {
                        val hotelObject = dataArray.getJSONObject(i)
                        val price = hotelObject.getString("price").toString()
                        val src = YourHome
                        val des = YourDesti
                        val time = hotelObject.getString("time").toString()
                        val date = YourDate.toString()
                        val hotel = FlightDetails(des,src,price,time,date)
                        tempList.add(hotel)
                    }
                    flightlist = tempList
                    adapter = FlightsAdapter(requireContext(),flightlist)
                    binding.flightRv.adapter = adapter
                } catch (e: JSONException) {
                    Toast.makeText(requireContext(), e.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.e("fetchMatches", "Error parsing JSON", e)
                }
            },
            { error ->
                // Handle error
                Toast.makeText(requireContext(), "Error fetching data: ${error.message}", Toast.LENGTH_SHORT).show()
                Log.e("fetchMatches", "Volley Error: ${error.message}", error)
            }
        )

        requestQueue.add(jsonObjectRequest)
    }

    override fun onDataPassed(
        city: String,
        season: String,
        Date: AppCompatButton,
        rating: String,
        scrCity: String
    ) {
        YourDesti = city
        YourHome = scrCity
        YourDate = Date
        YourRating = rating
        YourSeason = season
    }


}