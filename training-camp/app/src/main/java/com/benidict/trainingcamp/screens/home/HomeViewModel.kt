package com.benidict.trainingcamp.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benidict.data.usecase.LoadExercisesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val loadExercisesUseCase: LoadExercisesUseCase,
) : ViewModel() {

    fun loadExercises() {
        viewModelScope.launch {
            try {
                val invoke = loadExercisesUseCase.invoke()
            } catch (e: Exception) {
            }
        }
    }
}
