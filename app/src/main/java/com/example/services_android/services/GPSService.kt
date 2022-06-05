package com.example.services_android.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.example.services_android.interfaces.ResultFromGPSService

/**
 * GPSService
 * */
class GPSService : Service()
{
    private lateinit var resultFromGPSService : ResultFromGPSService
    private val gpsServiceBinder : IBinder = GPSBinder()

    /**
     * onBind callback method of the Activity.
     * @param intent
     * */
    override fun onBind(intent : Intent?) : IBinder?
    {
        return gpsServiceBinder
    }

    /**
     * registerCallback method is used to initialize the ResultFromGPSService Interface.
     * */
    fun registerCallBack(resultFromGPSService : ResultFromGPSService?)
    {
        this.resultFromGPSService = resultFromGPSService ?: return
        sendResultFromGPSService()
    }

    /**
     * sendResultFromGPSService method is used to send a value from GPSService to the Binding Activity.
     * */
    private fun sendResultFromGPSService()
    {
        this.resultFromGPSService.getResult("Hello GPS Service!!!")
    }

    /**
     * GPSBinder class to declare and initialize IBinder for GPSService Service.
     * */
    class GPSBinder() : Binder()
    {
        /**
         * getService method returns an instance of GPSService.
         * */
        fun getService() : GPSService = GPSService()
    }
}