package com.erick.juarez.tmdb.util

import com.orhanobut.logger.Logger

fun printLogI(msg: String, prettyMode: Boolean){
    if(prettyMode) {
        Logger.i(msg)
    } else {
        print(msg)
    }
}

fun printLogE(msg: String, prettyMode: Boolean){
    if(prettyMode) {
        Logger.e(msg)
    } else {
        print(msg)
    }
}
