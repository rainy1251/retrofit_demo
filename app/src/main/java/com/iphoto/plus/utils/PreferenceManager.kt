package com.iphoto.plus.utils

import android.content.Context
import android.content.SharedPreferences
import com.iphoto.plus.base.MyAppContext

object PreferenceManager {
    private const val PREF_NAME = "home_preference"
    private const val KEY_TOKEN = "token"


    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveToken( token: String) {
        val editor = getSharedPreferences(MyAppContext.context).edit()
        editor.putString(KEY_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {
        return getSharedPreferences(MyAppContext.context).getString(KEY_TOKEN, null)
    }
}
