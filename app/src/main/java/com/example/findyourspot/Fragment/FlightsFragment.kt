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
import com.example.findyourspot.Adapter.FlightsAdapter
import com.example.findyourspot.Adapter.HotelAdapter
import com.example.findyourspot.DataClass.FlightDetails
import com.example.findyourspot.DataClass.HotelClass
import com.example.findyourspot.databinding.FragmentFlightsBinding
import com.example.findyourspot.other.DetailPass
import okhttp3.OkHttpClient
import okhttp3.Request
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
    ): View? {
    binding=FragmentFlightsBinding.inflate(layoutInflater,container,false)


        Toast.makeText(requireContext(), "yoyoyoy", Toast.LENGTH_SHORT).show()

        // Initialize the RecyclerView
        binding.flightRv.layoutManager = LinearLayoutManager(requireContext())

        // Fetch data from the API
        fetchDataFromAPI()
       return binding.root
    }

    private fun fetchDataFromAPI() {
        val url = "http://192.168.172.60:4000/flight?des=Munnar&src=Chennai"

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                // Handle failure
                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val responseData = response.body()?.string()
                if (responseData != null){
                    try {
                        val jsonObject = JSONObject(responseData)
                        val jsonArray = jsonObject.getJSONArray("flight")
                        val tempList = mutableListOf<FlightDetails>()
                        Toast.makeText(requireContext(), "flight", Toast.LENGTH_SHORT).show()
                        Log.d("hihi", jsonArray.toString())

                        for (i in 0 until jsonArray.length()) {
                            val hotelObject = jsonArray.getJSONObject(i)
                            val price = hotelObject.getString("price").toString()
                            val src = hotelObject.getString("src").toString()
                            val des = hotelObject.getInt("des").toString()
                            val time = hotelObject.getString("time").toString()


                            val flight = FlightDetails(des, src, price, time)
                            tempList.add(flight)
                        }

                        activity?.runOnUiThread {
                            flightlist = tempList
                            adapter = FlightsAdapter(requireContext(), flightlist)
                            binding.flightRv.adapter = adapter
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        })
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