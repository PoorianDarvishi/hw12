package com.example.netflix

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.databinding.FragmentLikeBinding


class LikeFragment : Fragment(R.layout.fragment_like) {
    private val homeViewModel : ImagesViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentLikeBinding
    private lateinit var adapter : AdapterFavorite
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLikeBinding.bind(view)
        adapter = AdapterFavorite(homeViewModel.getLikeList().toMutableList())
        recyclerView = binding.recycle
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }

}