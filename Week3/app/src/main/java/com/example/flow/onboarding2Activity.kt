package com.example.flow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class onboarding2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        supportActionBar?.hide()
        val nextButton2 = findViewById<Button>(R.id.nextButt2)
        nextButton2.setOnClickListener {
            val intent = Intent(this, onboarding3Activity::class.java)
            startActivity(intent)
        }
    }
}