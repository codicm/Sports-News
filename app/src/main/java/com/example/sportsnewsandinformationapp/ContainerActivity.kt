package com.example.sportsnewsandinformationapp

import android.os.Bundle
import android.view.Gravity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.sportsnewsandinformationapp.adapters.MyPageAdapter
import com.example.sportsnewsandinformationapp.databinding.ActivityContainerBinding
import com.example.sportsnewsandinformationapp.databinding.ActivityMainBinding
import com.example.sportsnewsandinformationapp.fragments.EventsFragment
import com.example.sportsnewsandinformationapp.fragments.HistoricalSportsArchiveFragment
import com.example.sportsnewsandinformationapp.fragments.NewsFragment
import com.google.android.material.tabs.TabLayoutMediator

class ContainerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myPageAdapter = MyPageAdapter(this)
        binding.viewPager.adapter = myPageAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            when(position){
                0 -> {
                    tab.text = getString(R.string.sports)
                    tab.setIcon(R.drawable.sports)
                }
                1 -> {
                    tab.text = getString(R.string.news)
                    tab.setIcon(R.drawable.news)
                }
                2 -> {
                    tab.text = getString(R.string.athletes)
                    tab.setIcon(R.drawable.athletes)
                }
                3 -> {
                    tab.text = getString(R.string.events)
                    tab.setIcon(R.drawable.events)
                }
                4 -> {
                    tab.text = getString(R.string.archives)
                    tab.setIcon(R.drawable.archive)

                }
                5 -> {
                    tab.text = getString(R.string.about)
                    tab.setIcon(R.drawable.about)
                }
            }
        }.attach()

        binding.bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuNews -> binding.viewPager.setCurrentItem(1, true)
                R.id.menuEvents -> binding.viewPager.setCurrentItem(3, true)
                R.id.menuArchives -> binding.viewPager.setCurrentItem(4, true)
            }
            true
        }
    }

}