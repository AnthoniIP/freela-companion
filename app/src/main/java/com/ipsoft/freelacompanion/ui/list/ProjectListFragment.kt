package com.ipsoft.freelacompanion.ui.list

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.databinding.FragmentProjectListBinding
import com.ipsoft.freelacompanion.ui.list.adapter.ProjectRecyclerViewAdapter
import com.ipsoft.freelacompanion.util.CellClickListener
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       23/01/2021
 */
class ProjectListFragment : Fragment(), ProjectListView, AdapterView.OnItemSelectedListener,
    ActionMode.Callback {

    private var _binding: FragmentProjectListBinding? = null
    private val binding get() = _binding!!


    private lateinit var spinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val presenter: ProjectListPresenter by inject { parametersOf(this) }
    private var actionMode: ActionMode? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        presenter.init()
    }

    override fun showProjects(projects: List<Project>) {
        val adapter = ProjectRecyclerViewAdapter(projects, activity as CellClickListener)
        linearLayoutManager = LinearLayoutManager(activity)
        recyclerView = binding.rvProjects
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    override fun showProjectDetails(project: Project) {
        if (activity is OnProjectClickListener) {
            val listener = activity as OnProjectClickListener
            listener.onProjectClick(project)

        }
    }

    fun search(text: String) {
        presenter.searchProjects(text)

    }

    fun clearSearch() {
        presenter.searchProjects("")
    }

    override fun showDeleteMode() {
        //TODO
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProjectListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner(view)

    }

    private fun setSpinner(v: View) {

        spinner = binding.spinner
        spinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            v.context,
            R.array.status,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

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

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        TODO("Not yet implemented")
    }

    interface OnProjectDeletedListener {

        fun onProjectDeleted(projects: List<Project>)
    }

    interface OnProjectClickListener {

        fun onProjectClick(project: Project)
    }

}
