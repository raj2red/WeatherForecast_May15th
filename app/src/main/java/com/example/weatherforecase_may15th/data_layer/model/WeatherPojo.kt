package com.example.weatherforecase_may15th.data_layer.model

data class WeatherPojo(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<WeatherList>,
    val message: Double
)