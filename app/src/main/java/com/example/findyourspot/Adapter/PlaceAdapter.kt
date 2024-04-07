package com.example.findyourspot.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.findyourspot.DataClass.HotelClass
import com.example.findyourspot.DataClass.PlacesClass
import com.example.findyourspot.R

class PlaceAdapter(
    val context: Context,
    val list: List<PlacesClass>
): RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val des: TextView = view.findViewById(R.id.des)
        val city: TextView = view.findViewById(R.id.city)
        val img: ImageView = view.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.place_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel = list[position]
        holder.des.text = hotel.des
        holder.city.text = hotel.place

        Glide
            .with(context)
            .load(hotel.img)
            .centerCrop()
            .into(holder.img);
    }
}