package com.example.findyourspot.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.findyourspot.DataClass.HotelClass
import com.example.findyourspot.R

class HotelAdapter(
    val context: Context,
    val list: List<HotelClass>
): RecyclerView.Adapter<HotelAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val des: TextView = view.findViewById(R.id.des)
        val src: TextView = view.findViewById(R.id.rating)
        val price: TextView = view.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.hotel_des_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel = list[position]
            holder.des.text = hotel.name
            holder.src.text = hotel.rating
            holder.price.text = hotel.price_per_night

    }
}
