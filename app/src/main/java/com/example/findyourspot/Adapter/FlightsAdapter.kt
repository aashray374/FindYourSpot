package com.example.findyourspot.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.findyourspot.DataClass.FlightList

class FlightsAdapter(
    val context:Context,
    val list:FlightList
): RecyclerView.Adapter<HotelAdapter.ViewHolder>() {
    class FlightViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list.Flights.size
    }

    override fun onBindViewHolder(holder: HotelAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

