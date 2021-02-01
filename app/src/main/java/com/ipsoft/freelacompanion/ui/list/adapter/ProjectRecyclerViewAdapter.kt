package com.ipsoft.freelacompanion.ui.list.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ipsoft.freelacompanion.data.model.Project

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       29/01/2021
 */

class ProjectRecyclerViewAdapter(val project: List<Project>) : RecyclerView.Adapter<ProjectRecyclerViewAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClicked()
    }

    interface OnItemLongClickListener {
        fun onItemLongClicked(position: Int): Boolean
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}