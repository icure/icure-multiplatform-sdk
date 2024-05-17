package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawMaintenanceTaskApi {
	// region common endpoints

	suspend fun createMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask>

	suspend fun deleteMaintenanceTasks(maintenanceTaskIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteMaintenanceTask(maintenanceTaskId: String): HttpResponse<DocIdentifier>

	suspend fun getMaintenanceTask(maintenanceTaskId: String): HttpResponse<EncryptedMaintenanceTask>

	suspend fun modifyMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask>

	suspend fun filterMaintenanceTasksBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<EncryptedMaintenanceTask>,
	): HttpResponse<PaginatedList<EncryptedMaintenanceTask>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedMaintenanceTask>>>
	// endregion
}
