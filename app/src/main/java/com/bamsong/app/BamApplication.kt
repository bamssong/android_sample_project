package com.bamsong.app

import android.app.Application
import timber.log.Timber

class BamApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}