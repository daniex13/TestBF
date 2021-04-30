package com.example.testbf.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testbf.R
import com.example.testbf.databinding.MainBlankBinding


class MainFragment : Fragment(R.layout.main_blank) {

    private lateinit var binding: MainBlankBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }


    }

}