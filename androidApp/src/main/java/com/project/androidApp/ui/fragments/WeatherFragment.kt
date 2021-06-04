package com.project.androidApp.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.*
import com.project.androidApp.databinding.FragmentWeatherBinding
import com.project.androidApp.viewmodels.WeatherViewModel
import com.project.shared.network.WeatherApi
import com.project.shared.util.kelvinToCelsius
import com.project.shared.util.toDate
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch



class WeatherFragment : Fragment() {

    private lateinit var viewModel: WeatherViewModel
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var job: Job? = null

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWeatherBinding.inflate(inflater)

        binding.city.visibility = View.GONE
        binding.description.visibility = View.GONE
//        binding.date.visibility = View.GONE
//        binding.tvFeels.visibility = View.GONE
        binding.humidity.visibility = View.GONE
        binding.clCard.visibility = View.GONE
//        binding.pbLoad.visibility = View.VISIBLE

        viewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
                .create(WeatherViewModel::class.java)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())

        val locationRequest = LocationRequest.create().apply {
            interval = 100
            fastestInterval = 50
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            maxWaitTime = 100
        }

        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {

                try {
                    viewModel.getWeather(p0.lastLocation.latitude, p0.lastLocation.longitude)
                } catch (err: Exception) {
                    Log.d("clima", "${err.message}")
                }

                super.onLocationResult(p0)
            }
        }
        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )

        return binding.root
    }

    override fun onStart() {
        job = lifecycleScope.launch {
            viewModel.baseVM.weather.collect { data ->
                data?.let {

                    binding.temperature.text = "${it.main.temp.kelvinToCelsius()}°C"
                    binding.city.text = it.name
                    binding.description.text = it.weather[0].description
//                    binding.date.text = it.dt.toDate()
//                   binding.tvFeels.text = "Feels Like: ${it.main.feelsLike.kelvinToCelsius()}°C"
                    binding.humidity.text = "${it.main.humidity}%"
//                    binding.maxTemperature.text = "MAX: ${it.main.tempMax.kelvinToCelsius()}°C"
//                    binding.minTemperature.text = "MIN: ${it.main.tempMin.kelvinToCelsius()}°C"

                    Picasso.get().load(WeatherApi.getIconEndPoint(it.weather[0].icon))
                        .into(binding.weatherIcon)

                    binding.city.visibility = View.VISIBLE
//                    binding.date.visibility = View.VISIBLE
//                    binding.tvFeels.visibility = View.VISIBLE
                    binding.humidity.visibility = View.VISIBLE
                    binding.clCard.visibility = View.VISIBLE
                    binding.description.visibility = View.VISIBLE
//                    binding.pbLoad.visibility = View.GONE

                }
            }
        }
        super.onStart()
    }

    override fun onPause() {
        job?.cancel()
        super.onPause()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    }
