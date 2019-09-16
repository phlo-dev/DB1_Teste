package com.pedro.db1.data_local.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.RuntimeException

fun <T> T.toJson() = Gson().toJson(this)

fun <T> String.fromGson(): T? = try {
    Gson().fromJson<T>(this,  object : TypeToken<T>() {}.type)
}catch (ignored: RuntimeException){ null }