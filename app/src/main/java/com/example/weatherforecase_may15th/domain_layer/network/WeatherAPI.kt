package com.example.weatherforecase_may15th.domain_layer.network

import com.bawp.jetweatherforecast.utils.Constants
import com.example.weatherforecase_may15th.data_layer.model.WeatherPojo
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherAPI {

    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query(value = "q") query: String,
        @Query(value = "units") units: String = "imperial",
        @Query(value = "appid") appid: String = Constants.API_KEY
    ): WeatherPojo


}