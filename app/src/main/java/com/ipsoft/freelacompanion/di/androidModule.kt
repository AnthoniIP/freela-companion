package com.ipsoft.freelacompanion.di

import com.ipsoft.freelacompanion.repository.ProjectRepository
import com.ipsoft.freelacompanion.repository.sqlite.SQLiteRepository
import org.koin.dsl.module.module

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
val androidModule = module {
	single { this }
	single { SQLiteRepository(ctx = get()) as ProjectRepository }

}