package com.example.deeplinkproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController


class MainFragment : Fragment() {

    private var btnButton: Button ?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        btnButton = view.findViewById(R.id.btn_main_fragment)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnButton?.setOnClickListener {
            Bundle().apply {
                putString("name","name of you ")
                findNavController().navigate(R.id.action_mainFragment_to_loginFragment,this)
            }

        }
    }

}