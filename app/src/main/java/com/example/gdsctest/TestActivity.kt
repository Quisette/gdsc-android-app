package com.example.gdsctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TestActivity : AppCompatActivity() {

    lateinit var backbutton: Button

    //  This will be called once on initialization
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_generator)

        supportActionBar?.title = "GDSC New Activity Instance"

        //  Find the view object


        //  Listen to and handle the click listener
        backbutton.setOnClickListener {
            // closes this activity

        }
    }
}