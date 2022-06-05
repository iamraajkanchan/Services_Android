package com.example.services_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * LogServiceActivity
 * */
class LogServiceActivity : AppCompatActivity()
{
    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_service)
        Intent(this , LogService::class.java).apply {
            startService(this)
        }
    }
}