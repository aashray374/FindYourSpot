package com.example.findyourspot.other

import androidx.appcompat.widget.AppCompatButton

interface DetailPass {
    fun onDataPassed(
        city: String,
        season:String,
        Date: AppCompatButton,
        rating: String
    )
}