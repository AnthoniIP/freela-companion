package com.ipsoft.freelacompanion.ui.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.databinding.FragmentProjectFormBinding

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
class ProjectFormFragment : Fragment(), ProjectFormView {

    lateinit var projectFormBinding: FragmentProjectFormBinding

    override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
        projectFormBinding = FragmentProjectFormBinding.inflate(layoutInflater)
        return projectFormBinding.root
    }

    override fun showProject(project: Project) {
        TODO("Not yet implemented")
    }

    override fun errorInvalidProject() {
        TODO("Not yet implemented")
    }

    override fun errorSaveProject() {
        TODO("Not yet implemented")
    }
}