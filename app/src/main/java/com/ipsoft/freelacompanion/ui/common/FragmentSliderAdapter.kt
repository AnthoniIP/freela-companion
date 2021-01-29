package com.ipsoft.freelacompanion.ui.common

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ipsoft.freelacompanion.ui.list.ProjectListFragment

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Freela Companion
 *  Date:       29/01/2021
 */
class FragmentSliderAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

	override fun getItemCount() = NUM_PAGES

	override fun createFragment(position: Int) = ProjectListFragment()

	companion object {

		private const val NUM_PAGES = 2
	}

}
