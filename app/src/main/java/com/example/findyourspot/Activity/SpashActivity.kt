package com.example.findyourspot.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.findyourspot.R

class SpashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,DetailActivity::class.java))
            finish()
        },3000)
    }
}