package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivityProfileBinding
import com.example.week3.databinding.EditprofileDialogBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var viewModelFactory : MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

        /*add data from login to here*/
        viewModelFactory = MainViewModelFactory("Chau Chan Vi","cchanvi99@gmail.com","0835018510")
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.apply {
            txtprofile.setOnClickListener { showDialog() }
        }

        binding.account = viewModel.account.value
        viewModel.account.observe(this, Observer {account ->
            binding.nameTxt.text = account.username
            binding.editTextTextPersonName.setText(account.username)
            binding.editEmail.setText(account.email)
            binding.editTextPhone.setText(account.phoneNumber)
        })
    }

    private fun showDialog() {
        /*Set laytout */
        val dialogBinding : EditprofileDialogBinding? = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.editprofile_dialog,null,false)
        val customDialog = AlertDialog.Builder(this,0).create()
        customDialog.apply {
            setView(dialogBinding?.root)
            setCancelable(false)
        }.show()
        /* action OK */
        dialogBinding?.dialogOkbtn?.setOnClickListener {
            viewModel.setAccount(dialogBinding.dialogeditTextTextPersonName.text.toString(),
                dialogBinding.dialogeditTextTextEmailAddress.text.toString(),
                dialogBinding.dialogeditTextPhone.text.toString())
            customDialog.dismiss()
        }
        /* action Cancle*/
        dialogBinding?.dialogCancleBtn?.setOnClickListener {
            customDialog.dismiss()
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
    override fun onRestart() {
        super.onRestart()
    }
}