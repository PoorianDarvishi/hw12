package com.example.netflix

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.databinding.FragmentComingSoonBinding

class ComingSoonFragment : Fragment(R.layout.fragment_coming_soon), IComingSoonClick {
    private val comingSoonViewModel: ComingSoonViewModel by activityViewModels()
    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentComingSoonBinding
    private lateinit var adapter: AdapterComingSoon
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentComingSoonBinding.bind(view)
        adapter = AdapterComingSoon(comingSoonViewModel.getImages(), this)
        recyclerView = binding.recycle
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }

    override fun onClick(position: Int) {
        if (mainViewModel.checkRegister()) {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, comingSoonViewModel.getImages()[position].linkImage)
            println(comingSoonViewModel.getImages()[position].linkImage)
            intent.type = "text/plain"
            startActivity(intent)
        } else {
            Toast.makeText(requireContext(), "Please Register", Toast.LENGTH_SHORT).show()
        }
    }
}