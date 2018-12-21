package com.anggitprayogo.forcastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.anggitprayogo.forcastmvvm.data.repository.ForecastRepository
import com.anggitprayogo.forcastmvvm.internal.UnitSystem
import com.anggitprayogo.forcastmvvm.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    private val unitSystem = UnitSystem.METRIC

    val isMetric : Boolean
    get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }

}
