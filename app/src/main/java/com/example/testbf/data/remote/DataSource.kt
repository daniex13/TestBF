package com.example.testbf.data.remote

import com.example.testbf.data.model.Character

class DataSource(private val webService: WebService) {
    suspend fun getCharacters():Character{
        return webService.getCharacters()
    }
}