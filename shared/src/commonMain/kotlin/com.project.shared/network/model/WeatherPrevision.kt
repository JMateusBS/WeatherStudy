package com.project.shared.network.model

import kotlinx.serialization.Serializable

@Serializable
data class WeatherPrevision(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)