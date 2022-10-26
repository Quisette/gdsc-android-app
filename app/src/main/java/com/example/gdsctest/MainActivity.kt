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
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var numgenbutton: Button
    lateinit var timerButton: Button
    lateinit var imageView: ImageView
    var rotated = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "GDSC Kotlin & Android Lab"
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        numgenbutton = findViewById(R.id.numgenbutton)
        timerButton = findViewById(R.id.timerButton)
        imageView = findViewById(R.id.imageView)
        button1.setOnClickListener {
            Toast.makeText(this@MainActivity, "test",Toast.LENGTH_SHORT).show()
        }
        button2.setOnClickListener {
            val intent =  Intent(this@MainActivity, TestActivity::class.java)
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


            imageView.animate().rotation(if(!rotated) 180F else 0F).start();
            rotated = !rotated
        }










    }
}