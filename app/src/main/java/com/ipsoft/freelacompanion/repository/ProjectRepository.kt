package com.ipsoft.freelacompanion.repository

import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.data.model.ProjectStatus

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectRepository {

	fun save(project: Project)
	fun remove(vararg projects: Project)
	fun projectById(id: Long, callback: (Project?) -> Unit)
	fun projectsByStatus(status: ProjectStatus, callback: (List<Project>) -> Unit)
	fun search(term: String, callback: (List<Project>) -> Unit)
}