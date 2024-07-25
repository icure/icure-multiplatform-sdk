package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.serialization.FilterChainSerializer
import com.icure.sdk.serialization.MaintenanceTaskAbstractFilterSerializer
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
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawMaintenanceTaskApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawMaintenanceTaskApi {
	override suspend fun getAccessControlKeysHeaderValues(): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(EntityWithEncryptionMetadataTypeName.MaintenanceTask)

	// region common endpoints

	override suspend fun createMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskDto)
		}.wrap()

	override suspend fun deleteMaintenanceTasks(maintenanceTaskIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskIds)
		}.wrap()

	override suspend fun deleteMaintenanceTask(maintenanceTaskId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", maintenanceTaskId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMaintenanceTask(maintenanceTaskId: String): HttpResponse<EncryptedMaintenanceTask> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", maintenanceTaskId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getMaintenanceTasks(ids: ListOfIds): HttpResponse<List<EncryptedMaintenanceTask>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ids)
		}.wrap()

	override suspend fun modifyMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(maintenanceTaskDto)
		}.wrap()

	override suspend fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<MaintenanceTask>,
	): HttpResponse<PaginatedList<EncryptedMaintenanceTask>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(
				FilterChainSerializer(MaintenanceTaskAbstractFilterSerializer),
				filterChain,
			)
		}.wrap()

	override suspend fun matchMaintenanceTasksBy(filter: AbstractFilter<MaintenanceTask>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(MaintenanceTaskAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedMaintenanceTask>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "maintenancetask", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
