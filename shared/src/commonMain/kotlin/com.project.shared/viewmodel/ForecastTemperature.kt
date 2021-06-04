package com.project.shared.viewmodel

import com.project.shared.network.WeatherApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import com.project.shared.network.model.WeatherPrevisionResponse

class ForecastTemperature {

    private val api = WeatherApi()
    @ExperimentalCoroutinesApi
    private val _weather =  MutableStateFlow<WeatherPrevisionResponse?>(null)
    @ExperimentalCoroutinesApi
    val weather get() = _weather


    @ExperimentalCoroutinesApi
    suspend fun getWeatherData(latitude: Double, longitude: Double){

        val data = api.getWeatherPrevision(latitude, longitude)
        _weather.value = data
    }
}