package com.example.ravn_navigation.di

import android.app.Application
import androidx.room.Room
import com.example.ravn_navigation.db.MainDatabase
import com.example.ravn_navigation.db.dao.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val NAME = "photos"
    @Provides
    @Singleton
    fun provideDatabase(application: Application): MainDatabase {
        return Room.databaseBuilder(
            application,
            MainDatabase::class.java, NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePhotosDao(database: MainDatabase): WordDao {
        return database.worldDao()
    }
}

