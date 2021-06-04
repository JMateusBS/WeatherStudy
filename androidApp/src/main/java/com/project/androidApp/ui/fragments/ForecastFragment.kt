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
import com.project.androidApp.adapter.WeatherAdapter
import com.project.androidApp.databinding.FragmentForecastBinding
import com.project.androidApp.viewmodels.ForecastViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ForecastFragment : Fragment(){

    private lateinit var viewModel: ForecastViewModel
    private var _binding: FragmentForecastBinding? = null
    private val binding get() = _binding!!
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private  var job: Job? = null

    @SuppressLint("MissingPermission")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentForecastBinding.inflate(inflater, container, false)

        binding.recycleForecast.visibility = View.GONE
//        binding.pbPrevLoad.visibility = View.VISIBLE

        viewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
                .create(ForecastViewModel::class.java)

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
        job = lifecycleScope.launch() {
            viewModel.baseVM.weather.collect { data ->

                data?.let {
                    binding.recycleForecast.apply {
                        adapter = WeatherAdapter(it.daily)
                    }
                    binding.recycleForecast.visibility = View.VISIBLE
//                    binding.pbPrevLoad.visibility = View.GONE
                }


            }
        }
        super.onStart()
    }

    override fun onStop() {
        job?.cancel()
        super.onStop()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}