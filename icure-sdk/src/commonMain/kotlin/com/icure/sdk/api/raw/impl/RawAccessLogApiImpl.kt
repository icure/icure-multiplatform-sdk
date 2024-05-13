package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawAccessLogApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawAccessLogApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawAccessLogApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.AccessLog)

	// region common endpoints

	override suspend fun createAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(accessLogDto)
		}.wrap()

	override suspend fun deleteAccessLogs(accessLogIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(accessLogIds)
		}.wrap()

	override suspend fun deleteAccessLog(accessLogId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", accessLogId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getAccessLog(accessLogId: String): HttpResponse<EncryptedAccessLog> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", accessLogId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): HttpResponse<PaginatedList<EncryptedAccessLog>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog")
				parameter("fromEpoch", fromEpoch)
				parameter("toEpoch", toEpoch)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("descending", descending)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): HttpResponse<PaginatedList<EncryptedAccessLog>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "byUser")
				parameter("userId", userId)
				parameter("accessType", accessType)
				parameter("startDate", startDate)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("descending", descending)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listAccessLogsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedAccessLog>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listAccessLogIdsByDataOwnerPatientDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "byDataOwnerPatientDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findAccessLogsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedAccessLog>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun modifyAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(accessLogDto)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedAccessLog>>> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedAccessLog>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId)
				parameter("fromEpoch", fromEpoch)
				parameter("toEpoch", toEpoch)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion
}
