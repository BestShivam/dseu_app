package com.example.desktop

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.desktop.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    private lateinit var binding : ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val sharedPref = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            // User already logged in → Skip Login
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            return  // prevent showing login UI
        }
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


        binding.signUpBtn.setOnClickListener {
            val username = binding.root.findViewById<com.google.android.material.textfield.TextInputEditText>(
                R.id.text_input_edit_email
            )?.text.toString().trim()

            val password = binding.root.findViewById<com.google.android.material.textfield.TextInputEditText>(
                R.id.text_input_edit_password
            )?.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (username == "shivam@gmail.com" && password == "12345") {
                val sharedPref = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.clear()  // clears all saved login data
                editor.apply()
                Toast.makeText(this, "Login Successful 🎉", Toast.LENGTH_SHORT).show()
                // 👉 Navigate to next screen (HomeActivity)
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Credentials ❌", Toast.LENGTH_SHORT).show()
            }
        }
    }
}