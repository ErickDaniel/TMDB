package com.erick.juarez.tmdb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.erick.juarez.tmdb.data.database.dao.TMDBMovieDao
import com.erick.juarez.tmdb.data.database.entities.*

@Database(entities = [
    TMDBUpcomingMovieEntity::class,
    TMDBPopularMovieEntity::class,
    TMDBTrendingMovieEntity::class,
    TMDBMovieDetailEntity::class
], version = DATABASE_VERSION)
@TypeConverters(Converter::class)
abstract class TMDBMovieDatabase: RoomDatabase() {

    abstract fun getTMDBMovieDao(): TMDBMovieDao

}