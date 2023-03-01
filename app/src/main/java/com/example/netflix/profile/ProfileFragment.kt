package com.example.netflix.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.netflix.main.MainViewModel
import com.example.netflix.R
import com.example.netflix.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    lateinit var binding: FragmentProfileBinding
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        binding.apply {
            imageView2.setImageURI(mainViewModel.imageProfile)
            infoViewModel = mainViewModel
            lifecycleOwner = this@ProfileFragment
        }
    }
}