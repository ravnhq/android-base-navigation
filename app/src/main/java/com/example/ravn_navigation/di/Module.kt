package com.example.ravn_navigation.di

import com.example.ravn_navigation.repository.FakeRepository
import com.example.ravn_navigation.repository.FakeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object MyModule {
    @Provides
    fun provideRepository(): FakeRepository {
        // code for creating BlogDao
        return FakeRepositoryImpl()
    }
}