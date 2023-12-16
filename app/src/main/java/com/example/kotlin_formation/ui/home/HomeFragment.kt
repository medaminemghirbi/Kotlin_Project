package com.example.kotlin_formation.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_formation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Set OnClickListener for the ImageView
        binding.clothingImage.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/1ELTx0Ck-zmbZjZwh4z51ycGA6C0_yF_s/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }
        // Set OnClickListener for the ImageView
        binding.elecImage.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/19ibwGDeUAkQSI2YtkTV2B7mLGuQt5Vsy/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }
        // Set OnClickListener for the TP2
        binding.homeImage.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/1yv-PiIuj73TQl0WlpC6ex1aSJVB24DcU/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }
        // Set OnClickListener for the TP3
        binding.beautyImage.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/1IpLagqR5Mp2ODlERyc2D_7vxuhJdq73b/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }
        // Set OnClickListener for the TP4
        binding.pharmImage.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/1EPkqvYaaHfL8dFveePNXT4FZR6TLBM69/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }

        // Set OnClickListener for the TP5
        binding.grocImage.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/1WwpQpwFMsp_MVc8a9RPKMhH0iCMzngUh/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }

        // Set OnClickListener for the TP6
        binding.row4Item1Image.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/1J2C2p4oK9gcrh8MvsDjh-gmL_TeIMsw6/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }
        // Set OnClickListener for the TP7
        binding.row4Item2Image.setOnClickListener {
            // Google Drive URL
            val driveUrl = "https://drive.google.com/file/d/1J5qThbLn6fPdHo2gEnJqPR0bZgYwY7gn/view?usp=sharing"

            // Open the URL in a web browser
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(driveUrl))
            startActivity(browserIntent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}