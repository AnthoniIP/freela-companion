package com.ipsoft.freelacompanion.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ipsoft.freelacompanion.repository.TABLE_NAME
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       26/01/2021
 */
@Parcelize
@Entity(tableName = TABLE_NAME)
data class ProjectEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val name: String = "",
    val description: String = "",
    val deadLine: Date,
    val client: String = "",
    val price: Double = 0.0,
    val status: ProjectStatus,
    val hourPerDay: Int,
    val dayDuration: Int
) : Parcelable

enum class ProjectStatus {
    STARTED, PAUSED, FINISHED, CANCELED,ERROR
}
