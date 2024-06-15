package com.benidict.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Exercise (
    val name: String,
    val type: String,
    val muscle: String,
    val equipment: String,
    val difficulty: String,
    val instructions: String
)