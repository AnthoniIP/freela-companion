package com.ipsoft.freelacompanion.ui.list

import com.ipsoft.freelacompanion.data.model.Project

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectListView {

	fun showProjects(projects: List<Project>)
	fun showProjectDetails(project: Project)
	fun showDeleteMode()
	fun hideDeleteMode()
	fun showSelectedProjects(projects: List<Project>)
	fun updateSelectionCountText(count: Int)
	fun showMessageProjectsDeleted(count: Int)
}