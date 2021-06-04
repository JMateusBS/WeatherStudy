package com.project.shared.network

import com.project.shared.network.model.WeatherPrevisionResponse
import com.project.shared.network.model.WeatherResponse
import com.project.shared.util.Constants
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.ContentType.Application.Json
import kotlinx.serialization.json.Json


class WeatherApi {

    private val httpClient = HttpClient {
        install(JsonFeature){

            val json = Json {
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)

        }
    }

    suspend fun getCurrentWeather(lat: Double, lon: Double): WeatherResponse {

        return httpClient.get(getWeatherNowEndPoint(lat, lon))
    }

    suspend fun getWeatherPrevision(lat: Double, lon: Double): WeatherPrevisionResponse{

        return httpClient.get(getPrevisionEndPoint(lat, lon))
    }

    companion object{

        private fun getWeatherNowEndPoint(lat: Double, lon: Double) =
            "https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${Constants.APY_KEY}"
        private fun getPrevisionEndPoint(lat: Double, lon: Double)= "https://api.openweathermap.org/data/2.5/onecall?lat=${lat}&lon=${lon}&exclude=current,minutely,hourly,alerts&appid=${Constants.APY_KEY}"
        fun getIconEndPoint(icon: String) = "https://openweathermap.org/img/wn/${icon}@2x.png"
    }
}