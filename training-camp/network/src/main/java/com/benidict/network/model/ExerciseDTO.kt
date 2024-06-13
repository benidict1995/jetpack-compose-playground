package com.benidict.network.model

import com.benidict.domain.model.Exercise
import com.google.gson.annotations.SerializedName

data class ExerciseDTO(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("muscle") val muscle: String,
    @SerializedName("equipment") val equipment: String,
    @SerializedName("difficulty") val difficulty: String,
    @SerializedName("instructions") val instructions: String,
) {
    companion object {
        fun toDomain(exerciseDTO: List<ExerciseDTO>): List<Exercise> {
            return exerciseDTO.map {
                with(it) {
                    Exercise(
                        name = name,
                        type = type,
                        muscle = muscle,
                        equipment = equipment,
                        difficulty = difficulty,
                        instructions = instructions,
                    )
                }
            }
        }
    }
}
