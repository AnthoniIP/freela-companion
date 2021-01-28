package com.ipsoft.freelacompanion.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.data.model.Project

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       23/01/2021
 */
class ProjectListFragment : ListFragment(), ProjectListView {

	override fun showProjects(projects: List<Project>) {
		TODO("Not yet implemented")
	}
	override fun showProjectDetails(project: Project) {
		TODO("Not yet implemented")
	}
	override fun showDeleteMode() {
		TODO("Not yet implemented")
	}
	override fun hideDeleteMode() {
		TODO("Not yet implemented")
	}
	override fun showSelectedProjects(projects: List<Project>) {
		TODO("Not yet implemented")
	}
	override fun updateSelectionCountText(count: Int) {
		TODO("Not yet implemented")
	}
	override fun showMessageProjectsDeleted(count: Int) {
		TODO("Not yet implemented")
	}
}
