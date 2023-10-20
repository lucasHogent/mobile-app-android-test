package com.project.beertracker

import android.app.Application
import com.project.beertracker.util.ConnectionStateMonitor
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BeerTrackerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // Connection is monitored to start syncing when online
        val connectionStateMonitor = ConnectionStateMonitor()
        connectionStateMonitor.enable(this)


    }
}