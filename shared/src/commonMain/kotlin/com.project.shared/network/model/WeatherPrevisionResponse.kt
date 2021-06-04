package com.project.shared.network.model

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class WeatherPrevisionResponse(
    @Contextual
    val daily: List<@Contextual Daily>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)