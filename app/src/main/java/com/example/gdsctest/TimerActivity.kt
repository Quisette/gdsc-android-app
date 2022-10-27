package com.example.gdsctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast



//  The activity class
class TimerActivity : AppCompatActivity() {

    // XML view references
    lateinit var textClock:TextView
    lateinit var minuteInput:EditText
    lateinit var secondInput:EditText
    lateinit var resetButton:Button
    lateinit var toggleButton:Button

    //  Our countdown timer
    lateinit var countDownTimer: CountDownTimer

    // A flag indicating if the timer is running
    var isTicking  = false

    //  How much time remaining, in seconds
    var remainingTime = 0


    //  When this activity starts
    //  onCreate will be run once
    override fun onCreate(savedInstanceState: Bundle?) {
        // Default initialization, don't touch these two lines
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        //  Below this line, we add our own initialization code

        // Change the status bar text
        supportActionBar?.title = "GDSC Countdown Timer"

        // find element IDs from the XML
        resetButton = findViewById(R.id.resetButton)
        toggleButton = findViewById(R.id.toggleButton)
        textClock = findViewById(R.id.textClock)
        minuteInput = findViewById(R.id.minuteInput)
        secondInput= findViewById(R.id.secondInput)



        // Define the countdown timer, with adjustable time and countdown interval, in milliseconds
        countDownTimer = object:CountDownTimer(remainingTime * 1000L, 1000L){

            // Every time the timer ticks, in our case every one second
            override fun onTick(remainingTimeRaw: Long) {

                // update remainingTime to ticked value

                // parse remainingTime into normal view

                //add extra zeros on one-digit second/minute number

                // change the text of textClock

            }

            //  When the timer finishes, i.e. remaining time = 0
            override fun onFinish() {

                // change the toggleButton text to "start"

                // set the timer status to "not ticking"

                // toast a message to indicate that countdown has completed

                // hide the reset button

            }
        }


        // when the start button is clicked:
        toggleButton.setOnClickListener {
            // error detection of invalid input
            if(minuteInput.text.toString() == "" || secondInput.text.toString() == "" || minuteInput.text.toString().toInt() >= 60 || secondInput.text.toString().toInt() >= 60){
                // toast error message
                Toast.makeText(this@TimerActivity, "Your input is invalid. ",Toast.LENGTH_SHORT).show()
                // force the function to end
                return@setOnClickListener
            }

            // pass the inputs and transform them into Int format
            val minute  = Integer.parseInt(minuteInput.text.toString())
            val second  = Integer.parseInt(secondInput.text.toString())


            // if the remaining time reaches to zero, the remaining time should be reset.
            // Otherwise, remaining time should be its current state.
            remainingTime = if(remainingTime == 0 ) ( second + 60 * minute) else remainingTime


            //  If the timer is not running
            if(!isTicking) {
                isTicking = true                            // change the state to true
                resetButton.visibility = View.VISIBLE       // shows reset button
                toggleButton.text = "pause"                 // change the text of toggle button

                //  Start the timer
                countDownTimer.start()
            }

            //  If the timer is already running, this button works as a pause button
            else {
                // pause the timer
                countDownTimer.cancel()

                //  Update the button text and status
                toggleButton.text = "resume"
                isTicking = false
            }
        }


        //  Handle the reset button click
        //  This stops and resets the timer
        resetButton.setOnClickListener {

            //  Stop the timer
            countDownTimer.cancel()

            //  Reset the statuses
            remainingTime = 0
            isTicking = false

            //  Reset the texts
            toggleButton.text = "Start"
            textClock.text = "00:00"

            //  Hide the button after being clicked
            resetButton.visibility = View.GONE

        }



    }


    //  When the user go back, or click the back button
    //  the this activity will be closed
    //  but the timer is still running in the background
    //  so we need to stop it here
    override fun onBackPressed() {
        super.onBackPressed()
        countDownTimer.cancel()
    }

}
