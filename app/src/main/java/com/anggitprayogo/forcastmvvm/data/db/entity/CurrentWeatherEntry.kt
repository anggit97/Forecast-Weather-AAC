package com.anggitprayogo.forcastmvvm.data.db.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    @SerializedName("cloud")
    val cloud: Int, // 25
    @Embedded(prefix = "condition_")
    @SerializedName("condition")
    val condition: Condition,
    @SerializedName("feelslike_c")
    val feelslikeC: Double, // 31.6
    @SerializedName("feelslike_f")
    val feelslikeF: Double, // 88.9
    @SerializedName("humidity")
    val humidity: Int, // 62
    @SerializedName("is_day")
    val isDay: Int, // 1
    @SerializedName("last_updated")
    val lastUpdated: String, // 2018-12-20 20:00
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int, // 1545310829
    @SerializedName("precip_in")
    val precipIn: Int, // 0
    @SerializedName("precip_mm")
    val precipMm: Int, // 0
    @SerializedName("pressure_in")
    val pressureIn: Double, // 30.3
    @SerializedName("pressure_mb")
    val pressureMb: Int, // 1009
    @SerializedName("temp_c")
    val tempC: Int, // 29
    @SerializedName("temp_f")
    val tempF: Double, // 84.2
    @SerializedName("uv")
    val uv: Int, // 7
    @SerializedName("vis_km")
    val visKm: Int, // 6
    @SerializedName("vis_miles")
    val visMiles: Int, // 3
    @SerializedName("wind_degree")
    val windDegree: Int, // 260
    @SerializedName("wind_dir")
    val windDir: String, // W
    @SerializedName("wind_kph")
    val windKph: Double, // 6.8
    @SerializedName("wind_mph")
    val windMph: Double // 4.3
){
    @PrimaryKey(autoGenerate = false)
    var id: Int = CURRENT_WEATHER_ID
}