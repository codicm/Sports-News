package com.example.sportsnewsandinformationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sportsnewsandinformationapp.R
import com.example.sportsnewsandinformationapp.databinding.FragmentHistoricalSportsArchiveBinding

class HistoricalSportsArchiveFragment : Fragment() {
    private lateinit var binding: FragmentHistoricalSportsArchiveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_historical_sports_archive, container, false)
        binding = FragmentHistoricalSportsArchiveBinding.bind(view)
        return binding.root
    }
}