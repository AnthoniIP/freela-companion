package com.ipsoft.freelacompanion.ui.form

import com.ipsoft.freelacompanion.data.model.Project

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectFormView {

	fun showProject(project: Project)
	fun errorInvalidProject()
	fun errorSaveProject()

}