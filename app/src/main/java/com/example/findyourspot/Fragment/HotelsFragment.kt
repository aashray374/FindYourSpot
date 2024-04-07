package com.example.findyourspot.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.findyourspot.Adapter.HotelAdapter
import com.example.findyourspot.DataClass.HotelsList
import com.example.findyourspot.Interface.HotelService
import com.example.findyourspot.databinding.FragmentHotelsBinding
import com.example.findyourspot.other.DetailPass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HotelsFragment : Fragment(), DetailPass {

    private lateinit var adapter:HotelAdapter
    private lateinit var binding: FragmentHotelsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHotelsBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getHotels()
    }

    private fun getHotels() {
        val hotelService = HotelService.HotelInstance.getHotels("")
        hotelService.enqueue(object : Callback<HotelsList> {
            override fun onResponse(call: Call<HotelsList>, response: Response<HotelsList>) {
                val hotelsList = response.body()
                if (hotelsList != null) {
                    adapter = HotelAdapter(requireContext(), hotelsList)
                    binding.hotelrv.adapter = adapter
                    binding.hotelrv.layoutManager = LinearLayoutManager(requireContext())
                }
            }

            override fun onFailure(call: Call<HotelsList>, t: Throwable) {
                Log.d("Thodi BT ho gyi hai", "Error")
            }
        })
    }

    override fun onDataPassed(city: String, season: String, Date: AppCompatButton, rating: String) {

    }
}