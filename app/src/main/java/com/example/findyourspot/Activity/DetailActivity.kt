package com.example.findyourspot.Activity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.findyourspot.databinding.ActivityDetailBinding
import com.example.findyourspot.other.DetailPass
import java.util.Calendar

class DetailActivity : AppCompatActivity(), DetailPass {

    private lateinit var dataPassListener: DetailPass
    private lateinit var binding: ActivityDetailBinding
    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        var season: String
        binding.Date.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                    binding.Date.text = "$selectedYear-${selectedMonth + 1}-$selectedDay"
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        if (month == 1 || month == 2 || month == 10 || month == 11 || month == 12) {
            season = "winter"
        } else if (month == 3 || month == 4 || month == 5 || month == 6 || month == 7) {
            season = "summer"
        } else {
            season = "rainy"
        }

        binding.submit.setOnClickListener {
            if (binding.city.text.isNullOrEmpty() or binding.city.text.isNullOrEmpty()) {
                Toast.makeText(this, "Please Fill all details", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.Date.text.equals("DATE")) {
                    Toast.makeText(this, "Please Select a Date", Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                    dataPassListener.onDataPassed(
                        binding.city.text.toString(),
                        season,
                        binding.Date,
                        binding.rating.text.toString(),
                        binding.scrCity.text.toString()
                    )
                }
            }
        }
    }

    override fun onDataPassed(
        city: String,
        season: String,
        Date: AppCompatButton,
        rating: String,
        scrCity: String
    ) {
    }
}
