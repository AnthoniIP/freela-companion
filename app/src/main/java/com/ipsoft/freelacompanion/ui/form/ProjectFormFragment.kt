package com.ipsoft.freelacompanion.ui.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.databinding.FragmentProjectFormBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       28/01/2021
 */
class ProjectFormFragment : DialogFragment(), ProjectFormView {

    private var _binding: FragmentProjectFormBinding? = null
    private val binding get() = _binding!!

    private val presenter: ProjectFormPresenter by inject { parametersOf(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectFormBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun showProject(project: ProjectEntity) {
        TODO("Not yet implemented")
    }

    override fun errorInvalidProject() {
        TODO("Not yet implemented")
    }

    override fun errorSaveProject() {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}