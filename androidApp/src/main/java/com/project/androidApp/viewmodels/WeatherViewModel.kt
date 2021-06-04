package com.project.androidApp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.shared.viewmodel.CurrentTemperature
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application): AndroidViewModel(application) {

    val baseVM = CurrentTemperature()

    @ExperimentalCoroutinesApi
    fun getWeather(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            baseVM.getWeatherData(lat, lon)
        }
    }
}