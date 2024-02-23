package com.example.rideapps.view

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com. example.rideapps.databinding.ActivityLoginBinding
import com.example.rideapps.model.User
import com.example.rideapps.model.dataDummy
import com.example.rideapps.ViewBindingExt.viewBinding
import com.example.rideapps.view.DashboardActivity
import java.net.PasswordAuthentication


class LoginActivity : AppCompatActivity() {

    private var loginAttempts = 0
    private lateinit var user : User

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        user = dataDummy()

        binding.buttonLogin.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passEditText.text.toString().toIntOrNull()

            if (username == user.username && password == user.password) {
                openMainMenu()
            } else {
                loginAttempts++
                if (loginAttempts >= 3) {
                    showResetPasswordDialog()
                } else {
                    showWrongCredentialsDialog()
                }
            }
        }

        binding.registerAccount.apply {
            paintFlags = paintFlags or Paint.UNDERLINE_TEXT_FLAG
        }

        binding.forgotPass.setOnClickListener {
            Toast.makeText(this, "Cooming Soon", Toast.LENGTH_SHORT).show()
        }

        binding.registerAccount.setOnClickListener {
            Toast.makeText(this, "Cooming Soon", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openMainMenu() {
        startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
        finish()
    }

    private fun showWrongCredentialsDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Wrong username or password")
            .setMessage("Please check your username and password and try again.")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showResetPasswordDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Reset Password")
            .setMessage("You've reached the maximum login attempts. Would you like to reset your password?")
            .setPositiveButton("Reset") { _, _ ->
                Toast.makeText(this, "Cooming Soon", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun dataDummy(): User {
        return User("rideforfun", 123456)
    }

    fun Masuk(view: View) {}

}

data class User(val username: String, val password: Int)