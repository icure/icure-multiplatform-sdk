package com.icure.sdk.api

import com.icure.sdk.api.raw.RawApplicationSettingsApi
import com.icure.sdk.model.ApplicationSettings
import com.icure.sdk.utils.InternalIcureApi

interface ApplicationSettingsApi {
	suspend fun getApplicationSettings(): List<ApplicationSettings>
	suspend fun createApplicationSettings(applicationSettings: ApplicationSettings): ApplicationSettings
	suspend fun updateApplicationSettings(applicationSettings: ApplicationSettings): ApplicationSettings
}

@InternalIcureApi
internal class ApplicationSettingsApiImpl(
	private val rawApi: RawApplicationSettingsApi,
) : ApplicationSettingsApi {
	override suspend fun getApplicationSettings() = rawApi.getApplicationSettings().successBody()

	override suspend fun createApplicationSettings(applicationSettings: ApplicationSettings) =
		rawApi.createApplicationSettings(applicationSettings).successBody()

	override suspend fun updateApplicationSettings(applicationSettings: ApplicationSettings) =
		rawApi.updateApplicationSettings(applicationSettings).successBody()
}

