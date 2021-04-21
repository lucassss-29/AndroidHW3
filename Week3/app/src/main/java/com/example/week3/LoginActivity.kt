package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivityLoginBinding
import com.example.week3.databinding.ActivitySignUpBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var viewModelFactory : MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)
        viewModelFactory = MainViewModelFactory(Singleton.instance!!.userName,Singleton.instance!!.password,Singleton.instance!!.email,Singleton.instance!!.phoneNumber)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.apply {

        }
        binding.account = viewModel.account.value
        viewModel.account.observe(this, Observer {account ->
            binding.buttonLogIn.setOnClickListener {
                if ((binding.inputEmail.text.toString().equals(account.email)) && (binding.inputPassword.text.toString().equals(account.password))) {
                    val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Input wrong email or password. Please try again!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}