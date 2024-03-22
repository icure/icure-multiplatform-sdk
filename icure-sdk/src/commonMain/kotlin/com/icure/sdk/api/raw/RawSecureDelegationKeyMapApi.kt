package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedSecureDelegationKeyMap
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.SecureDelegationKeyMap
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawSecureDelegationKeyMapApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun createSecureDelegationKeyMap(secureDelegationKeyMap: SecureDelegationKeyMap):
			HttpResponse<EncryptedSecureDelegationKeyMap> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","securedelegationkeymap")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secureDelegationKeyMap)
		}.wrap()


	suspend fun findByDelegationKeys(delegationKeys: ListOfIds):
			HttpResponse<List<EncryptedSecureDelegationKeyMap>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","securedelegationkeymap","bydelegationkeys")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(delegationKeys)
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedSecureDelegationKeyMap>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","securedelegationkeymap","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}
