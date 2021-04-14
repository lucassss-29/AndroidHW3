package com.example.flow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.flow.databinding.LoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.login)

        binding.buttonLogIn.setOnClickListener{
            if(binding.inputPassword.text.toString() == "123456" && binding.inputEmail.text.toString() == "ronaldo@gmail.com"){
                Toast.makeText( this@LoginActivity, "Login Successfully", Toast.LENGTH_SHORT).show()
                // val intent = Intent(this, Activity_Profile_ViTien::class.java)
                startActivity(intent)
            }else{
                Toast.makeText( this@LoginActivity, "Login Failed! Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}