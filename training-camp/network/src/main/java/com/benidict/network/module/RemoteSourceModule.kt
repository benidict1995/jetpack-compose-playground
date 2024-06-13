package com.benidict.network.module

import com.benidict.network.ExerciseServiceAPI
import com.benidict.network.source.ExerciseRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteSourceModule {

    @Singleton
    @Provides
    fun provideExerciseRemoteSource(
        exerciseServiceAPI: ExerciseServiceAPI,
    ) = ExerciseRemoteSource(
        exerciseServiceAPI,
    )
}
