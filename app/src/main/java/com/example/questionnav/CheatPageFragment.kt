package com.example.questionnav

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.questionnav.databinding.FragmentCheatPageBinding

class CheatPageFragment : Fragment(R.layout.fragment_cheat_page) {
    private lateinit var binding : FragmentCheatPageBinding
    private val viewModel : CheatViewModel by viewModels()
    private val args : CheatPageFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCheatPageBinding.bind(view)
        binding.apply {
            cheatViewModel = viewModel
            lifecycleOwner = this@CheatPageFragment
            buttonShowAnswer.setOnClickListener {
                viewModel.setAnswer(args.answer)
                println(args.answer)
                viewModel.showAnswer()
                setFragmentResult(QuizPageFragment.RESULT, bundleOf("RESULT" to "OK"))
            }

        }
    }
}