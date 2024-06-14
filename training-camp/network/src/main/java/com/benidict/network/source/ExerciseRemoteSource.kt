package com.benidict.network.source

import com.benidict.domain.model.Exercise
import com.benidict.network.BuildConfig
import com.benidict.network.ExerciseServiceAPI
import com.benidict.network.model.ExerciseDTO
import javax.inject.Inject

class ExerciseRemoteSource @Inject constructor(
    private val api: ExerciseServiceAPI,
) {

    suspend fun loadExercises(): List<Exercise> {
        val invoke = api.loadExercises(token = BuildConfig.API_KEY, 50)
        return ExerciseDTO.toDomain(invoke)
    }
}
