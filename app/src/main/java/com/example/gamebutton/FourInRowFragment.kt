package com.example.gamebutton

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gamebutton.databinding.FragmentFourInRowBinding
import com.google.android.material.snackbar.Snackbar


class FourInRowFragment : Fragment(R.layout.fragment_four_in_row), IClickListener {
    private val infoViewModel: InfoViewModel by activityViewModels()
    private val viewModel: FourInRowFragmentViewModel by viewModels()
    private lateinit var binding: FragmentFourInRowBinding
    private lateinit var recyclerViewFragment: RecyclerView
    private lateinit var adaptor: Adaptor
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.setPlayers(infoViewModel.getPlayer1(), infoViewModel.getPlayer2())
        if (savedInstanceState == null) {
            viewModel.changeRowAndColumn(infoViewModel.getColumn())
        } else {
            if (viewModel.getColumn() != infoViewModel.getColumn()) {
                viewModel.reset()
                viewModel.changeRowAndColumn(infoViewModel.getColumn())
            }
        }


        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFourInRowBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@FourInRowFragment
            fourRowViewModel = viewModel
            recyclerViewFragment = recyclerView
            adaptor = Adaptor(viewModel.getListPlace(), this@FourInRowFragment, viewModel.status, view)
            recyclerView.layoutManager = GridLayoutManager(requireContext(), viewModel.getColumn())
            recyclerView.adapter = adaptor
            buttonReset.setOnClickListener {
                viewModel.reset()
                viewModel.changeRowAndColumn(infoViewModel.getColumn())
                adaptor.notifyDataSetChanged()
            }
        }
    }

    override fun setOnClickListener(number: Int, view: View) {
        viewModel.choosePlace(number)
        if (viewModel.checkWin()) {
            Snackbar.make(view, viewModel.player.value.toString(), Snackbar.LENGTH_LONG).show()
        }
    }
}
