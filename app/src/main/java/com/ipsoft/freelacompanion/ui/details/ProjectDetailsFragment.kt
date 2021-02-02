package com.ipsoft.freelacompanion.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.databinding.ActivityProjectDetailBinding

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       28/01/2021
 */
class ProjectDetailsFragment : Fragment(), ProjectDetailsView {

    private lateinit var projectDetailBinding: ActivityProjectDetailBinding

    override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
        projectDetailBinding = ActivityProjectDetailBinding.inflate(layoutInflater)
        return projectDetailBinding.root
    }

    override fun showProjectDetails(project: Project) {
        TODO("Not yet implemented")
    }

    override fun errorProjectNotFound() {
        TODO("Not yet implemented")
    }
}