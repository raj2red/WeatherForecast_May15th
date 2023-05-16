package com.example.weatherforecase_may15th.data_layer.repository

import android.util.Log
import com.example.weatherforecase_may15th.data.DataOrException
import com.example.weatherforecase_may15th.data_layer.model.WeatherPojo
import com.example.weatherforecase_may15th.domain_layer.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherAPI){

    suspend fun getWeather(city: String, units: String ): DataOrException<WeatherPojo, Boolean, Exception>{

        val response = try {

            api.getWeather(query = city, units = units)


        }catch (e: Exception){
            Log.d("REX", "getWeather: $e")
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "getWeather: $response")

        return  DataOrException(data = response)

    }
}