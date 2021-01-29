package com.ipsoft.freelacompanion.ui.common

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ipsoft.freelacompanion.R

class MainActivity : FragmentActivity(), MainView {

	private lateinit var viewPager: ViewPager2
	private lateinit var addButton: FloatingActionButton
	private lateinit var tabLayout: TabLayout

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		setFragments()
		setTabLayout()

		addButton = findViewById(R.id.btn_add)
	}

	override fun onBackPressed() {

		if (viewPager.currentItem == 0) {

			super.onBackPressed()

		} else {
			viewPager.currentItem = viewPager.currentItem - 1
		}
	}

	override fun setFragments() {
		viewPager = findViewById(R.id.pager)

		val pagerAdapter = FragmentSliderAdapter(this)
		viewPager.adapter = pagerAdapter
	}

	override fun setTabLayout() {

		val tabTitles = (resources.getStringArray(R.array.fragments))
		tabLayout = findViewById(R.id.tab_layout)
		TabLayoutMediator(tabLayout, viewPager) { tab, position ->
			tab.text = tabTitles[position]
		}.attach()
	}
}