package com.ipsoft.freelacompanion.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.databinding.ActivityProjectDetailBinding

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
class ProjectDetailsFragment : Fragment(), ProjectDetailsView {

    private var _binding: ActivityProjectDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityProjectDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun showProjectDetails(project: ProjectEntity) {
        TODO("Not yet implemented")
    }

    override fun errorProjectNotFound() {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}