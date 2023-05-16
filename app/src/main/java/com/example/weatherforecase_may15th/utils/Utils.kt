package com.example.weatherforecase_may15th.utils

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.weatherforecase_may15th.R
import java.text.SimpleDateFormat


fun getSharedPreference(activity:Activity):String{
    val preferences= activity.getSharedPreferences(activity.getString(R.string.app_name), Context.MODE_PRIVATE)
    Log.e("MYLOG","------>Fetched - ${preferences.getString(Constants.LOCATION_KEY,"Dallas")}")
    return preferences.getString(Constants.LOCATION_KEY,"Dallas").toString()
}

fun saveSharedPreference(activity:Activity,value:String){
    Log.e("MYLOG","------>Saved - $value")

    val sharedPref = activity.getSharedPreferences(activity.getString(R.string.app_name), Context.MODE_PRIVATE)
        ?: return
    with (sharedPref.edit()) {
        putString(Constants.LOCATION_KEY,value )
        apply()
    }
}



fun formatDate(timestamp: Int): String {
    val sdf = SimpleDateFormat("EEE, MMM d")
    val date = java.util.Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDateTime(timestamp: Int): String {
    val sdf = SimpleDateFormat("hh:mm:aa")
    val date = java.util.Date(timestamp.toLong() * 1000)

    return sdf.format(date)
}

fun formatDecimals(item: Double): String {
    return " %.0f".format(item)
}