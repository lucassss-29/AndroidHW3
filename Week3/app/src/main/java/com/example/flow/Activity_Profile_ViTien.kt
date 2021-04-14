package com.example.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog


class Activity_Profile_ViTien : AppCompatActivity() {
    lateinit var editTextName : EditText
    lateinit var editTextGmail : EditText
    lateinit var editTextPhone : EditText
    lateinit var nameTxt : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_vitien)
        supportActionBar?.hide()
        //val txtFullname = findViewById<TextView>(R.id.txtFullname)
        val txtFullname = findViewById<TextView>(R.id.editTextTextPersonName)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val txtPhone = findViewById<TextView>(R.id.txtPhoneNumber)
        editTextName = findViewById(R.id.editTextTextPersonName)
        txtEmail.setOnClickListener { showDialog() }
        txtFullname.setOnClickListener { showDialog() }
        txtPhone.setOnClickListener { showDialog()  }
    }
    private fun showDialog() {

        editTextName = findViewById(R.id.editTextTextPersonName)
        editTextGmail = findViewById(R.id.editTextTextEmailAddress)
        editTextPhone = findViewById(R.id.editTextPhone)
        nameTxt = findViewById(R.id.nameTxt)

        /*Set laytout */
        val mDialogView= LayoutInflater.from(this).inflate(R.layout.editprofile_dialog,null)

        /* Declare view */
        val dialogeditTextGmail = mDialogView.findViewById<EditText>(R.id.dialogeditTextTextEmailAddress)
        val dialogeditTextPhone  = mDialogView.findViewById<EditText>(R.id.dialogeditTextPhone)
        val dialogeditTextName  = mDialogView.findViewById<EditText>(R.id.dialogeditTextTextPersonName)
        val dialogBtnOK = mDialogView.findViewById<Button>(R.id.dialogOkbtn)
        val dialogBtnCancle = mDialogView.findViewById<Button>(R.id.dialogCancleBtn)

        /*Acction */
        val alertDialog = AlertDialog.Builder(this).setView(mDialogView).setTitle("Edit Form")
        val mAlertDialog = alertDialog.show()
        dialogBtnOK.setOnClickListener {
            editTextName.setText(dialogeditTextName.text.toString())
            editTextGmail.setText(dialogeditTextGmail.text.toString())
            editTextPhone.setText(dialogeditTextPhone.text.toString())
            nameTxt.setText(dialogeditTextName.text.toString())
            mAlertDialog.dismiss()
        }
        dialogBtnCancle.setOnClickListener { mAlertDialog.dismiss() }
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