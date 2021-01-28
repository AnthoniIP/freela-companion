package com.ipsoft.freelacompanion.ui.details

import com.ipsoft.freelacompanion.data.model.Project

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectDetailsView {

	fun showProjectDetails(project: Project)
	fun errorProjectNotFound()

}