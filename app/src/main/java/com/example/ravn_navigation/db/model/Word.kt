package com.example.ravn_navigation.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Word(
    @PrimaryKey
    val word: String
)
