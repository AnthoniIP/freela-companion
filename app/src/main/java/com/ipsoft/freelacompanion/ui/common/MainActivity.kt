package com.ipsoft.freelacompanion.ui.common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.data.entity.ProjectEntity
import com.ipsoft.freelacompanion.databinding.ActivityMainBinding
import com.ipsoft.freelacompanion.ui.common.adapter.FragmentSliderAdapter
import com.ipsoft.freelacompanion.ui.details.ProjectDetailActivity
import com.ipsoft.freelacompanion.ui.list.ProjectListFragment

class MainActivity : AppCompatActivity(),
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
        addButton.setOnClickListener {

            val intent = Intent(this, ProjectDetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {

        if (viewPager.currentItem == 0) {

            super.onBackPressed()

        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private fun setFragments() {
        viewPager = mainBinding.pager

        val pagerAdapter = FragmentSliderAdapter(this)
        viewPager.adapter = pagerAdapter
    }

    private fun setTabLayout() {

        val tabTitles = (resources.getStringArray(R.array.fragments))
        tabLayout = mainBinding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    override fun onProjectDeleted(projects: List<ProjectEntity>) {
        TODO("Not yet implemented")
    }


}