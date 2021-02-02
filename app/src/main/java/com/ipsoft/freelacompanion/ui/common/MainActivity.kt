package com.ipsoft.freelacompanion.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.data.model.Project
import com.ipsoft.freelacompanion.databinding.ActivityMainBinding
import com.ipsoft.freelacompanion.ui.common.adapter.FragmentSliderAdapter
import com.ipsoft.freelacompanion.ui.list.ProjectListFragment

class MainActivity : AppCompatActivity(),
    MainView,
    ProjectListFragment.OnProjectClickListener,
    ProjectListFragment.OnProjectDeletedListener {

    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var viewPager: ViewPager2
    private lateinit var addButton: FloatingActionButton
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        setFragments()
        setTabLayout()

        addButton = mainBinding.btnAdd
    }

    override fun onBackPressed() {

        if (viewPager.currentItem == 0) {

            super.onBackPressed()

        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    override fun setFragments() {
        viewPager = mainBinding.pager

        val pagerAdapter = FragmentSliderAdapter(this)
        viewPager.adapter = pagerAdapter
    }

    override fun setTabLayout() {

        val tabTitles = (resources.getStringArray(R.array.fragments))
        tabLayout = mainBinding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    override fun onProjectDeleted(projects: List<Project>) {
        TODO("Not yet implemented")
    }

    override fun onProjectClick(project: Project) {
        TODO("Not yet implemented")
    }
}