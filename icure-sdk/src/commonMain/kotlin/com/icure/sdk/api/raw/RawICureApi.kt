package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.IndexingInfo
import com.icure.sdk.model.ReplicationInfo
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration
import com.icure.sdk.model.couchdb.ReplicatorDocument
import io.ktor.client.request.delete

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawICureApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getVersion(): HttpResponse<String> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","v")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun isReady(): HttpResponse<String> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","ok")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getProcessInfo(): HttpResponse<String> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","p")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getIndexingInfo(): HttpResponse<IndexingInfo> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","i")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getReplicationInfo(): HttpResponse<ReplicationInfo> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","r")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun updateDesignDoc(entityName: String, warmup: Boolean? = null):
			HttpResponse<Boolean> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","dd",entityName)
				parameter("warmup", warmup)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resolvePatientsConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","conflicts","patient")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resolveContactsConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","conflicts","contact")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resolveFormsConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","conflicts","form")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resolveHealthElementsConflicts(limit: Int? = null):
			HttpResponse<List<IdWithRev>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","conflicts","healthelement")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resolveInvoicesConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","conflicts","invoice")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resolveMessagesConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","conflicts","message")
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resolveDocumentsConflicts(ids: String? = null, limit: Int? = null):
			HttpResponse<List<IdWithRev>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","conflicts","document")
				parameter("ids", ids)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	// endregion

	// region cloud endpoints

	suspend fun getIndexingInfoByGroup(groupId: String): HttpResponse<IndexingInfo> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","byGroup",groupId,"i")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getReplicatorInfo(id: String): HttpResponse<ReplicatorDocument> =
			httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","r",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun evictAllFromMap(mapName: String): HttpResponse<String> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","icure","hzc",mapName)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion

}
