package com.example.questionnav

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.questionnav.databinding.FragmentQuizPageBinding

class QuizPageFragment : Fragment(R.layout.fragment_quiz_page) {
    companion object {
        const val RESULT = "RESULT_OK"
    }
    private lateinit var binding: FragmentQuizPageBinding
    private val viewModel: QuizViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizPageBinding.bind(view)
        binding.apply {
            quizViewModel = viewModel
            lifecycleOwner = this@QuizPageFragment
            buttonNext.setOnClickListener {
                viewModel.nextQuestion()
            }

            buttonPrev.setOnClickListener {
                viewModel.prevQuestion()
            }

            buttonTrue.setOnClickListener {
                showToast(viewModel.checkAnswer(QuizViewModel.TRUE))
            }

            buttonFalse.setOnClickListener {
                showToast(viewModel.checkAnswer(QuizViewModel.FALSE))
            }

            buttonCheat.setOnClickListener {
                setFragmentResultListener(
                    RESULT
                ) { _, _ ->
                    viewModel.cheat()
                }
                Navigation.findNavController(view).navigate(
                    QuizPageFragmentDirections.actionQuizPageFragmentToCheatPageFragment(viewModel.getAnswer())
                )
            }
        }
    }

    private fun showToast(massage: String) {
        Toast.makeText(requireContext(), massage, Toast.LENGTH_SHORT).show()
    }
}