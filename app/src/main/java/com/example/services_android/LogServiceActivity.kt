package com.example.services_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.services_android.services.LogService

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
            putExtra(SERVICE_HELLO_PARAM , "Hello Log Service!!!")
            startService(this)
        }
    }

    companion object
    {
        /**
         * This constant refers to the key that is sent to
         * */
        const val SERVICE_HELLO_PARAM : String = "service hello param"
    }
}