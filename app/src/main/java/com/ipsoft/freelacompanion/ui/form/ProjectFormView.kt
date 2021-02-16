package com.ipsoft.freelacompanion.ui.form

import com.ipsoft.freelacompanion.data.entity.ProjectEntity

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectFormView {

	fun showProject(project: ProjectEntity)
	fun errorInvalidProject()
	fun errorSaveProject()

}