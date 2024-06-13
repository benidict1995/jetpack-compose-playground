package com.benidict.network.source

import com.benidict.network.ExerciseServiceAPI
import javax.inject.Inject

class ExerciseRemoteSource @Inject constructor(
    private val api: ExerciseServiceAPI,
)
