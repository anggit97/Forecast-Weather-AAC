package com.anggitprayogo.forcastmvvm

import android.app.Application
import com.anggitprayogo.forcastmvvm.data.db.ForecastDatabase
import com.anggitprayogo.forcastmvvm.data.network.*
import com.anggitprayogo.forcastmvvm.data.repository.ForecastRepository
import com.anggitprayogo.forcastmvvm.data.repository.ForecastRepositoryImpl
import com.anggitprayogo.forcastmvvm.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }

        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao()}

        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }

        bind() from singleton { ApixuWeatherApiService(instance()) }

        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }

        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }

        bind() from provider { CurrentWeatherViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}