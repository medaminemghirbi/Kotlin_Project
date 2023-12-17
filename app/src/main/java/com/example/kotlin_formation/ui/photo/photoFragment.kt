package com.example.kotlin_formation.ui.photo

import ImageViewPagerAdapter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlin_formation.R

class photoFragment : Fragment() {
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ImageViewPagerAdapter

    companion object {
        fun newInstance() = photoFragment()
    }

    private lateinit var viewModel: PhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo, container, false)
        viewPager = view.findViewById(R.id.viewPager)

        // Replace the list below with your actual list of image URLs
        val imageUrls = listOf(
            "https://c1.wallpaperflare.com/preview/835/994/337/tunisia-komachi-seaside-sea.jpg",
            "https://tunisie.co/uploads/images/content/medinadesouss-200919-1.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVViP1nvH0sdiOo8r45ru3RV4stce_aaDAV4eRQNwT3vVq8HSEn9bsmk6tMiq5AwZ-U6A&usqp=CAU"
        )

        adapter = ImageViewPagerAdapter(imageUrls)
        viewPager.adapter = adapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
