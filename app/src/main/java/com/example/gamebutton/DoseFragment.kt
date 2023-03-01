package com.example.gamebutton


import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.gamebutton.databinding.FragmentDoseBinding
import com.google.android.material.snackbar.Snackbar

class DoseFragment : Fragment(R.layout.fragment_dose) {

    private val viewModel: DoseViewModel by viewModels()
    private val infoViewModel: InfoViewModel by activityViewModels()
    lateinit var binding: FragmentDoseBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoseBinding.bind(view)

        binding.apply {
            viewModel.setPlayers(infoViewModel.getPlayer1(), infoViewModel.getPlayer2())

            doseViewModel = viewModel

            lifecycleOwner = this@DoseFragment

            val buttonList = listOf(
                button1, button2, button3, button4, button5, button6, button7, button8, button9
            )

            fun offClickable(button: Button) {
                button.isClickable = false
            }

            fun offClickAll() {
                buttonList.forEach {
                    it.isClickable = false
                }
            }

            fun onClickAll() {
                buttonList.forEach {
                    it.isClickable = true
                }
            }

            for (button in buttonList) {
                val tagPlace = button.tag.toString().toInt()
                button.setOnClickListener {
                    offClickable(button)
                    if (viewModel.choose(tagPlace) != StatusGameDose.NONE){
                        offClickAll()
                        Snackbar.make(view, viewModel.player.value.toString(), Snackbar.LENGTH_LONG).show()
                    }
                }
                if (viewModel.checkChoose(tagPlace)) {
                    offClickable(button)
                }
            }

            buttonReset.setOnClickListener {
                viewModel.reset()
                onClickAll()
            }
        }
    }
}