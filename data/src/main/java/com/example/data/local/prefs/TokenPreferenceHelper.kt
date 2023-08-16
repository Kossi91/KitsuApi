package com.example.data.local.prefs

import android.content.Context
class TokenPreferenceHelper(context: Context) {

    private var prefs = context.getSharedPreferences(PREF_IS_AUTHORIZED, Context.MODE_PRIVATE)

    var accessToken: String?
        get() = prefs.getString(PREF_ACCESS_TOKEN, null)
        set(value) = prefs.edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var refreshToken: String?
        get() = prefs.getString(PREF_REFRESH_TOKEN, null)
        set(value) = prefs.edit().putString(PREF_REFRESH_TOKEN, value).apply()

    var onBoardIsShown: Boolean
        get() = prefs.getBoolean(ON_BOARD, false)
        set(value) = prefs.edit().putBoolean(ON_BOARD, value).apply()

    companion object {
        const val PREF_IS_AUTHORIZED = "PREFS_TOKEN_FILE"
        const val PREF_ACCESS_TOKEN = "USER_ACCESS_TOKEN"
        const val PREF_REFRESH_TOKEN = "USER_REFRESH_TOKEN"
        const val ON_BOARD = "ON_BOARD"
    }
}