package com.example.services_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

/**
 * This const is used to notify the TextView.
 * */
const val NOTIFY_TEXTVIEW : Int = 1

/**
 * ThreadActivity
 * */
class ThreadActivity : AppCompatActivity()
{
    private lateinit var tvMessage : TextView
    private lateinit var btnShow : Button
    private val handler = object : Handler(Looper.getMainLooper())
    {
        override fun handleMessage(msg : Message)
        {
            super.handleMessage(msg)
            when (msg.what)
            {
                NOTIFY_TEXTVIEW -> tvMessage.text = "Show Button Clicked"
            }
        }
    }

    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        tvMessage = findViewById(R.id.tvMessage)
        btnShow = findViewById(R.id.btnShow)
    }

    /**
     * onStart callback method of the Activity.
     * */
    override fun onStart()
    {
        super.onStart()
        btnShow.setOnClickListener {
            try
            {
                val runnable = Runnable {
                    Thread.sleep(1000)
                    val message = Message().also {
                        it.what = NOTIFY_TEXTVIEW
                    }
                    handler.sendMessage(message)
                }
                val thread = Thread(runnable)
                thread.start()
            } catch (e : Exception)
            {
                println("ThreadActivity :: onStart :: e : ${e.message.toString()}");
            }
        }
    }
}