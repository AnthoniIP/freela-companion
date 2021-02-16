package com.ipsoft.freelacompanion.repository.room

import com.ipsoft.freelacompanion.data.db.dao.ProjectDao
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.data.entity.ProjectStatus
import com.ipsoft.freelacompanion.repository.ProjectRepository

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       16/02/2021
 */

class DatabaseDatasource(
    private val projectDao: ProjectDao
) : ProjectRepository {

    override suspend fun insertProject(project: ProjectEntity): Long {
        return projectDao.insert(project)
    }

    override suspend fun updateProject(project: ProjectEntity) {
        projectDao.update(project)
    }

    override suspend fun deleteProject(id: Long) {
        projectDao.delete(id)
    }

    override suspend fun projectById(id: Long): ProjectEntity {
        TODO("Not yet implemented")
    }

    override suspend fun projectsByStatus(status: ProjectStatus) {
        projectDao.getByStatus(status)
    }

    override suspend fun getAllProjects(): List<ProjectEntity> {
        return projectDao.getAll()
    }

}