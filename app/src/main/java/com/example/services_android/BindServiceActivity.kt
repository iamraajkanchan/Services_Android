package com.example.services_android

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.TextView
import com.example.services_android.interfaces.ResultFromGPSService
import com.example.services_android.services.GPSService

/**
 * Reference:
 * https://stackoverflow.com/questions/2463175/how-to-have-android-service-communicate-with-activity
 * */

/**
 * BindServiceActivity
 * */
class BindServiceActivity : AppCompatActivity() , ResultFromGPSService
{
    private var notifyMeIntent : Intent? = null
    private lateinit var tvResult : TextView
    private lateinit var gpsService : GPSService
    private var isBounded : Boolean? = null
    private val serviceConnection = object : ServiceConnection
    {
        override fun onServiceConnected(name : ComponentName? , service : IBinder?)
        {
            val binder = service as GPSService.GPSBinder
            gpsService = binder.getService()
            isBounded = true
            gpsService.registerCallBack(this@BindServiceActivity)
        }

        override fun onServiceDisconnected(name : ComponentName?)
        {
            isBounded = false
        }
    }

    /**
     * onCreate callback method of the Activity.
     * */
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bind_service)
        tvResult = findViewById(R.id.tvResult)
        startGPSService()
    }

    /**
     * onStart callback method of the Activity.
     * */
    override fun onStart()
    {
        super.onStart()
        bindGPSService()
    }

    /**
     * onStop callback method of the Activity.
     * */
    override fun onStop()
    {
        super.onStop()
        unbindGPSService()
    }

    /**
     * startGPSService is used to start GPSService.
     * */
    private fun startGPSService()
    {
        notifyMeIntent = Intent(this , GPSService::class.java)
        startService(notifyMeIntent)
    }

    /**
     * bindGPSService is used to bind GPSService with BindServiceActivity.
     * */
    private fun bindGPSService()
    {
        bindService(notifyMeIntent , serviceConnection , Context.BIND_AUTO_CREATE)
    }

    private fun unbindGPSService()
    {
        if (isBounded ?: return)
        {
            gpsService.registerCallBack(null)
            unbindService(serviceConnection)
            isBounded = false
        }
    }

    /**
     * getResult method is implemented from the interface to get the result from
     * @param result
     * */
    override fun getResult(result : String)
    {
        tvResult.text = result
    }

}