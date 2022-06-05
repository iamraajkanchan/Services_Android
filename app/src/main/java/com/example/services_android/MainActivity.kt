package com.example.services_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/**
 * MainActivity
 * */
class MainActivity : AppCompatActivity()
{
    private lateinit var btnLoginActivity : Button
    private lateinit var btnThreadActivity : Button

    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLoginActivity = findViewById(R.id.btnLogActivity)
        btnThreadActivity = findViewById(R.id.btnThreadActivity)

        Intent(this , LogService::class.java).apply {
            startService(this)
        }
    }

    /**
     * onStart callback method of the Activity.
     * */
    override fun onStart()
    {
        super.onStart()
        btnLoginActivity.setOnClickListener {

        }
        btnThreadActivity.setOnClickListener {

        }
    }
}