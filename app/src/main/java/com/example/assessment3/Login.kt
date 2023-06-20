package com.example.assessment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.assessment3.databinding.ActivityLoginBinding
import com.example.assessment3.databinding.ActivityMainBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        validateInput()
    }

    fun validateInput() {
        binding.tilUserName.error = null
        val userName = binding.etUserName.text.toString()
        val password = binding.etpassword.text.toString()
        var error = false

        if (userName.isBlank()) {
            binding.tilUserName.error = "Username is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilpassword.error = "Password is required"
            error = true
        }
    }
}