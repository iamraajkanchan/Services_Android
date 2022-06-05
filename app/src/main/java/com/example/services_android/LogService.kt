package com.example.services_android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

private const val SERVICE_MESSAGE = "Something is running the background..."

/**
 * LogService
 * */
class LogService : Service()
{
    companion object
    {
        /**
         * TAG is a constant used to tag the logs generated from LogService class.
         * */
        const val TAG : String = "LogService"
    }

    /**
     * onCreate callback method of the service.
     * */
    override fun onCreate()
    {
        super.onCreate()
        printLogs("onCreate")
    }

    /**
     * onBind callback method of the Service.
     * */
    override fun onBind(intent : Intent) : IBinder?
    {
        return null
    }

    /**
     * onStartCommand callback method of the Service.
     * @param intent
     * @param flags
     * @param startId
     * */
    override fun onStartCommand(intent : Intent? , flags : Int , startId : Int) : Int
    {
        printLogs("onStartCommand")
        val runnable = Runnable {
            for (i in 1 .. 10)
            {
                printLogs(SERVICE_MESSAGE)
                Thread.sleep(1000)
            }
            stopSelf()
        }
        val thread = Thread(runnable)
        thread.start()

        /* thread.interrupt() - Do not use this command in android. */
        return super.onStartCommand(intent , flags , startId)
    }

    /**
     * onDestroy callback method of the Service.
     * */
    override fun onDestroy()
    {
        super.onDestroy()
        printLogs("onDestroy")
    }

    /**
     * printLogs method is used to print logs from LogService class.
     * */
    private fun printLogs(message : String)
    {
        Log.d(TAG , message)
    }
}