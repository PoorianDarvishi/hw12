package com.example.netflix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home), IHomeClick {
    private val homeViewModel : ImagesViewModel by activityViewModels()
    private val mainViewModel : MainViewModel by activityViewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentHomeBinding
    lateinit var adapter : AdapterHome
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        adapter = AdapterHome(homeViewModel.getImages(),this)
        recyclerView = binding.recycle
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }



    override fun onClick(position: Int) {
        if (mainViewModel.checkRegister()){
            homeViewModel.click(position)
            return
        }else{
            Toast.makeText(requireContext(),"Please Register",Toast.LENGTH_SHORT).show()
        }
    }
}