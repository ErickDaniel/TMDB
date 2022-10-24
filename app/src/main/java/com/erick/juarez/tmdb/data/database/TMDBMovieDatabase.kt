package com.erick.juarez.tmdb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erick.juarez.tmdb.data.database.dao.TMDBMovieDao
import com.erick.juarez.tmdb.data.database.entities.TMDBPopularMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBTrendingMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBUpcomingMovieEntity

@Database(entities = [
    TMDBUpcomingMovieEntity::class,
    TMDBPopularMovieEntity::class,
    TMDBTrendingMovieEntity::class
], version = DATABASE_VERSION)
abstract class TMDBMovieDatabase: RoomDatabase() {

    abstract fun getTMDBMovieDao(): TMDBMovieDao

}