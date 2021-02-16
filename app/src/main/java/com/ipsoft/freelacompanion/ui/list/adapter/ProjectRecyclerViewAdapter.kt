package com.ipsoft.freelacompanion.ui.list.adapter

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

class ProjectRecyclerViewAdapter(
    val projects: List<ProjectEntity>,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<ProjectRecyclerViewAdapter.ViewHolder>() {

    private lateinit var projectRecyclerBinding: ProjectItemBinding

    interface OnItemClickListener {

        fun onItemClicked()
    }

    interface OnItemLongClickListener {

        fun onItemLongClicked(position: Int): Boolean
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        projectRecyclerBinding =
            ProjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val rootView = projectRecyclerBinding.root


        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val project = projects[position]
        val statusName = when (project.status) {
            ProjectStatus.STARTED -> "Iniciado"
            ProjectStatus.PAUSED -> "Pausado"
            ProjectStatus.CANCELED -> "Cancelado"
            ProjectStatus.FINISHED -> "Finalizado"

        }

        holder.clientName.text = project.client
        holder.status.text = statusName
        holder.deadLine.text = project.deadLine.toString()
        holder.projectName.text = project.name

        holder.root.setOnClickListener {
            cellClickListener.onCellClickListener(project)
        }

    }

    override fun getItemCount() = projects.count()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val root: View = projectRecyclerBinding.itemLayout
        val projectName: TextView = projectRecyclerBinding.txtProjectName
        val clientName: TextView = projectRecyclerBinding.txtProjectName
        val deadLine: TextView = projectRecyclerBinding.txtDeadLine
        val status: TextView = projectRecyclerBinding.txtStatus

    }

}