package com.example.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week3.databinding.ActivityProfileBinding
import com.example.week3.databinding.DialogEditProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProfileBinding
    private lateinit var viewModel : MainViewModel
     private lateinit var viewModelFactory : MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

        /*add data from login to here*/
        viewModelFactory = MainViewModelFactory(Singleton.instance!!.userName,Singleton.instance!!.password,Singleton.instance!!.email,Singleton.instance!!.phoneNumber)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.apply {
            textEditProfile.setOnClickListener { showDialog() }
            btnBack.setOnClickListener {
                val intent = Intent(this@ProfileActivity,LoginActivity::class.java)
                startActivity(intent)
            }
        }

        binding.account = viewModel.account.value
        viewModel.account.observe(this, Observer {account ->
            binding.textProfileName.text = account.userName
            binding.etProfileName.setText(account.userName)
            binding.etProfileEmail.setText(account.email)
            binding.etProfilePhone.setText(account.phoneNumber)
        })
    }

    private fun showDialog() {
        /*Set laytout */
        val dialogBinding : DialogEditProfileBinding = DataBindingUtil.inflate(LayoutInflater.from(this),R.layout.dialog_edit_profile,null,false)
        val customDialog = AlertDialog.Builder(this,0).create()
        customDialog.apply {
            setView(dialogBinding?.root)
            setCancelable(false)
        }.show()
        /* action OK */
        dialogBinding?.buttonDialogOk?.setOnClickListener {
            viewModel.setAccount(dialogBinding.etDialogName.text.toString(),
                dialogBinding.etDialogEmail.text.toString(),
                dialogBinding.etDialogPhone.text.toString())
            Singleton.instance!!.userName  = dialogBinding.etDialogName.text.toString()
            Singleton.instance!!.phoneNumber = dialogBinding.etDialogPhone.text.toString()
            Singleton.instance!!.email = dialogBinding.etDialogEmail.text.toString()
            customDialog.dismiss()
        }
        /* action Cancle*/
        dialogBinding?.buttonDialogCancel?.setOnClickListener {
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