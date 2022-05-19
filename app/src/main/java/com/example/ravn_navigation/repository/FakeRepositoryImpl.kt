package com.example.ravn_navigation.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FakeRepositoryImpl @Inject constructor() : FakeRepository {
    val fakeListOfWords = listOf<String>("HELLO", "WORLDS")

    override suspend fun addDataToRoom(word: String) {
        
    }

    override fun getDataFromRoom(): Flow<List<String>> = flow<List<String>> {
        emit(fakeListOfWords)
    }.flowOn(Dispatchers.IO)
}