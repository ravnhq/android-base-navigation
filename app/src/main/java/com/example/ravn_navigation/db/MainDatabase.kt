package com.example.ravn_navigation.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ravn_navigation.db.dao.WordDao
import com.example.ravn_navigation.db.model.Word
import javax.inject.Singleton

@Singleton
@Database(entities = [Word::class], version = 1)
abstract class MainDatabase : RoomDatabase() {
    abstract fun worldDao(): WordDao
}