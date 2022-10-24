package com.erick.juarez.tmdb.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.erick.juarez.tmdb.BuildConfig
import com.erick.juarez.tmdb.data.rest.TMDBApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext ctx: Context): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(getChuckerInterceptor(ctx))
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getChuckerInterceptor(ctx: Context) =
        ChuckerInterceptor.Builder(ctx).build()

    @Singleton
    @Provides
    fun provideEmployeeApiClient(retrofit: Retrofit): TMDBApiClient =
        retrofit.create(TMDBApiClient::class.java)

}