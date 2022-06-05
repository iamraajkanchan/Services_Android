package com.example.services_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * MainActivity
 * */
class MainActivity : AppCompatActivity()
{
    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent(this , LogService::class.java).apply {
            startService(this)
        }
    }
}