package com.oguzel.kotlincountdown

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var switch : Int = 0
    var number = 0
    var runnable: Runnable = Runnable{}
    var handler: Handler = Handler()
    var minute = 0
    var second = 0
    var minute1 = 0
    var second1 = 0
    var minute2 = 0
    var second2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myText = findViewById<TextView>(R.id.textView)
        val startButton = findViewById<Button>(R.id.button)
        val stopButton = findViewById<Button>(R.id.button2)



        startButton.setOnClickListener {
            start(myText)
        }
        stopButton.setOnClickListener {
            stop(myText)
        }




        /**CountDown

        object: CountDownTimer(10000,1000){


        override fun onTick(p0: Long) {
        myText.text= "Left: ${p0/1000}"
        }

        override fun onFinish() {
        myText.text = "Left=0"
        }

        }.start()
        }
         */
    }
    fun start(textview : TextView) {

        if (switch == 0) {
            number = 0

            runnable = object : Runnable {
                @SuppressLint("SetTextI18n")
                override fun run() {
                    number++
                    minute = number/60
                    minute1 = minute/10
                    minute2 = minute%10

                    second = number%60
                    second1 = second/10
                    second2 = second%10

                    println("number: $number , minute: $minute , second: $second")
                    textview.text = "Time: ${minute1}${minute2}:${second1}${second2}"
//                    textview.text = "Time: ${number}"
                    handler.postDelayed(this, 1)
                }
            }
            handler.post(runnable)
            switch = 1
        }
    }

    @SuppressLint("SetTextI18n")
    fun stop(textview: TextView){
        handler.removeCallbacks(runnable)
        number = 0
        textview.text="Time: 0"
        switch=0
    }
}

