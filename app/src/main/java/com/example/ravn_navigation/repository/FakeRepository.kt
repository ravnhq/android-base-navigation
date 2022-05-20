package com.example.ravn_navigation.repository

import com.example.ravn_navigation.db.MainDatabase
import com.example.ravn_navigation.db.model.Word
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class FakeRepository @Inject constructor(val db: MainDatabase) {
    suspend fun addDataToRoom(word: String) {
        db.worldDao().insertWord(Word(word = word))
    }

    fun getDataFromRoom(): Flow<List<Word>> = db.worldDao().getAllWords()
}