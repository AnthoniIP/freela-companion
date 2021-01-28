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
        Project(
            1,
            "projeto do jooj",
            "PROJETO DO JOOJ PRA ENTREGAR NA TERCA",
            "10/12/2021",
            "Rogerinho",
            2000.0,
            ProjectStatus.STARTED,
            8,
            30
        ),
        Project(
            2,
            "projeto do jooj",
            "PROJETO DO JOOJ PRA ENTREGAR NA TERCA",
            "10/12/2021",
            "Rogerinho",
            2000.0,
            ProjectStatus.STARTED,
            8,
            30
        ),
        Project(
            3,
            "projeto do jooj",
            "PROJETO DO JOOJ PRA ENTREGAR NA TERCA",
            "10/12/2021",
            "Rogerinho",
            2000.0,
            ProjectStatus.STARTED,
            8,
            30
        ),
        Project(
            4,
            "projeto do jooj",
            "PROJETO DO JOOJ PRA ENTREGAR NA TERCA",
            "10/12/2021",
            "Rogerinho",
            2000.0,
            ProjectStatus.STARTED,
            8,
            30
        )


    )
}