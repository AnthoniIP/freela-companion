package com.ipsoft.freelacompanion.repository.room

import androidx.room.TypeConverter
import com.ipsoft.freelacompanion.data.entity.ProjectStatus

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       16/02/2021
 */

class Converters {

    @TypeConverter
    fun statusToInt(projectStatus: ProjectStatus): Int {
        return when (projectStatus) {
            ProjectStatus.STARTED -> 1
            ProjectStatus.PAUSED -> 2
            ProjectStatus.FINISHED -> 3
            ProjectStatus.CANCELED -> 4
            else -> 0
        }
    }

    @TypeConverter
    fun intToStatus(n: Int): ProjectStatus {
        return when (n) {
            1 -> ProjectStatus.STARTED
            2 -> ProjectStatus.PAUSED
            3 -> ProjectStatus.FINISHED
            4 -> ProjectStatus.CANCELED
            else -> ProjectStatus.ERROR
        }
    }
}