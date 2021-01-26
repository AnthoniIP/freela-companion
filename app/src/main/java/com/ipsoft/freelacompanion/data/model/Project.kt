package com.ipsoft.freelacompanion.data.model

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       26/01/2021
 */

data class Project(
    val name: String = "",
    val description: String = "",
    val deadLine: String,
    val client: String = "",
    val value: Double = 0.0,
    val status: ProjectStatus,
    val hourPerDay: Int,
    val dayDuration: Int

) {
    val valuePerHour
        get() = value / (hourPerDay * dayDuration)
}

enum class ProjectStatus {
    STARTED, PAUSED, FINISHED, CANCELED
}
