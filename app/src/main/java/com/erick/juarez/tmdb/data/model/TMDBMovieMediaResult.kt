package com.erick.juarez.tmdb.data.model

data class TMDBMovieMediaResult (
    var id:Int = 0,
    var results:Array<TMDBMovieMedia> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TMDBMovieMediaResult

        if (id != other.id) return false
        if (!results.contentEquals(other.results)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + results.contentHashCode()
        return result
    }
}