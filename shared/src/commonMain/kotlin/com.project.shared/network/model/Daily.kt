package com.project.shared.network.model

import com.project.shared.network.model.Temp
import com.project.shared.network.model.WeatherPrevision
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    val dew_point: Double,
    val dt: Int,
    val humidity: Int,
    val rain: Double = 0.0,
    val temp: Temp,
    val weather: List<WeatherPrevision>,
)