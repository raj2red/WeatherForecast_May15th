package com.example.weatherforecase_may15th.presentation_layer.views.MainScreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bawp.jetweatherforecast.data.DataOrException
import com.example.weatherforecase_may15th.data_layer.model.WeatherPojo
import com.example.weatherforecase_may15th.data_layer.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository)
    : ViewModel(){

    suspend fun getWeatherData(city: String, units: String)
            : DataOrException<WeatherPojo, Boolean, Exception> {
        return repository.getWeather(city = city, units = units)

    }

}