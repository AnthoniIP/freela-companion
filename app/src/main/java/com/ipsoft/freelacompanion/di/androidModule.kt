package com.ipsoft.freelacompanion.di

import com.ipsoft.freelacompanion.repository.ProjectRepository
import com.ipsoft.freelacompanion.repository.sqlite.SQLiteRepository
import com.ipsoft.freelacompanion.ui.calculator.CalculatorPresenter
import com.ipsoft.freelacompanion.ui.calculator.CalculatorView
import com.ipsoft.freelacompanion.ui.common.MainPresenter
import com.ipsoft.freelacompanion.ui.common.MainView
import com.ipsoft.freelacompanion.ui.details.ProjectDetailsPresenter
import com.ipsoft.freelacompanion.ui.details.ProjectDetailsView
import com.ipsoft.freelacompanion.ui.form.ProjectFormPresenter
import com.ipsoft.freelacompanion.ui.form.ProjectFormView
import com.ipsoft.freelacompanion.ui.list.ProjectListPresenter
import com.ipsoft.freelacompanion.ui.list.ProjectListView
import org.koin.dsl.module.module

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
val androidModule = module {
	single { this }
	single {
		//informa que o cast é desnecessario porém não compila sem ele.
		@Suppress("USELESS_CAST")
		SQLiteRepository(ctx = get()) as ProjectRepository
	}

	//Presenters
	factory { (view: CalculatorView) ->
		CalculatorPresenter(view)
	}

	factory { (view: MainView) ->
		MainPresenter(
			view, repository = get()
		)
	}
	factory { (view: ProjectDetailsView) ->
		ProjectDetailsPresenter(view, repository = get())

	}
	factory { (view: ProjectFormView) ->
		ProjectFormPresenter(view, repository = get())
	}

	factory { (view: ProjectListView) ->
		ProjectListPresenter(view, repository = get())
	}

}