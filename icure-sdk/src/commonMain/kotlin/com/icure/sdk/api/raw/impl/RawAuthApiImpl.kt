package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawAuthApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.String
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawAuthApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawAuthApi {
	// region common endpoints

	override suspend fun token(
		method: String,
		path: String,
	): HttpResponse<String> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "auth", "token", method, path)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
