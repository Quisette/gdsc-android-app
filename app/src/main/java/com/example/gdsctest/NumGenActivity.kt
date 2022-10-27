package com.example.gdsctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class NumGenActivity : AppCompatActivity() {

    //  Predefine the view references
    lateinit var generateButton: Button
    lateinit var numberText: TextView

    var number = 0

    //  This will be called once, when this activity starts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_num_gen)


        //  Update the status bar text to "Number Generator"


        //  Find and assign the views
        //  R.id.generateButton and R.id.numberText



        //  Listen to and handle the click event of the generate button


    }

    //  A custom function to generate a number
    //  this returns an integer between 0 and 100
    fun genNewNumber() : Int {
        return (0..100).random()
    }
}