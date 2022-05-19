package com.example.ravn_navigation.auth.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ravn_navigation.repository.FakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(fakeRepository: FakeRepository) : ViewModel() {

    private val titleFlow: MutableStateFlow<String> = MutableStateFlow("Onboarding")
    private var dataFromDb: Flow<List<String>> = fakeRepository.getDataFromRoom()
    private val fakeEvent = MutableStateFlow(1)

    fun fetchOneMoreElement() {
        // TODO: not implemented yet
    }

    val registerState = OnboardingUiState(
        titleFlow = titleFlow,
        mutableStateValue = dataFromDb.stateIn(viewModelScope, SharingStarted.Lazily, emptyList()),
        fakeEvent,
        fetchMoreData = this::fetchOneMoreElement,
    )
}