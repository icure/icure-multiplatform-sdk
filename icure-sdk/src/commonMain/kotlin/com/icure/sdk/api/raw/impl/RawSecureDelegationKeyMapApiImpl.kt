package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawSecureDelegationKeyMapApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.`header`
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawSecureDelegationKeyMapApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawSecureDelegationKeyMapApi {
	// region common endpoints

	override suspend fun createSecureDelegationKeyMap(
		secureDelegationKeyMap: EncryptedSecureDelegationKeyMap,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<EncryptedSecureDelegationKeyMap> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "securedelegationkeymap")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(secureDelegationKeyMap)
			accessControlKeysHeaderValues.forEach {
				header(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	override suspend fun findByDelegationKeys(
		delegationKeys: ListOfIds,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EncryptedSecureDelegationKeyMap>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "securedelegationkeymap", "bydelegationkeys")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(delegationKeys)
			accessControlKeysHeaderValues.forEach {
				header(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EntityBulkShareResult<EncryptedSecureDelegationKeyMap>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "securedelegationkeymap", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			accept(ContentType.Application.Json)
			setBody(request)
			accessControlKeysHeaderValues.forEach {
				header(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	// endregion
}
