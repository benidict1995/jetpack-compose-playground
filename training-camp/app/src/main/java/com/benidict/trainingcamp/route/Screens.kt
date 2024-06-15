package com.benidict.trainingcamp.route

import kotlinx.serialization.Serializable

@Serializable
object SplashRoute

@Serializable
object HomeRoute

@Serializable
data class ExerciseDetailsRoute(val exercise: String)
