package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawApplicationSettingsApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.ApplicationSettings
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawApplicationSettingsApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawApplicationSettingsApi {
	// region common endpoints

	override suspend fun getApplicationSettings(): HttpResponse<List<ApplicationSettings>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "appsettings")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createApplicationSettings(applicationSettingsDto: ApplicationSettings): HttpResponse<ApplicationSettings> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "appsettings")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(applicationSettingsDto)
		}.wrap()

	override suspend fun updateApplicationSettings(applicationSettingsDto: ApplicationSettings): HttpResponse<ApplicationSettings> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "appsettings")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(applicationSettingsDto)
		}.wrap()

	// endregion
}
