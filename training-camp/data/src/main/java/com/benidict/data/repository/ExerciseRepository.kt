package com.benidict.data.repository

import com.benidict.domain.model.Exercise
import com.benidict.network.source.ExerciseRemoteSource
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val exerciseRemoteSource: ExerciseRemoteSource,
) {

    suspend fun loadExercises(): List<Exercise> {
        return exerciseRemoteSource.loadExercises()
    }
}
