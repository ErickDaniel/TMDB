package com.erick.juarez.tmdb.data.database.entities

import androidx.room.TypeConverter
import com.erick.juarez.tmdb.data.model.TMDBGenere
import com.erick.juarez.tmdb.data.model.TMDBProductionCompany
import com.erick.juarez.tmdb.data.model.TMDBProductionCountry
import com.erick.juarez.tmdb.data.model.TMDBSpokenLanguage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun objectToJson(value: Any?) = Gson().toJson(value)

    @TypeConverter
    fun stringToListGenere(string: String?): List<TMDBGenere>? {
        return Gson().fromJson(
            string,
            object : TypeToken<List<TMDBGenere?>?>() {}.type
        )
    }

    @TypeConverter
    fun stringToListProductionCompany(string: String?): List<TMDBProductionCompany>? {
        return Gson().fromJson(
            string,
            object : TypeToken<List<TMDBProductionCompany?>?>() {}.type
        )
    }

    @TypeConverter
    fun stringToListProductionCountry(string: String?): List<TMDBProductionCountry>? {
        return Gson().fromJson(
            string,
            object : TypeToken<List<TMDBProductionCountry?>?>() {}.type
        )
    }

    @TypeConverter
    fun stringToListSpokenLanguage(string: String?): List<TMDBSpokenLanguage>? {
        return Gson().fromJson(
            string,
            object : TypeToken<List<TMDBSpokenLanguage?>?>() {}.type
        )
    }

}