package com.example.testbf.repository

import com.example.testbf.data.model.Character
import com.example.testbf.data.remote.DataSource

class RepositoryImpl(private val dataSource: DataSource): Repository {
    override suspend fun getCharacters(): Character = dataSource.getCharacters()

}