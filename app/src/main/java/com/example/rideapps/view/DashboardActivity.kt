package com.example.rideapps.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rideapps.ViewBindingExt.viewBinding
import com.example.rideapps.databinding.ActivityDashboardBinding
import id.rideapps.convers.DistanceConversActivity
import id.rideapps.convers.MasaConversActivity
import id.rideapps.convers.TemperatureConversActivity
import id.rideapps.convers.TimeConversActivity


class DashboardActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityDashboardBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.menuSuhu.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, TemperatureConversActivity::class.java))
        }

        binding.menuJarak.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, DistanceConversActivity::class.java))
        }

        binding.menuMasa.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, MasaConversActivity::class.java))
        }

        binding.menuWaktu.setOnClickListener {
            startActivity(Intent(this@DashboardActivity, TimeConversActivity::class.java))
        }

    }
}