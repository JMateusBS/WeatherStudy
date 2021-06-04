package com.project.androidApp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.shared.viewmodel.ForecastTemperature
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

class ForecastViewModel(application: Application) : AndroidViewModel(application) {

    val baseVM = ForecastTemperature()

    @ExperimentalCoroutinesApi
    fun getWeather(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            baseVM.getWeatherData(lat, lon)
        }
    }
}