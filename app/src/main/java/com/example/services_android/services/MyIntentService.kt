package com.example.services_android.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

/**
 * MyIntentService stops itself after its execution is complete means all the code in onHandleIntent block is executed.
 * */
class MyIntentService : IntentService("MyIntentService")
{
    private val TAG : String = "MyIntentService"

    /**
     * onHandleIntent callback method of IntentService
     * */
    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent : Intent?)
    {
        Log.i(TAG , "MyIntentService :: onHandleIntent :: Service Started")
    }

    /**
     * onDestroy callback method of IntentService.
     * */
    @Deprecated("Deprecated in Java")
    override fun onDestroy()
    {
        super.onDestroy()
        Log.i(TAG , "MyIntentService :: onDestroy :: Service Stopped")
    }
}