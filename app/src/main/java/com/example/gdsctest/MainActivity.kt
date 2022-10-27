package com.example.gdsctest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    // predefine varaibles for elements in XML
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var numgenbutton: Button
    lateinit var timerButton: Button
    lateinit var imageView: ImageView


    //  Optional, for the GDSC image
    var rotated = false


    override fun onCreate(savedInstanceState: Bundle?) {
        // basic settings given by system
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find element IDs from the XML
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        numgenbutton = findViewById(R.id.numgenbutton)
        timerButton = findViewById(R.id.timerButton)
        imageView = findViewById(R.id.imageView)

        // when button1 is cliked on user
        button1.setOnClickListener {
            // toast a message

        }


        button2.setOnClickListener {
            // link an activity into main program

            // start the activity

        }


        numgenbutton.setOnClickListener {
            //  Start the "NumGenActivity"

        }


        timerButton.setOnClickListener {
            //  Start the "TimerActivity"

        }



        //  Optional, but quite interesting
        imageView.setOnClickListener{
            // animates when on click
            imageView.animate().rotation(if(!rotated) 180F else 0F).start();
            rotated = !rotated
        }

    }
}