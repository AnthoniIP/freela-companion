package com.ipsoft.freelacompanion.repository

import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.data.entity.ProjectStatus

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
interface ProjectRepository {

    suspend fun insertProject(project: ProjectEntity) : Long
	suspend fun updateProject(project: ProjectEntity)
	suspend fun deleteProject(id: Long)
	suspend fun projectById(id: Long): ProjectEntity
	suspend fun projectsByStatus(status: ProjectStatus)
	suspend fun getAllProjects(): List<ProjectEntity>
}