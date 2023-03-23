package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class Instruction : Fragment() {

    private lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        with(binding) {
            chooseShoeButton.setOnClickListener{
                view?.let { it ->
                    Navigation.findNavController(it).navigate(R.id.action_instruction2_to_showList)
                }
            }
        }
        return binding.root
    }
}