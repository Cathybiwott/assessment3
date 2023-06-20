package com.example.assessment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.assessment3.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener {
          validateInputs()
        }
    }
    fun validateInputs(){
        binding.tilUsername.error=null
        val userName= binding.etUsername.text.toString()
        val phoneNUmber = binding.etPhonenumber.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error =false

        if (userName.isBlank()) {
            error=true
            binding.tilUsername.error = "Username is required"
        }
        if (phoneNUmber.isBlank()) {
          error=true
            binding.tilPhonenumber.error = "Phone number is required"
        }
        if (email.isBlank()) {
           error=true
            binding.tilEmail.error = "Email address is required"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text).matches()) {
            binding.tilEmail.error = "Invalid email address format"
            error=true
        }
        if (password.isBlank()) {

            binding.tilPassword.error = "Password is required"
            error=true
        }
    if (!error){
        val intent = Intent(this,Login::class.java)
        startActivity(intent)
    }
    }
}