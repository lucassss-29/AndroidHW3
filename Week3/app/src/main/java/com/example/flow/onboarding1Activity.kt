package com.example.flow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class onboarding1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        supportActionBar?.hide()

        val nextButton1 = findViewById<Button>(R.id.nextButt1)
        nextButton1.setOnClickListener {
            val intent = Intent(this, onboarding2Activity::class.java)
            startActivity(intent)
        }
    }
}