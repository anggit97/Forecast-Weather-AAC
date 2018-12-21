package com.anggitprayogo.forcastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anggitprayogo.forcastmvvm.data.repository.ForecastRepository

class CurrentWeatherViewModelFactory(
    private val forecastResitory: ForecastRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrentWeatherViewModel(forecastResitory) as T
    }
}