package com.erick.juarez.tmdb.data.model

data class TMDBMovieMedia (
    var id:String = "",
    var iso_639_1:String = "",
    var iso_3166_1:String = "",
    var key:String? = "",
    var name:String = "",
    var site:String = "",
    var size:Int = 0,
    var type:String = ""
)