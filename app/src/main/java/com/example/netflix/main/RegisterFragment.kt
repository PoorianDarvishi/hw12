package com.example.netflix.main

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.netflix.R
import com.example.netflix.databinding.FragmentRegisterBinding
import com.example.netflix.profile.ProfileFragment


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private val mainViewModel: MainViewModel by activityViewModels()
    lateinit var binding: FragmentRegisterBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)
        binding.apply {
            val activityForResult =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    if (result.resultCode == RESULT_OK) {
                        val selectedImageUri: Uri? = result.data?.data
                        if (selectedImageUri != null) {
                            mainViewModel.setProfile(selectedImageUri)
                            binding.imageProfile.setImageURI(selectedImageUri)
                        }
                    }

                }
            buttonRegister.setOnClickListener {
                mainViewModel.setFirstName(editTextTextPersonFirstName.text.toString())
                mainViewModel.setLastName(editTextTextPersonLastName.text.toString())
                mainViewModel.setEmail(editTextTextPersonEmail.text.toString())
                mainViewModel.setPhoneNumber(editTextTextUserPhoneNumber.text.toString())
                mainViewModel.setUserName(editTextTextUserName.text.toString())
                if (mainViewModel.checkRegister()) {
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<ProfileFragment>(R.id.fragmentContainerView)
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "please inter your information!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            imageProfile.setOnClickListener {
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                activityForResult.launch(intent)
            }

        }
    }


}