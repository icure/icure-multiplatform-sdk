package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawSecureDelegationKeyMapApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.`header`
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
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
	private val authProvider: AuthProvider,
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
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "securedelegationkeymap")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secureDelegationKeyMap)
			accessControlKeysHeaderValues.forEach {
				`header`(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	override suspend fun findByDelegationKeys(
		delegationKeys: ListOfIds,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EncryptedSecureDelegationKeyMap>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "securedelegationkeymap", "bydelegationkeys")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(delegationKeys)
			accessControlKeysHeaderValues.forEach {
				`header`(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		accessControlKeysHeaderValues: List<String>,
	): HttpResponse<List<EntityBulkShareResult<EncryptedSecureDelegationKeyMap>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "securedelegationkeymap", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
			accessControlKeysHeaderValues.forEach {
				`header`(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	// endregion
}
