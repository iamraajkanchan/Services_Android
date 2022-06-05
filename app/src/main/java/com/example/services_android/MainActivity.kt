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
    private lateinit var btnBindServiceActivity : Button

    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLoginActivity = findViewById(R.id.btnLogActivity)
        btnThreadActivity = findViewById(R.id.btnThreadActivity)
        btnBindServiceActivity = findViewById(R.id.btnBindServiceActivity)
    }

    /**
     * onStart callback method of the Activity.
     * */
    override fun onStart()
    {
        super.onStart()
        btnLoginActivity.setOnClickListener {
            Intent(this , LogServiceActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
        btnThreadActivity.setOnClickListener {
            Intent(this , ThreadActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
        btnBindServiceActivity.setOnClickListener {
            Intent(this , BindServiceActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(this)
            }
        }
    }
}