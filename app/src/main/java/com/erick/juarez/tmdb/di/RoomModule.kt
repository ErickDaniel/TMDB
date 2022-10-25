package com.erick.juarez.tmdb.di

import android.content.Context
import androidx.room.Room
import com.erick.juarez.tmdb.data.database.DATABASE_NAME
import com.erick.juarez.tmdb.data.database.TMDBMovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideTMDBRoom(@ApplicationContext ctx: Context) =
        Room.databaseBuilder(ctx, TMDBMovieDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideTMDBDao(database: TMDBMovieDatabase) = database.getTMDBMovieDao()

}