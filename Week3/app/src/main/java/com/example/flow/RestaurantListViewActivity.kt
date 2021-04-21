package com.example.flow

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flow.databinding.RestaurantListViewBinding
import com.example.week3.RestaurantListViewModel

class RestaurantListViewActivity: AppCompatActivity(){

    private lateinit var viewModel: RestaurantListViewModel
    private lateinit var binding: RestaurantListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.restaurant_list_view)
        viewModel = ViewModelProvider(this).get(RestaurantListViewModel::class.java)

        val adapter = Restaurent_adapter_NhaTien()
        binding.rcList.adapter = adapter
        adapter.data = getDataSet()
    }
}