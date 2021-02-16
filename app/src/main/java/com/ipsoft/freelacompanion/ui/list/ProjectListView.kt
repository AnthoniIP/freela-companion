package com.ipsoft.freelacompanion.ui.list

import com.ipsoft.freelacompanion.data.entity.ProjectEntity

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectListView {

	fun showProjects(projects: List<ProjectEntity>)
	fun showProjectDetails(project: ProjectEntity)
	fun showDeleteMode()
	fun hideDeleteMode()
	fun showSelectedProjects(projects: List<ProjectEntity>)
	fun updateSelectionCountText(count: Int)
	fun showMessageProjectsDeleted(count: Int)
}