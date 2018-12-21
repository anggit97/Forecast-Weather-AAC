package com.anggitprayogo.forcastmvvm.data.network.response

import com.anggitprayogo.forcastmvvm.data.db.entity.CurrentWeatherEntry
import com.anggitprayogo.forcastmvvm.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    @SerializedName("location")
    val location: Location
)