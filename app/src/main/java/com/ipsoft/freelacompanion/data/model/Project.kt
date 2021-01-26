package com.ipsoft.freelacompanion.data.model

import java.util.*

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       26/01/2021
 */

data class Project(
    val name : String = "",
    val description: String = "",
    val deadLine : Date,
    val client : String = "",
    val value : Double = 0.0,
    val status : ProjectStatus

)
enum class ProjectStatus {
    STARTED,PAUSED,FINISHED,CANCELED
}
