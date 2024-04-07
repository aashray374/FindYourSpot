package com.example.findyourspot.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.privacysandbox.tools.core.model.Method
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.findyourspot.Adapter.HotelAdapter
import com.example.findyourspot.DataClass.HotelClass
import com.example.findyourspot.R
import com.example.findyourspot.databinding.FragmentHotelsBinding
import com.example.findyourspot.other.DetailPass
import okhttp3.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class HotelsFragment : Fragment(),DetailPass {

    private lateinit var binding: FragmentHotelsBinding
    private lateinit var hotelAdapter: HotelAdapter
    private lateinit var hotelList: List<HotelClass>
    private lateinit var YourDesti:String
    private lateinit var YourHome:String
    private lateinit var YourDate:AppCompatButton
    private lateinit var YourRating:String
    private lateinit var YourSeason:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelsBinding.inflate(inflater, container, false)
        val view = binding.root

        Toast.makeText(requireContext(), "yoyoyoy", Toast.LENGTH_SHORT).show()

        // Initialize the RecyclerView
        binding.hotelrv.layoutManager = LinearLayoutManager(requireContext())

        // Fetch data from the API
        fetchDataFromAPI()

        return view
    }

    private fun fetchDataFromAPI() {
        val url = "http://192.168.172.60:4000/hotel?city=Santorini"
        val requestQueue = Volley.newRequestQueue(requireContext())

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                try {
                    val dataArray = response.getJSONArray("hotel")
                    val tempList = mutableListOf<HotelClass>()
                    for (i in 0 until dataArray.length()) {
                        val hotelObject = dataArray.getJSONObject(i)
                        val name = hotelObject.getString("name")
                        val city = hotelObject.getString("city")
                        val rating = hotelObject.getInt("rating").toString()
                        val pricePerNight = hotelObject.getString("price_per_night")
                        val hotel = HotelClass(name, city, rating, pricePerNight)
                        tempList.add(hotel)
                    }
                    hotelList = tempList
                    hotelAdapter = HotelAdapter(requireContext(), hotelList)
                    binding.hotelrv.adapter = hotelAdapter
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
