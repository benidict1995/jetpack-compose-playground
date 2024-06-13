package com.benidict.network

import com.benidict.network.model.ExerciseDTO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ExerciseServiceAPI {
    @Headers("Accept: application/json")
    @GET("exercises")
    suspend fun loadExercises(
        @Header("X-Api-Key") token: String,
    ): List<ExerciseDTO>
}
