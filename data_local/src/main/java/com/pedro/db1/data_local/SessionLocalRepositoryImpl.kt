package com.pedro.db1.data_local

import com.pedro.db1.data.local.SessionLocalRepository
import com.pedro.db1.data_local.utils.PreferencesUtils
import com.pedro.db1.data_local.utils.PreferencesUtils.Companion.SESSION_KEY

class SessionLocalRepositoryImpl(private val preferences: PreferencesUtils): SessionLocalRepository {
    override var isLogged: Boolean = false
        get() = preferences.getObject<Boolean>(SESSION_KEY) ?: false
        set(value) {
            field = value
            preferences.saveObject(SESSION_KEY, value)
        }
}