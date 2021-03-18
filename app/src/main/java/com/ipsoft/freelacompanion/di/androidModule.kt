package com.ipsoft.freelacompanion.di

import com.ipsoft.freelacompanion.ui.list.ProjectListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
val appModule = module  {
    single {

    }
    viewModel {
        ProjectListViewModel(repository = get())
    }
}