package com.icure.sdk.api

import com.icure.sdk.model.ApplicationSettings

interface ApplicationSettingsApi {
	suspend fun getApplicationSettings(): List<ApplicationSettings>
	suspend fun createApplicationSettings(applicationSettings: ApplicationSettings): ApplicationSettings
	suspend fun updateApplicationSettings(applicationSettings: ApplicationSettings): ApplicationSettings
}
