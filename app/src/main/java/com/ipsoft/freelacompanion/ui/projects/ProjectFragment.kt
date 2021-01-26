package com.ipsoft.freelacompanion.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.ipsoft.freelacompanion.R

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       23/01/2021
 */

class ProjectFragment : Fragment() {


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
        }

    }

    companion object {

        fun newInstance(s: String): ProjectFragment = ProjectFragment().apply {
            arguments = Bundle().apply {
                putString("text", s)
            }
        }
    }
}