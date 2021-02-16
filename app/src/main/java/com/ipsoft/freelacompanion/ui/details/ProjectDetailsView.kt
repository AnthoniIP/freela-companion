package com.ipsoft.freelacompanion.ui.details

import com.ipsoft.freelacompanion.data.entity.ProjectEntity

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectDetailsView {

	fun showProjectDetails(project: ProjectEntity)
	fun errorProjectNotFound()

}