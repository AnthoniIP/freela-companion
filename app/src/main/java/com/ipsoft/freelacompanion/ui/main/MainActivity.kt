package com.ipsoft.freelacompanion.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.ui.projects.ProjectFragment

class MainActivity : AppCompatActivity() {

    private lateinit var tabs: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var fragment: ProjectFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





    }
}