package com.pedro.db1.data_local.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtils(private val context: Context) {
    companion object {
        const val PREF_KEY = "DB1_TEST}"
        const val SESSION_KEY = "session"
    }

    private val preferences: SharedPreferences
        get() = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)


    fun <T> getObject(key: String): T? = preferences.getString(key, "")?.fromGson<T>()

    fun <T> saveObject(key: String, data: T) = preferences.edit().run {
        putString(key, data.toJson())
        apply()
    }
}