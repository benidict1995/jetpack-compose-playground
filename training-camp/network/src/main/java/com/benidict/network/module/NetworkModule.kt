package com.benidict.network.module

import com.benidict.network.ExerciseServiceAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideConnectionTimeout() = 1000

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .setLenient().create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): ExerciseServiceAPI =
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ExerciseServiceAPI::class.java)
}
