package com.example.services_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.services_android.services.MyIntentService

/**
 * IntentServiceActivity
 * */
class IntentServiceActivity : AppCompatActivity()
{
    /**
     * onCreate callback function of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)
        Intent(this , MyIntentService::class.java).apply {
            startService(this)
        }
    }
}