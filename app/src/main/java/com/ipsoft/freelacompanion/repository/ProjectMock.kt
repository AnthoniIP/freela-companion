package com.ipsoft.freelacompanion.repository

import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.data.model.ProjectStatus

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       26/01/2021
 */

class ProjectMock {

    private val projectList: List<Project> = listOf(
        Project("Jooj", "projeto do jooj", "10/12/2021", "Rogerinho", 2000.0, ProjectStatus.STARTED,8,30),
        Project("Jooj 2", "projeto do jooj 2", "10/12/2021", "Marcos", 400.0, ProjectStatus.PAUSED,6,60),
        Project("Jooj 3", "projeto do jooj 3", "10/12/2021", "Tadeu", 3000.0, ProjectStatus.CANCELED,8,30),
        Project("Jooj 4", "projeto do jooj 4", "10/12/2021", "Bastimeu", 800.0, ProjectStatus.FINISHED,4,80),
    )

}