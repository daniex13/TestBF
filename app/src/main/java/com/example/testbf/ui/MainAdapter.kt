package com.example.testbf.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbf.R
import com.example.testbf.data.model.Result
import com.example.testbf.databinding.ItemCharacterBinding

class MainAdapter(private val data: List<Result>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        context = parent.context
        return ViewHolder(layoutInflater.inflate(R.layout.item_character,parent,false))
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun getItemCount(): Int = data.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        private val binding = ItemCharacterBinding.bind(mView)
        //val ivDog:ImageView = mView.ivDog

        fun bind(item: Result){
            binding.values.text = item.name
            Glide.with(context)
                .load(item.image)
                .into(binding.image)
            mView.setOnClickListener {
                mView.findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundleOf("data" to item.toString()))
            }

        }
    }

}