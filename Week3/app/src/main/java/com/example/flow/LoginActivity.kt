package com.example.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flow.databinding.LoginBinding
import com.example.week3.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : LoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.buttonLogIn.setOnClickListener{
            viewModel.account.email = binding.inputEmail.text.toString()
            viewModel.account.password = binding.inputPassword.text.toString()
            if(viewModel.account.password == "123456" && viewModel.account.email == "ronaldo@gmail.com"){
                Toast.makeText( this@LoginActivity, "Login Successfully", Toast.LENGTH_SHORT).show()
                // val intent = Intent(this, Activity_Profile_ViTien::class.java)
                startActivity(intent)
            }else{
                Toast.makeText( this@LoginActivity, "Login Failed! Please try again.", Toast.LENGTH_SHORT).show()
            }
            binding.account = viewModel.account
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