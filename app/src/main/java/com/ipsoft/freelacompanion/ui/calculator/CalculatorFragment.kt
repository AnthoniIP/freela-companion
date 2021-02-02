package com.ipsoft.freelacompanion.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ipsoft.freelacompanion.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment(), CalculatorView {

    private lateinit var calculatorBinding: FragmentCalculatorBinding

    override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
        // Inflate the layout for this fragment
        calculatorBinding = FragmentCalculatorBinding.inflate(layoutInflater)
		return calculatorBinding.root
    }
}