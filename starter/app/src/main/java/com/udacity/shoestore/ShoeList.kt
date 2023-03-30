package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI

class ShowList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel //by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding = FragmentShoeListBinding.inflate(layoutInflater, container, false)
        binding.fabAddShoe.setOnClickListener {
            val action = ShowListDirections.actionShowListToShoeDetail()
            findNavController().navigate(action)
        }
        val linearLayout = binding.showProduct
        viewModel.shoelist.value?.forEach { shoe ->
            val textView = TextView(context)
            textView.text =
                getString(R.string.shoe_list, shoe.company, shoe.name, shoe.size, shoe.description)
            linearLayout.addView(textView)

            (activity as AppCompatActivity).supportActionBar?.show()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.logout_menu, menu)
                }
                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return NavigationUI.onNavDestinationSelected(
                        menuItem,
                        requireView().findNavController()
                    )
                }
            },
            viewLifecycleOwner, Lifecycle.State.RESUMED
        )
        super.onViewCreated(view, savedInstanceState)
    }
}