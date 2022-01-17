package com.example.services_android

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class LogService : Service()
{
    companion object
    {
        const val TAG = "LogService"
    }

    override fun onCreate()
    {
        printLogs("onCreate")
        super.onCreate()
    }

    override fun onBind(intent : Intent) : IBinder?
    {
        return null;
    }

    override fun onStartCommand(intent : Intent? , flags : Int , startId : Int) : Int
    {
        printLogs("onStartCommand")
        val runnable = Runnable {
            for (i in 1 .. 10)
            {
                printLogs("Something is running the background...")
                Thread.sleep(1000)
            }
            stopSelf()
        }
        val thread = Thread(runnable)
        thread.start()
        return super.onStartCommand(intent , flags , startId)
    }

    override fun onDestroy()
    {
        printLogs("onDestroy")
        super.onDestroy()
    }

    private fun printLogs(message : String)
    {
        Log.d(TAG , message)
    }
}