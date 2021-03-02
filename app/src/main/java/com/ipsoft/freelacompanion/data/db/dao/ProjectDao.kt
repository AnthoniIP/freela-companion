package com.ipsoft.freelacompanion.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.data.entity.ProjectStatus
import com.ipsoft.freelacompanion.repository.COLUMN_STATUS
import com.ipsoft.freelacompanion.repository.TABLE_NAME

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       16/02/2021
 */
@Dao
interface ProjectDao {

    @Insert
    suspend fun insert(project: ProjectEntity): Long

    @Update
    suspend fun update(project: ProjectEntity)

    @Query("DELETE FROM $TABLE_NAME WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAll(): List<ProjectEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun getById(id: Long): ProjectEntity

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_STATUS = :status")
    suspend fun getByStatus(status: ProjectStatus): List<ProjectEntity>
}