package com.ipsoft.freelacompanion.data.model

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       26/01/2021
 */
data class Project(
    var id: Long,
    val name: String = "",
    val description: String = "",
    val deadLine: String,
    val client: String = "",
    val price: Double = 0.0,
    val status: ProjectStatus,
    val hourPerDay: Int,
    val dayDuration: Int
) {

	val valuePerHour
		get() = price / (hourPerDay * dayDuration)
}

enum class ProjectStatus {
	STARTED, PAUSED, FINISHED, CANCELED
}
