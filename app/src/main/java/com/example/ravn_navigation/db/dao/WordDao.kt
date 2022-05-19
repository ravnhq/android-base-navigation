package com.example.ravn_navigation.db.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ravn_navigation.db.model.Word
import kotlinx.coroutines.flow.Flow
import java.nio.channels.Channels

@Dao
interface WordDao {
    @Query("SELECT * FROM Word")
    fun getAllWords(): Flow<List<Channels>>

    @Insert
    suspend fun insertWord(value: Word)
}