package com.example.week3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(username : String, email: String, phone: String) : ViewModel() {
    var account : MutableLiveData<DataStore> = MutableLiveData()
    init{
        account.value = DataStore(username,email,phone)
    }
    fun setAccount(username: String,email: String, phone: String){
        account.value?.username = username
        account.value?.email = email
        account.value?.phoneNumber = phone
        account.postValue(account.value)
    }
}