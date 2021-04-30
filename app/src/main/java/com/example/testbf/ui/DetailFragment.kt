package com.example.testbf.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.testbf.R
import com.example.testbf.data.model.Result
import com.example.testbf.data.remote.DataSource
import com.example.testbf.data.remote.RetrofitClient
import com.example.testbf.databinding.DetailBlank2Binding
import com.example.testbf.databinding.MainBlankBinding
import com.example.testbf.repository.RepositoryImpl
import com.example.testbf.util.Resource
import com.example.testbf.viewmodel.ViewModelMain
import com.example.testbf.viewmodel.ViewModelMainFactory
import kotlinx.android.synthetic.main.item_character.*

class DetailFragment : Fragment(R.layout.detail_blank2) {

    private lateinit var binding: DetailBlank2Binding

    private lateinit var data: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.get("data") as Result
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.button1.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }*/
        binding = DetailBlank2Binding.bind(view)
        with(binding){
            context?.let {
                Glide.with(it)
                    .load(data.image)
                    .into(photo)
            }
            name.text = data.name
            status.text = data.name
            species.text = data.name
            gender.text = data.name
        }





    }
}