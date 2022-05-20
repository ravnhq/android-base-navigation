package com.example.ravn_navigation.auth.onboarding

import com.example.ravn_navigation.db.model.Word
import kotlinx.coroutines.flow.StateFlow

data class OnboardingUiState(
    val titleFlow: StateFlow<String>,
    val mutableStateValue: StateFlow<List<Word>>,
    val wordValue: StateFlow<String>,
    val fetchMoreData: () -> Unit,
    val onWordValueChanged: (String) -> Unit
)