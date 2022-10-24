package com.erick.juarez.tmdb.domain

interface UseCase<T> {

    suspend operator fun invoke():T

}