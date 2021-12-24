package com.teachmeskills.lesson21sample.log

import android.util.Log

fun log(any: Any, message: String) {
    Log.d("${any::class.java.simpleName}Tag", message)
}