package com.example.testbf.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(private val images:List<String>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        private val binding = ItemDogBinding.bind(mView)
        //val ivDog:ImageView = mView.ivDog
        fun bind(item:String){
            Glide.with(context)
                .load(item)
                .into(binding.ivDog)

        }
    }

}