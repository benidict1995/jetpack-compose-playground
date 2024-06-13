package com.benidict.data.module

import com.benidict.data.repository.ExerciseRepository
import com.benidict.network.source.ExerciseRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideExerciseRepository(
        exerciseRemoteSource: ExerciseRemoteSource,
    ) = ExerciseRepository(exerciseRemoteSource)
}
