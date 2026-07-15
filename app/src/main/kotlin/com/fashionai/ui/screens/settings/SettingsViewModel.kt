package com.fashionai.ui.screens.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {
    val isDarkMode = mutableStateOf(false)
    val selectedLanguage = mutableStateOf("en")
    val notificationsEnabled = mutableStateOf(true)

    fun setDarkMode(enabled: Boolean) {
        isDarkMode.value = enabled
    }

    fun setLanguage(language: String) {
        selectedLanguage.value = language
    }

    fun setNotifications(enabled: Boolean) {
        notificationsEnabled.value = enabled
    }
}
