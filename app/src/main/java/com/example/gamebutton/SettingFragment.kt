package com.example.gamebutton

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.gamebutton.databinding.FragmentSettingBinding

class SettingFragment : Fragment(R.layout.fragment_setting) {
    private val infoViewModel: InfoViewModel by activityViewModels()
    lateinit var binding: FragmentSettingBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@SettingFragment
            infoView = infoViewModel
            buttonSumit.setOnClickListener {

                infoViewModel.setPlayer1(editTextTextPersonName1.text.toString())
                infoViewModel.setPlayer2(editTextTextPersonName2.text.toString())

                if (editTextTextColumn.text.toString()
                        .all { it.isDigit() } && editTextTextColumn.text.toString() != ""
                ) {
                    if (!infoViewModel.setColumn(editTextTextColumn.text.toString().toInt())) {
                        Toast.makeText(
                            requireContext(),
                            "column be should grater dan 5",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}