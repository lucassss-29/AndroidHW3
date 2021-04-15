package com.example.week3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(username : String, password : String, email: String, phone: String) : ViewModel() {
    var account : MutableLiveData<DataStore> = MutableLiveData()
    init{
        account.value = DataStore(username,password,email,phone)
    }
    fun setAccount(username: String, email: String, phone: String){
        account.value?.userName = username
        account.value?.email = email
        account.value?.phoneNumber = phone
        account.postValue(account.value)
    }
    fun setAccountPassword(username: String, password: String, email: String){
        account.value?.userName = username
        account.value?.email = email
        account.value?.password = password
        account.postValue(account.value)
    }
    var password : String = password
    get() = field
    var email :String = email
    get() = field
}