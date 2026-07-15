package com.fashionai.util

import android.content.Context
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "fashion_ai_preferences")

object PreferencesKeys {
    val DARK_MODE = androidx.datastore.preferences.stringPreferencesKey("dark_mode")
    val LANGUAGE = androidx.datastore.preferences.stringPreferencesKey("language")
    val NOTIFICATIONS = androidx.datastore.preferences.stringPreferencesKey("notifications")
    val FIRST_LAUNCH = androidx.datastore.preferences.stringPreferencesKey("first_launch")
}
