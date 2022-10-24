package com.erick.juarez.tmdb.di

import com.erick.juarez.tmdb.BuildConfig
import com.erick.juarez.tmdb.data.rest.TMDBApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideEmployeeApiClient(retrofit: Retrofit): TMDBApiClient =
        retrofit.create(TMDBApiClient::class.java)

}