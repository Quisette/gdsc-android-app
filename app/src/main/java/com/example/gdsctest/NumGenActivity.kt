package com.example.gdsctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class NumGenActivity : AppCompatActivity() {
    lateinit var generateButton: Button
    lateinit var numberText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_num_gen)
        supportActionBar?.title = "Number Generator"
        generateButton = findViewById(R.id.generateButton)
        numberText = findViewById(R.id.numberText)
        genNewNumber()
        generateButton.setOnClickListener {
            genNewNumber()
        }
    }
    fun genNewNumber(){
        val number =(0..10).random()
        numberText.text = number.toString()
    }
}