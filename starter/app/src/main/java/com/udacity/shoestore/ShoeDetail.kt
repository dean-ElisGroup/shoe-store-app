package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetail : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        binding.save.setOnClickListener {
            val shoe = Shoe(
                binding.shoeName.text.toString(),
                binding.shoeSize.text.toString().toDouble(),
                binding.shoeCompany.text.toString(),
                binding.shoeDescription.text.toString()
            )
            viewModel.addShoe(shoe)
            val actionAdd = ShoeDetailDirections.actionShoeDetailToShoeList()
            findNavController().navigate(actionAdd)
        }

        binding.back.setOnClickListener {
            val actionBack = ShoeDetailDirections.actionShoeDetailToShoeList()
            findNavController().navigate(actionBack)
        }
        return binding.root
    }

}