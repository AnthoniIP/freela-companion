package com.ipsoft.freelacompanion.ui.list

import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.repository.ProjectRepository

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
class ProjectListPresenter(
    private val view: ProjectListView,
    private val repository: ProjectRepository
) {

    private var lastTerm = ""
    private var inDeleteMode = false
    private val selectedItems = mutableListOf<Project>()
    private val deletedItems = mutableListOf<Project>()

    fun init() {
        if (inDeleteMode) {
            showDeleteMode()
            view.updateSelectionCountText(selectedItems.size)
            view.showSelectedProjects(selectedItems)
        } else {
            refresh()
        }

    }

    fun searchProjects(term: String) {
        lastTerm = term
        repository.search(term) { projects ->
            view.showProjects(projects)
        }
    }

    fun selectProject(project: Project) {
        if (inDeleteMode) {
            toggleProjectSelected(project)
            if (selectedItems.size == 0) {
                view.hideDeleteMode()
            } else {
                view.updateSelectionCountText(selectedItems.size)
                view.showSelectedProjects(selectedItems)
            }
        } else {
            view.showProjectDetails(project)
        }
    }

    fun toggleProjectSelected(project: Project) {
        val existing = selectedItems.find { it.id == project.id }
        if (existing == null) {
            selectedItems.add(project)
        } else {
            selectedItems.removeAll { it.id == project.id }
        }
    }

    fun showDeleteMode() {
        inDeleteMode = true
        view.showDeleteMode()

    }

    fun hideDeleteMode() {
        inDeleteMode = false
        selectedItems.clear()
        view.hideDeleteMode()
    }

    fun refresh() {
        searchProjects(lastTerm)
    }

    fun deleteSelected(callback: (List<Project>) -> Unit) {
        repository.remove(*selectedItems.toTypedArray())
        deletedItems.clear()
        deletedItems.addAll(selectedItems)
        refresh()
        callback(deletedItems)
        hideDeleteMode()
        view.showMessageProjectsDeleted(deletedItems.size)
    }

    fun undoDelete() {
        if (deletedItems.isNotEmpty()) {
            for (project in deletedItems) {
                repository.save(project)
            }
            searchProjects(lastTerm)
        }
    }

}