package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.ApplicationSettings

interface ApplicationSettingsApi {
	suspend fun getApplicationSettings(): List<ApplicationSettings>
	suspend fun createApplicationSettings(applicationSettings: ApplicationSettings): ApplicationSettings
	suspend fun updateApplicationSettings(applicationSettings: ApplicationSettings): ApplicationSettings
}
