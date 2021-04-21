package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivityProfileBinding
import com.example.week3.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    public lateinit var viewModel : MainViewModel
    public lateinit var viewModelFactory : MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModelFactory = MainViewModelFactory("","","","")
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.apply {

        }
        binding.account = viewModel.account.value
        viewModel.account.observe(this@SignUpActivity, Observer {account ->
            binding.buttonLogIn.setOnClickListener{
                Singleton.instance!!.userName  = binding.etSignupUsername.text.toString()
                Singleton.instance!!.password = binding.editTextPassword.text.toString()
                Singleton.instance!!.email = binding.etSignupEmail.text.toString()
                val intent = Intent(this@SignUpActivity,LoginActivity::class.java)
                startActivity(intent)
            }
        })

    }
}