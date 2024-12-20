package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.ApplicationSettingsApi
import com.icure.cardinal.sdk.api.raw.RawApplicationSettingsApi
import com.icure.cardinal.sdk.model.ApplicationSettings
import com.icure.utils.InternalIcureApi

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