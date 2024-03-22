package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.ApplicationSettings
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawApplicationSettingsApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getApplicationSettings(): HttpResponse<List<ApplicationSettings>> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","appsettings")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createApplicationSettings(applicationSettingsDto: ApplicationSettings):
			HttpResponse<ApplicationSettings> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","appsettings")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(applicationSettingsDto)
		}.wrap()


	suspend fun updateApplicationSettings(applicationSettingsDto: ApplicationSettings):
			HttpResponse<ApplicationSettings> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","appsettings")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(applicationSettingsDto)
		}.wrap()

	// endregion

}