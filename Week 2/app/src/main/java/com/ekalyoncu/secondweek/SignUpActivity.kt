package com.ekalyoncu.secondweek

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity(){

    private lateinit var buttonBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        buttonBack = findViewById(R.id.sign_up_button_back)

        buttonBack.setOnClickListener {
            finish() // Activity'i sonlandırır.
        }
    }
}