package com.example.ravn_navigation.repository

import kotlinx.coroutines.flow.Flow

interface FakeRepository {
    suspend fun addDataToRoom(word:String)
    fun getDataFromRoom(): Flow<List<String>>
}