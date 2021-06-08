package com.ipsoft.freelacompanion.ui.list

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.databinding.FragmentProjectListBinding


/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       23/01/2021
 */
class ProjectListFragment : Fragment() {

    private var _binding: FragmentProjectListBinding? = null
    private val binding get() = _binding!!


    private lateinit var spinner: Spinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
    }





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProjectListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSpinner(view)

        configureViewListeners()

    }



    private fun configureViewListeners() {
        TODO("Not yet implemented")
    }

    private fun setSpinner(v: View) {

        spinner = binding.spinner

        ArrayAdapter.createFromResource(
            v.context,
            R.array.status,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

    }

    fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
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

    fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(activity?.applicationContext, "Nenhum item selecionado", Toast.LENGTH_SHORT)
            .show()
    }


}
