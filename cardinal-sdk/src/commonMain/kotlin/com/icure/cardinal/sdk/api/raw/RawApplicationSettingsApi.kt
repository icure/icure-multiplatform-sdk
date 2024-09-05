package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ApplicationSettings
import com.icure.utils.InternalIcureApi
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawApplicationSettingsApi {
	// region common endpoints

	suspend fun getApplicationSettings(): HttpResponse<List<ApplicationSettings>>

	suspend fun createApplicationSettings(applicationSettingsDto: ApplicationSettings): HttpResponse<ApplicationSettings>

	suspend fun updateApplicationSettings(applicationSettingsDto: ApplicationSettings): HttpResponse<ApplicationSettings>
	// endregion
}
