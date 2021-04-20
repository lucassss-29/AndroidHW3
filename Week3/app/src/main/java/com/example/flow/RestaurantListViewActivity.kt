package com.example.flow

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.flow.databinding.RestaurantListViewBinding
import com.example.week3.RestaurantListViewModel

//import  com.example.flow.

class RestaurantListViewActivity: AppCompatActivity(){
    private lateinit var viewModel: RestaurantListViewModel
    private lateinit var binding: RestaurantListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataBindingUtil.setContentView(this, R.layout.list_restaurant)
        setContentView(R.layout.restaurant_list_view)
    }
}