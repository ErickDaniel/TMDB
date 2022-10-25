package com.erick.juarez.tmdb.util

fun Boolean?.orFalse() = this ?: false
fun Double?.orZero() = this ?: 0.0