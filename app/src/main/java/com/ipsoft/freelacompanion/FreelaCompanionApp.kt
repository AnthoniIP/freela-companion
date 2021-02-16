package com.ipsoft.freelacompanion

import android.app.Application
import com.ipsoft.freelacompanion.di.androidModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.StandAloneContext.stopKoin

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
class FreelaCompanionApp : Application() {

	override fun onCreate() {
		super.onCreate()
		startKoin(this, listOf(androidModule))
	}

	override fun onTerminate() {
		super.onTerminate()
		stopKoin()
	}
}