package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawDataOwnerApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
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
class RawDataOwnerApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawDataOwnerApi {
	// region common endpoints

	override suspend fun getDataOwner(dataOwnerId: String): HttpResponse<DataOwnerWithType> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", dataOwnerId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getDataOwnerStub(dataOwnerId: String): HttpResponse<CryptoActorStubWithType> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "stub", dataOwnerId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyDataOwnerStub(updated: CryptoActorStubWithType): HttpResponse<CryptoActorStubWithType> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "stub")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(updated)
		}.wrap()

	override suspend fun getCurrentDataOwner(): HttpResponse<DataOwnerWithType> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "dataowner", "current")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion
}
