package com.anonymousvpn.github

import android.content.Context

object TokenStore {

    private const val PREFS = "forge_prefs"
    private const val KEY = "github_token"

    fun save(context: Context, token: String) {
        context.getSharedPreferences(PREFS, 0)
            .edit()
            .putString(KEY, token)
            .apply()
    }

    fun get(context: Context): String? {
        return context.getSharedPreferences(PREFS, 0)
            .getString(KEY, null)
    }
}
