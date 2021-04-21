package com.example.week3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory(val username: String, val password : String, val email: String, val phone: String) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(username,password,email,phone) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}