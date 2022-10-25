package com.erick.juarez.tmdb.util

import com.orhanobut.logger.Logger

fun printLogI(msg: String?, prettyMode: Boolean){
    if(prettyMode) {
        Logger.i(msg.orEmpty())
    } else {
        print(msg.orEmpty())
    }
}

fun printLogE(msg: String?, prettyMode: Boolean){
    if(prettyMode) {
        Logger.e(msg.orEmpty())
    } else {
        print(msg.orEmpty())
    }
}
