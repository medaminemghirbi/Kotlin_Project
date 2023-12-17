package com.example.kotlin_formation.ui.video

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_formation.R
import com.example.kotlin_formation.databinding.FragmentVideoBinding
import com.example.kotlin_formation.ui.home.HomeViewModel

class VideoFragment : Fragment() {
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = VideoFragment()
    }

    private lateinit var viewModel: VideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val videoViewModel = ViewModelProvider(this).get(VideoViewModel::class.java)

        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val videoPath = "android.resource://${requireContext().packageName}/${R.raw.kotlin}"

        binding.videoView.setVideoPath(videoPath)
        binding.videoView.start()
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}