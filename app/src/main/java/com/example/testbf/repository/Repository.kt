package com.example.testbf.repository

import com.example.testbf.data.model.Character

interface Repository {
    suspend fun getCharacters(): Character
}