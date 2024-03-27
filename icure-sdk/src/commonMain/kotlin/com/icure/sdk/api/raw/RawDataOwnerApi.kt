package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.String
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawDataOwnerApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
	// region common endpoints

	suspend fun getDataOwner(dataOwnerId: String): HttpResponse<DataOwnerWithType> =
		get {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "dataowner", dataOwnerId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getDataOwnerStub(dataOwnerId: String): HttpResponse<CryptoActorStubWithType> =
		get {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "dataowner", "stub", dataOwnerId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun modifyDataOwnerStub(updated: CryptoActorStubWithType): HttpResponse<CryptoActorStubWithType> =
		put {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "dataowner", "stub")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(updated)
		}.wrap()

	suspend fun getCurrentDataOwner(): HttpResponse<DataOwnerWithType> =
		get {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "dataowner", "current")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion
}
