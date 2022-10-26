package com.example.gdsctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TestActivity : AppCompatActivity() {
    lateinit var backbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_generator)
        backbutton = findViewById(R.id.backButton)
        backbutton.setOnClickListener {
            finish()
        }
    }
}