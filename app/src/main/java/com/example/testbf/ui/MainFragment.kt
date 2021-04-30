package com.example.testbf.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testbf.R
import com.example.testbf.data.model.Result
import com.example.testbf.data.remote.DataSource
import com.example.testbf.data.remote.RetrofitClient
import com.example.testbf.databinding.MainBlankBinding
import com.example.testbf.repository.RepositoryImpl
import com.example.testbf.util.Resource
import com.example.testbf.viewmodel.ViewModelMain
import com.example.testbf.viewmodel.ViewModelMainFactory


class MainFragment : Fragment(R.layout.main_blank) {

    private lateinit var binding: MainBlankBinding
    private val viewModel by viewModels<ViewModelMain> { ViewModelMainFactory(RepositoryImpl(DataSource(RetrofitClient.webservice))) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.button1.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }*/
        binding = MainBlankBinding.bind(view)
        with(binding){
            viewModel.fetchServiceTramo().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                when (it) {
                    is Resource.Loading -> {
                        Log.d("LiveData", "Loading...")
                        progress.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        Log.d("LiveData", "${it.data.results}")
                        progress.visibility = View.GONE
                        initRecyclerView(it.data.results)
                    }
                    is Resource.Failure -> {
                        Log.d("LiveData", "${it.exception}")
                        progress.visibility = View.GONE
                    }

                }
            })
        }


    }

    private fun initRecyclerView(data: List<Result>) {
        var adapter = MainAdapter(data)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

}