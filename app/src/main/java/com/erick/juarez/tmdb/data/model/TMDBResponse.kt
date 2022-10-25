package com.erick.juarez.tmdb.data.model

import com.google.gson.annotations.SerializedName

data class TMDBResponse (
    var page:Int = 0,
    var results:Array<TMDBMovie> = emptyArray(),
    @SerializedName("total_pages")
    var totalPages:Int = 0,
    @SerializedName("total_results")
    var totalResults:Int = 0
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TMDBResponse

        if (page != other.page) return false
        if (!results.contentEquals(other.results)) return false
        if (totalPages != other.totalPages) return false
        if (totalResults != other.totalResults) return false

        return true
    }

    override fun hashCode(): Int {
        var result = page
        result = 31 * result + results.contentHashCode()
        result = 31 * result + totalPages
        result = 31 * result + totalResults
        return result
    }
}