package com.example.rideapps.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import com.example.rideapps.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            if (isNetworkAvailable()) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                showConnectionDialog()
            }
        }, SPLASH_TIME_OUT)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun showConnectionDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Connection Error")
        builder.setMessage("Bad connection, please try again!")
        builder.setPositiveButton("Try Again") { dialog, _ ->
            dialog.dismiss()
            recreate()
        }
        builder.setOnCancelListener {
            finish()
        }
        val dialog = builder.create()
        dialog.show()
    }
}