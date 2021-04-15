package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    private lateinit var viewModel: SignUpViewModel
    var account:DataStore = DataStore(userName = "", email = "", password = "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.buttonSignup.setOnClickListener {
            viewModel.account.userName = binding.etSignupUsername.text.toString().trim()
            viewModel.account.email = binding.etSignupEmail.text.toString().trim()
            viewModel.account.password = binding.etSignupPassword.text.toString().trim()
        }


    }
}