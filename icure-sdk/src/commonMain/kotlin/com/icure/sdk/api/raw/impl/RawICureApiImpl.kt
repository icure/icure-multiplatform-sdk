package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawICureApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.IndexingInfo
import com.icure.sdk.model.ReplicationInfo
import com.icure.sdk.model.couchdb.ReplicatorDocument
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawICureApiImpl(
	internal val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawICureApi {
	// region common endpoints

	override suspend fun getVersion(): HttpResponse<String> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "v")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun isReady(): HttpResponse<String> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "ok")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getProcessInfo(): HttpResponse<String> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "p")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getIndexingInfo(): HttpResponse<IndexingInfo> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "i")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getReplicationInfo(): HttpResponse<ReplicationInfo> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "r")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun updateDesignDoc(
		entityName: String,
		warmup: Boolean?,
	): HttpResponse<Boolean> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "dd", entityName)
				parameter("warmup", warmup)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun resolvePatientsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "patient")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun resolveContactsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "contact")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun resolveFormsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "form")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun resolveHealthElementsConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "healthelement")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun resolveInvoicesConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "invoice")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun resolveMessagesConflicts(limit: Int?): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "message")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun resolveDocumentsConflicts(
		ids: String?,
		limit: Int?,
	): HttpResponse<List<IdWithRev>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "conflicts", "document")
				parameter("ids", ids)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getIndexingInfoByGroup(groupId: String): HttpResponse<IndexingInfo> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "byGroup", groupId, "i")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getReplicatorInfo(id: String): HttpResponse<ReplicatorDocument> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "r", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun evictAllFromMap(mapName: String): HttpResponse<String> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "icure", "hzc", mapName)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion
}
