package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.serialization.HealthElementAbstractFilterSerializer
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawHealthElementApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawHealthElementApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.HealthElement)

	// region common endpoints

	override suspend fun createHealthElement(c: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(c)
		}.wrap()

	override suspend fun getHealthElement(healthElementId: String): HttpResponse<EncryptedHealthElement> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", healthElementId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun getHealthElements(healthElementIds: ListOfIds): HttpResponse<List<EncryptedHealthElement>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byIds")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun listHealthElementsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedHealthElement>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun listHealthElementIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byDataOwnerPatientOpeningDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findHealthElementsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedHealthElement>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun listHealthElementsDelegationsStubsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<IcureStub>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun deleteHealthElements(healthElementIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementIds)
		}.wrap()

	override suspend fun deleteHealthElement(healthElementId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", healthElementId)
			}
			setAuthorizationWith(authService)
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyHealthElement(healthElementDto: EncryptedHealthElement): HttpResponse<EncryptedHealthElement> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDto)
		}.wrap()

	override suspend fun modifyHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun createHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "batch")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(healthElementDtos)
		}.wrap()

	override suspend fun filterHealthElementsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<HealthElement>,
	): HttpResponse<PaginatedList<EncryptedHealthElement>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "match")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(HealthElementAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "helement", "bulkSharedMetadataUpdateMinimal")
			}
			setAuthorizationWith(authService)
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
