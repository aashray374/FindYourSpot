package com.example.findyourspot.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.findyourspot.DataClass.HotelClass
import com.example.findyourspot.R

class HotelAdapter(
    val context: Context,
    val list: MutableList<HotelClass>
): RecyclerView.Adapter<HotelAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        val image: ImageView = itemView.findViewById(R.id.statusProfile)
//        val name: TextView = itemView.findViewById(R.id.statusName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.hotel_des_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Glide.with(context)
//            .load(list[position].image)
//            .thumbnail(0.1f)
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .into(holder.image)
//
//        holder.name.text = list[position].name
    }

}