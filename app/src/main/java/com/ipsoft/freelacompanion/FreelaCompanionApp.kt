package com.ipsoft.freelacompanion

import android.app.Application
import com.ipsoft.freelacompanion.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
class FreelaCompanionApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FreelaCompanionApp)
            modules(androidModule)
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}