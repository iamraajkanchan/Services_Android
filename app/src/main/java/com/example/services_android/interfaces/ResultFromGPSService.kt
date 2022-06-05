package com.example.services_android.interfaces

/**
 * ResultFromGPSService interacts with GPSService and BindServiceActivity.
 * */
interface ResultFromGPSService
{
    /**
     * getResult method return the result from GPGService to BindServiceActivity.
     * */
    fun getResult(result : String)
}