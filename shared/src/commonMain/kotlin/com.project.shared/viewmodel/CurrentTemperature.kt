package com.project.shared.viewmodel

import com.project.shared.network.WeatherApi
import com.project.shared.network.model.WeatherResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow

class CurrentTemperature{

    private val api = WeatherApi()
    @ExperimentalCoroutinesApi
    private val _weather =  MutableStateFlow<WeatherResponse?>(null)
    @ExperimentalCoroutinesApi
    val weather get() = _weather


    @ExperimentalCoroutinesApi
    suspend fun getWeatherData(latitude: Double, longitude: Double){

        val data = api.getCurrentWeather(latitude, longitude)
        _weather.value = data
    }

}