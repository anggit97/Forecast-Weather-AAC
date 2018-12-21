package com.anggitprayogo.forcastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.anggitprayogo.forcastmvvm.data.db.unitlocalized.UnitSpesificCurrentWeatherEntry

interface ForecastRepository {

    suspend fun getCurrentWeather(metric: Boolean) : LiveData<out UnitSpesificCurrentWeatherEntry>
}