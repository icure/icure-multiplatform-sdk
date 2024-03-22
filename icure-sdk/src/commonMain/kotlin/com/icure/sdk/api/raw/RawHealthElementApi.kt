package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.EncryptedIcureStub
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.delete
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawHealthElementApi(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun createHealthElement(c: HealthElement): HttpResponse<EncryptedHealthElement> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(c)
		}.wrap()


	suspend fun getHealthElement(healthElementId: String): HttpResponse<EncryptedHealthElement>
			= httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement",healthElementId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getHealthElements(healthElementIds: ListOfIds):
			HttpResponse<List<EncryptedHealthElement>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementIds)
		}.wrap()


	suspend fun listHealthElementsByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretFKeys: String): HttpResponse<List<EncryptedHealthElement>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findHealthElementsByHCPartyPatientForeignKey(
		hcPartyId: String,
		secretFKey: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedHealthElement, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","byHcPartySecretForeignKey")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKey", secretFKey)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findHealthElementsByHCPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: List<String>): HttpResponse<List<EncryptedHealthElement>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	public suspend
			fun listHealthElementsDelegationsStubsByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretFKeys: String): HttpResponse<List<EncryptedIcureStub>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","byHcPartySecretForeignKeys","delegations")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: List<String>): HttpResponse<List<EncryptedIcureStub>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","byHcPartySecretForeignKeys","delegations")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()


	suspend fun deleteHealthElements(healthElementIds: ListOfIds):
			HttpResponse<List<DocIdentifier>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementIds)
		}.wrap()


	suspend fun deleteHealthElement(healthElementId: String): HttpResponse<DocIdentifier> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement",healthElementId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyHealthElement(healthElementDto: HealthElement):
			HttpResponse<EncryptedHealthElement> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementDto)
		}.wrap()


	suspend fun modifyHealthElements(healthElementDtos: List<HealthElement>):
			HttpResponse<List<EncryptedHealthElement>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementDtos)
		}.wrap()


	suspend fun createHealthElements(healthElementDtos: List<HealthElement>):
			HttpResponse<List<EncryptedHealthElement>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(healthElementDtos)
		}.wrap()


	suspend fun filterHealthElementsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<HealthElement>,
	): HttpResponse<PaginatedList<EncryptedHealthElement, *>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>):
			HttpResponse<List<String>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()


	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","helement","bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}
