package com.ipsoft.freelacompanion.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.data.entity.ProjectStatus
import com.ipsoft.freelacompanion.databinding.ProjectItemBinding
import com.ipsoft.freelacompanion.util.CellClickListener

/**
 *
 *  Author:     Anthoni Ipiranga
 *  ProjectEntity:    Freela Companion
 *  Date:       29/01/2021
 */

class ProjectListAdapter(
    val projects: List<ProjectEntity>,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<ProjectListAdapter.ViewHolder>() {

    private lateinit var projectRecyclerBinding: ProjectItemBinding
    var onItemClick: ((entity: ProjectEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        projectRecyclerBinding =
            ProjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val rootView = projectRecyclerBinding.root


        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(project = projects[position])

    }

    override fun getItemCount() = projects.count()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val root: View = projectRecyclerBinding.itemLayout
        private val projectName: TextView = projectRecyclerBinding.txtProjectName
        private val clientName: TextView = projectRecyclerBinding.txtProjectName
        private val deadLine: TextView = projectRecyclerBinding.txtDeadLine
        private val status: TextView = projectRecyclerBinding.txtStatus

        fun bindView(project: ProjectEntity) {
            val statusName = when (project.status) {
                ProjectStatus.STARTED -> "Iniciado"
                ProjectStatus.PAUSED -> "Pausado"
                ProjectStatus.CANCELED -> "Cancelado"
                ProjectStatus.FINISHED -> "Finalizado"

                else -> "Error"
            }
            clientName.text = project.client
            status.text = statusName
            deadLine.text = project.deadLine.toString()
            projectName.text = project.name

            itemView.setOnClickListener {
                onItemClick?.invoke(project)
            }

        }

    }

}