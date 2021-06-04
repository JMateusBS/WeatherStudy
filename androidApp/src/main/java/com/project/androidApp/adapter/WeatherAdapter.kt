package com.project.androidApp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.androidApp.R
import com.project.androidApp.databinding.WeatherRowLayoutBinding
import com.project.shared.network.WeatherApi
import com.project.shared.util.kelvinToCelsius
import com.project.shared.util.toDate
import com.squareup.picasso.Picasso
import com.project.shared.network.model.Daily

class WeatherAdapter(val weather: List<Daily>) : RecyclerView.Adapter<WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_row_layout, parent, false)

        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

        holder.bind(weather[position])

    }

    override fun getItemCount(): Int {
        return weather.size
    }
}

    class WeatherViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = WeatherRowLayoutBinding.bind(item)

        fun bind(weather: Daily) {

            binding.prevDate.text = weather.dt.toDate()
            binding.prevMaxTemperature.text = "MAX: ${weather.temp.max.kelvinToCelsius()}°C"
            binding.prevMinTemperature.text = "MIN: ${weather.temp.min.kelvinToCelsius()}°C"
//            binding.prevDescription.text = weather.weather[0].description
            binding.prevMain.text = weather.weather[0].main
            Picasso.get().load(WeatherApi.getIconEndPoint(weather.weather[0].icon))
                .into(binding.prevWeatherIcon)
        }
    }
