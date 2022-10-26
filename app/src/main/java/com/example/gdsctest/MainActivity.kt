package com.example.gdsctest

import android.animation.ObjectAnimator
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
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
            // toast the message
            Toast.makeText(this@MainActivity, "test",Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            // link an activity into main program
            val intent =  Intent(this@MainActivity, TestActivity::class.java)
            // start the activity
            startActivity(intent)
        }
        numgenbutton.setOnClickListener {
            val intent = Intent(this@MainActivity, NumGenActivity::class.java)
            startActivity(intent)
        }
        timerButton.setOnClickListener {
            val intent  = Intent(this@MainActivity, TimerActivity::class.java)
            startActivity(intent)
        }
        imageView.setOnClickListener{
            // animates when on click
            imageView.animate().rotation(if(!rotated) 180F else 0F).start();
            rotated = !rotated
        }










    }
}