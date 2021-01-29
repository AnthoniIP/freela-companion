package com.ipsoft.freelacompanion.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.ListFragment
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.data.model.Project

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       23/01/2021
 */
class ProjectListFragment : ListFragment(), ProjectListView, AdapterView.OnItemSelectedListener {

	private lateinit var spinner: Spinner

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_project_list, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		spinner = view.findViewById(R.id.spinner)
		spinner.onItemSelectedListener = this

		ArrayAdapter.createFromResource(
			view.context,
			R.array.status,
			android.R.layout.simple_spinner_item
		).also { adapter ->
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
			spinner.adapter = adapter
		}
	}

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

	override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
		when (position) {
			0 -> {
			} // Lógica para exibir todos os projetos
			1 -> {
			} // Lógica para exibir os projetos em andamento
			2 -> {
			} // Lógica para exibir os projetos Concluídos
			3 -> {
			} // Lógica para exibir os projetos Cancelados

			else -> {
				Toast.makeText(activity?.applicationContext, "Position error", Toast.LENGTH_SHORT)
					.show()
			}
		}
	}

	override fun onNothingSelected(parent: AdapterView<*>?) {
		Toast.makeText(activity?.applicationContext, "Nenhum item selecionado", Toast.LENGTH_SHORT)
			.show()
	}
}
