package com.example.week3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    var account : DataStore = DataStore(userName = "", email = "", password = "")

}