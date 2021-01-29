package com.ipsoft.freelacompanion.ui.common

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ipsoft.freelacompanion.R

class MainActivity : FragmentActivity() {

	private lateinit var viewPager: ViewPager2
	private lateinit var addButton: FloatingActionButton

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		viewPager = findViewById(R.id.pager)

		val pagerAdapter = FragmentSliderAdapter(this)
		viewPager.adapter = pagerAdapter


		addButton = findViewById(R.id.btn_add)
	}

	override fun onBackPressed() {

		if (viewPager.currentItem == 0) {

			super.onBackPressed()

		} else {
			viewPager.currentItem = viewPager.currentItem - 1
		}
	}
}