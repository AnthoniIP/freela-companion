package com.ipsoft.freelacompanion.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ipsoft.freelacompanion.databinding.ActivityProjectDetailBinding

class ProjectDetailActivity : AppCompatActivity() {

    private lateinit var projectDetailBinding: ActivityProjectDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        projectDetailBinding = ActivityProjectDetailBinding.inflate(layoutInflater)
        val view = projectDetailBinding.root
        setContentView(view)
    }
}