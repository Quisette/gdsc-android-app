package com.example.gdsctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TimerActivity : AppCompatActivity() {
    lateinit var textClock:TextView
    lateinit var minuteInput:EditText
    lateinit var secondInput:EditText
    lateinit var resetButton:Button
    lateinit var toggleButton:Button
    lateinit var time: CountDownTimer
    var isTicking  = false
    var totalSeconds=0
    var remainingTime = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        supportActionBar?.title = "GDSC Countdown Timer"
        resetButton = findViewById(R.id.resetButton)
        toggleButton = findViewById(R.id.toggleButton)
        textClock = findViewById(R.id.textClock)
        minuteInput = findViewById(R.id.minuteInput)
        secondInput= findViewById(R.id.secondInput)

        toggleButton.setOnClickListener {
            if(minuteInput.text.toString() == "" || secondInput.text.toString() == "" || minuteInput.text.toString().toInt() >= 60 || secondInput.text.toString().toInt() >= 60){
                Toast.makeText(this@TimerActivity, "Your input is invalid. ",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var minute  =Integer.parseInt(minuteInput.text.toString())
            var second  = Integer.parseInt(secondInput.text.toString())
            totalSeconds =  second + 60 * minute
            remainingTime = if(remainingTime == 0 ) totalSeconds else remainingTime
            if(!isTicking){
                isTicking = true
                resetButton.visibility = View.VISIBLE
                toggleButton.text = "pause"
                time = object:CountDownTimer(remainingTime * 1000L, 1000L){
                    override fun onTick(remainingTimeRaw: Long) {
                        remainingTime = (remainingTimeRaw/1000).toInt()
                        val secondNumber = remainingTime % 60
                        val minuteNumber =(remainingTime - secondNumber)/60
                        val secondStr = if(secondNumber < 10) "0$secondNumber" else secondNumber.toString()
                        val minuteStr = if(minuteNumber < 10) "0$minuteNumber" else minuteNumber.toString()
                        textClock.text = "$minuteStr:$secondStr"
                    }

                    override fun onFinish() {
                        toggleButton.text = "start"
                        isTicking = false
                        Toast.makeText(this@TimerActivity,"time's up!",Toast.LENGTH_SHORT).show()
                        resetButton.visibility = View.GONE

                    }
                }
                time.start()
            }else {
                toggleButton.text = "resume"
                time.cancel()
                isTicking = false
            }
        }
        resetButton.setOnClickListener {
            if( remainingTime != 0){
                toggleButton.text = "Start"
                time.cancel()
                remainingTime = 0
                textClock.text = "00:00"
                isTicking = false
                resetButton.visibility = View.GONE

            }
        }


    }

}
