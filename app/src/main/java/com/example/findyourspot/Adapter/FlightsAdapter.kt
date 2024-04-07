package com.example.findyourspot.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.findyourspot.DataClass.FlightDetails
import com.example.findyourspot.R

class FlightsAdapter(
    val context:Context,
    val list:List<FlightDetails>
): RecyclerView.Adapter<FlightsAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val des: TextView = view.findViewById(R.id.des)
        val src: TextView = view.findViewById(R.id.src)
        val price: TextView = view.findViewById(R.id.price)
        val time: TextView = view.findViewById(R.id.time)
        val date: TextView = view.findViewById(R.id.date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.flight_img_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.des.text = list[position].des
        holder.src.text = list[position].src
        holder.price.text = list[position].price
        holder.time.text = list[position].time


    }

}

