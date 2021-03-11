package com.ipsoft.data_room.room

import androidx.room.TypeConverter
import com.ipsoft.freelacompanion.data.entity.ProjectStatus
import java.util.*

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

    @TypeConverter
    fun dateToString(date: Date): String {
        return date.toString()
    }
    @TypeConverter
    fun stringToDate(string: String) : Date {
        return Date(string)
    }
}