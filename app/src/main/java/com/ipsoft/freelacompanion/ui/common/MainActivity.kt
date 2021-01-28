package com.ipsoft.freelacompanion.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.ipsoft.freelacompanion.R
import com.ipsoft.freelacompanion.ui.list.ProjectListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var tabs: TabLayout
    private lateinit var pager: ViewPager2
    private lateinit var listFragment: ProjectListFragment
    private lateinit var addButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addButton = findViewById(R.id.btn_add)
    }
}