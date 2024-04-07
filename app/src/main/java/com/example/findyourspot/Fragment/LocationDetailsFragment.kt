package com.example.findyourspot.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.findyourspot.R
import com.example.findyourspot.other.DetailPass

class LocationDetailsFragment : Fragment() , DetailPass {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_details, container, false)

    }

    override fun onDataPassed(
        city: String,
        season: String,
        Date: AppCompatButton,
        rating: String,
        toString: String
    ) {

    }
}