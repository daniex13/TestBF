package com.example.testbf.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.testbf.repository.Repository
import com.example.testbf.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class ViewModelMain (private val repo: Repository) : ViewModel(){

    fun fetchServiceTramo() = liveData(Dispatchers.IO){
        emit(Resource.Loading())
        try{
            emit(Resource.Success(repo.getCharacters()))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}

class ViewModelMainFactory(private val repo:Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repository::class.java).newInstance(repo)
    }

}