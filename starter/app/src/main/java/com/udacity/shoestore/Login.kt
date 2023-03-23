package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class Login : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        with(binding) {
            loginButton.setOnClickListener{
                view?.let { it ->
                    Navigation.findNavController(it).navigate(R.id.action_login_to_welcome2)
                }
            }
            signupButton.setOnClickListener {
                view?.let { it ->
                    Navigation.findNavController(it).navigate(R.id.action_login_to_welcome2)
                }
            }
        }
        return binding.root
    }

}