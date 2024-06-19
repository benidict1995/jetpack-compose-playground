package com.benidict.trainingcamp.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benidict.data.usecase.LoadExercisesUseCase
import com.benidict.domain.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val loadExercisesUseCase: LoadExercisesUseCase,
) : ViewModel() {

    private val _exerciseState: MutableStateFlow<List<Exercise>> = MutableStateFlow(emptyList())
    val exerciseState = _exerciseState.asStateFlow()

    private val _errorState: MutableStateFlow<String> = MutableStateFlow("")
    val errorState = _errorState.asStateFlow()

    fun loadExercises() {
        viewModelScope.launch {
            try {
                val invoke = loadExercisesUseCase.invoke()
                _exerciseState.emit(invoke)
            } catch (e: Exception) {
                Log.d("makerChecker", "errrror:${e.message}")
                _errorState.emit(e.message ?: e.localizedMessage)
            }
        }
    }
}
