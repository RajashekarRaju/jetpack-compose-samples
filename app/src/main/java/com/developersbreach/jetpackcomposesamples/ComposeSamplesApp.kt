package com.developersbreach.jetpackcomposesamples

import android.app.Application
import com.developersbreach.jetpackcomposesamples.data.AppRepository
import timber.log.Timber

class ComposeSamplesApp : Application() {

    lateinit var repository: AppRepository

    override fun onCreate() {
        super.onCreate()

        repository = AppRepository()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}