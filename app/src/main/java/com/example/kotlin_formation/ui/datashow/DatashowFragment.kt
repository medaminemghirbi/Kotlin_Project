package com.example.kotlin_formation.ui.datashow

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_formation.R

class DatashowFragment : Fragment() {

    companion object {
        fun newInstance() = DatashowFragment()
    }

    private lateinit var viewModel: DatashowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_datashow, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DatashowViewModel::class.java)
        // TODO: Use the ViewModel
    }

}