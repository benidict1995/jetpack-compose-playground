package com.benidict.data.usecase

import com.benidict.data.repository.ExerciseRepository
import javax.inject.Inject

class LoadExercisesUseCase @Inject constructor(
    private val exerciseRepository: ExerciseRepository,
) {

    suspend fun invoke() = exerciseRepository.loadExercises()
}
