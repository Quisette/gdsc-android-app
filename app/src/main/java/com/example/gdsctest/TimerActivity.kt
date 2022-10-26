package com.example.gdsctest

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class TimerActivity : AppCompatActivity() {
    // predefine varaibles for elements in XML
    lateinit var textClock:TextView
    lateinit var minuteInput:EditText
    lateinit var secondInput:EditText
    lateinit var resetButton:Button
    lateinit var toggleButton:Button
    lateinit var countDownTimer: CountDownTimer
    lateinit var mediaPlayer: MediaPlayer
    // global constants
    var isTicking  = false

    var remainingTime = 0
    // when this activity is up:
    override fun onCreate(savedInstanceState: Bundle?) {
        //initializations
        mediaPlayer = MediaPlayer.create( this, R.raw.se); // media player initialization
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        // modify texts in the top bar
        supportActionBar?.title = "GDSC Countdown Timer"
        // find element IDs from the XML
        resetButton = findViewById(R.id.resetButton)
        toggleButton = findViewById(R.id.toggleButton)
        textClock = findViewById(R.id.textClock)
        minuteInput = findViewById(R.id.minuteInput)
        secondInput= findViewById(R.id.secondInput)
        // when button is clicked:
        toggleButton.setOnClickListener {
            // error detection of invalid input
            if(minuteInput.text.toString() == "" || secondInput.text.toString() == "" || minuteInput.text.toString().toInt() >= 60 || secondInput.text.toString().toInt() >= 60){
                // toast error message
                Toast.makeText(this@TimerActivity, "Your input is invalid. ",Toast.LENGTH_SHORT).show()
                // force the function to end
                return@setOnClickListener
            }
            // pass the inputs and transform them into Int format
            var minute  = Integer.parseInt(minuteInput.text.toString())
            var second  = Integer.parseInt(secondInput.text.toString())

            // calculates the total seconds
//            totalSeconds =  second + 60 * minute

            // if the remaining time reaches to zero, the remaining time should be reset.
            // Otherwise, remaining time should be its current state.
            remainingTime = if(remainingTime == 0 ) ( second + 60 * minute) else remainingTime

            if(!isTicking){ // detects if a timer is running process
                isTicking = true // change the state
                resetButton.visibility = View.VISIBLE // shows reset button
                toggleButton.text = "pause" // change the text of toggle button

                // a countdown timer with adjustable time and countdown interval in milliseconds
                countDownTimer = object:CountDownTimer(remainingTime * 1000L, 1000L){
                    override fun onTick(remainingTimeRaw: Long) {
                        remainingTime = (remainingTimeRaw/1000).toInt()
                        // parse remainingTime into normal view
                        val secondNumber = remainingTime % 60
                        val minuteNumber =(remainingTime - secondNumber)/60
                        //add extra zeros on one-digit second/minute number
                        val secondStr = if(secondNumber < 10) "0$secondNumber" else secondNumber.toString()
                        val minuteStr = if(minuteNumber < 10) "0$minuteNumber" else minuteNumber.toString()
                        // change the text of textClock
                        textClock.text = "$minuteStr:$secondStr"
                    }

                    override fun onFinish() {
                        // code in here executes only if the countdown is over.
                        toggleButton.text = "start"
                        // set the state back
                        isTicking = false
                        // play sounds
                        mediaPlayer.start()
                        // toast alerts
                        Toast.makeText(this@TimerActivity,"time's up!",Toast.LENGTH_SHORT).show()
                        // let the reset button invisible
                        resetButton.visibility = View.GONE

                    }
                }
                countDownTimer.start()
            }else {
                toggleButton.text = "resume"
                countDownTimer.cancel()
                isTicking = false
            }
        }
        resetButton.setOnClickListener {
            if( remainingTime != 0){
                //back to initial state
                toggleButton.text = "Start"
                countDownTimer.cancel()
                remainingTime = 0
                textClock.text = "00:00"
                isTicking = false
                resetButton.visibility = View.GONE

            }
        }



    }

    override fun onBackPressed() {
        super.onBackPressed()
        countDownTimer.cancel()
    }

}
