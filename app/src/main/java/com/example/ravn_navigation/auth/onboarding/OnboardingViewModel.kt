package com.example.ravn_navigation.auth.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ravn_navigation.repository.FakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(val fakeRepository: FakeRepository) : ViewModel() {

    private val titleFlow: MutableStateFlow<String> = MutableStateFlow("Onboarding")
    private var dataFromDb = fakeRepository.getDataFromRoom().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    private val wordValueFlow: MutableStateFlow<String> = MutableStateFlow("")

    fun fetchOneMoreElement() {
        viewModelScope.launch(Dispatchers.IO) {
            fakeRepository.addDataToRoom(wordValueFlow.value)
        }
    }

    fun onWordChanged(value: String) {
        wordValueFlow.value = value
    }

    val registerState = OnboardingUiState(
        titleFlow = titleFlow,
        wordValue = wordValueFlow,
        mutableStateValue = dataFromDb,
        fetchMoreData = this::fetchOneMoreElement,
        onWordValueChanged = this::onWordChanged
    )
}