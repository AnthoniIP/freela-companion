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
import com.ipsoft.freelacompanion.R

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       23/01/2021
 */
class ProjectListFragment : Fragment(), AdapterView.OnItemSelectedListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spinner: Spinner = view.findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            view.context,
            R.array.status,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
        }
    }

    companion object {
        fun newInstance(s: String): ProjectListFragment = ProjectListFragment().apply {
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //Logíca que sera executada quando algum item do spinner for selecionado
        Toast.makeText(view?.context, "Item selecionado", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //Logica quando nenhum item do spinner estiver selecionado
        //mostrar todos os projetos
        Toast.makeText(view?.context, "Nenhum item selecionado", Toast.LENGTH_SHORT).show()
    }
}
