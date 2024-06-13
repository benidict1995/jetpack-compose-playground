package com.benidict.data.module

import com.benidict.data.repository.ExerciseRepository
import com.benidict.data.usecase.LoadExercisesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun providesLoadExerciseUseCase(
        exerciseRepository: ExerciseRepository,
    ) = LoadExercisesUseCase(exerciseRepository)
}
