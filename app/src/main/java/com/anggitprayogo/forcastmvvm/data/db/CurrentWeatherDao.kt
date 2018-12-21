package com.anggitprayogo.forcastmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anggitprayogo.forcastmvvm.data.db.entity.CURRENT_WEATHER_ID
import com.anggitprayogo.forcastmvvm.data.db.entity.CurrentWeatherEntry
import com.anggitprayogo.forcastmvvm.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.anggitprayogo.forcastmvvm.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(currentWeatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getCurrentWeatherMetric() : LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getCurrentWeatherImperial() : LiveData<ImperialCurrentWeatherEntry>

}