package com.example.findyourspot.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.findyourspot.R
import com.example.findyourspot.databinding.ActivitySpashBinding

class SpashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySpashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySpashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.go.setOnClickListener {
            startActivity(Intent(this,DetailActivity::class.java))
        }
    }
}