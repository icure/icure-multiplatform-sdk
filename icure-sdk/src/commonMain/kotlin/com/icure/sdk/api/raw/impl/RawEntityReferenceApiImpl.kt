package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawEntityReferenceApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EntityReference
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.String
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawEntityReferenceApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawEntityReferenceApi {
	// region common endpoints

	override suspend fun getLatest(prefix: String): HttpResponse<EntityReference> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entityref", "latest", prefix)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun createEntityReference(er: EntityReference): HttpResponse<EntityReference> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "entityref")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(er)
		}.wrap()

	// endregion
}
