package com.ipsoft.freelacompanion.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.repository.ProjectRepository
import kotlinx.coroutines.launch

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       16/02/2021
 */

class ProjectListViewModel(
    private val repository: ProjectRepository
) : ViewModel() {

    private val _allProjectsEvent = MutableLiveData<List<ProjectEntity>>()
    val allProjectsEvent: LiveData<List<ProjectEntity>>
        get() = _allProjectsEvent

    init {
        getAllProjects()
    }

    fun getAllProjects() = viewModelScope.launch {
        _allProjectsEvent.postValue(repository.getAllProjects())
    }
}