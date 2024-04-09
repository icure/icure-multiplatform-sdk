package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.`header`
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawSecureDelegationKeyMapApi(
	private val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout) {
	// region common endpoints

	public suspend fun createSecureDelegationKeyMap(
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
			setBody(secureDelegationKeyMap)
			accessControlKeysHeaderValues.forEach {
				header(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	suspend fun findByDelegationKeys(
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
			setBody(delegationKeys)
			accessControlKeysHeaderValues.forEach {
				header(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	suspend fun bulkShare(
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
			setBody(request)
			accessControlKeysHeaderValues.forEach {
				header(ACCESS_CONTROL_KEYS_HEADER, it)
			}
		}.wrap()

	// endregion
}
