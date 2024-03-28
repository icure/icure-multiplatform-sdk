package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.parameter
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
class RawMaintenanceTaskApi(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.MaintenanceTask)

	// region common endpoints

	suspend fun createMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask> =
		post {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "maintenancetask")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(maintenanceTaskDto)
		}.wrap()

	suspend fun deleteMaintenanceTasks(maintenanceTaskIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "maintenancetask", "delete", "batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(maintenanceTaskIds)
		}.wrap()

	suspend fun deleteMaintenanceTask(maintenanceTaskId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "maintenancetask", maintenanceTaskId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun getMaintenanceTask(maintenanceTaskId: String): HttpResponse<EncryptedMaintenanceTask> =
		get {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "maintenancetask", maintenanceTaskId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	suspend fun modifyMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask> =
		put {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "maintenancetask")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(maintenanceTaskDto)
		}.wrap()

	suspend fun filterMaintenanceTasksBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<EncryptedMaintenanceTask>,
	): HttpResponse<PaginatedList<EncryptedMaintenanceTask, *>> =
		post {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "maintenancetask", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedMaintenanceTask>>> =
		put {
			url {
				host = apiUrl
				appendPathSegments("rest", "v2", "maintenancetask", "bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
