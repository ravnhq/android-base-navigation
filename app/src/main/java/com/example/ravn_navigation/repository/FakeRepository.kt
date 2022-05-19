package com.example.ravn_navigation.repository

import com.example.ravn_navigation.db.MainDatabase
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Reusable
class FakeRepository @Inject constructor(val db: MainDatabase)  {
    val fakeListOfWords = listOf<String>("HELLO", "WORLDS")

     suspend fun addDataToRoom(word: String) {

    }

     fun getDataFromRoom(): Flow<List<String>> = flow<List<String>> {
        emit(fakeListOfWords)
    }.flowOn(Dispatchers.IO)
}