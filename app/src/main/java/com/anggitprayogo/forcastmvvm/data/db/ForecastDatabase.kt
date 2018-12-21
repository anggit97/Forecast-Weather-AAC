package com.anggitprayogo.forcastmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.anggitprayogo.forcastmvvm.data.db.entity.CurrentWeatherEntry

@Database(
    entities = [CurrentWeatherEntry::class],
    version = 1
)
abstract class ForecastDatabase: RoomDatabase() {

    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile private var instances: ForecastDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instances ?: synchronized(LOCK){
            instances ?: buildDatabase(context).also{ instances = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            ForecastDatabase::class.java, "forecast.db").build()
    }
}