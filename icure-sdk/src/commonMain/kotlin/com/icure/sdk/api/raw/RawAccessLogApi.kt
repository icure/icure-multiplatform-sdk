package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAccessLogApi {
	// region common endpoints

	suspend fun createAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog>

	suspend fun deleteAccessLogs(accessLogIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAccessLog(accessLogId: String): HttpResponse<DocIdentifier>

	suspend fun getAccessLog(accessLogId: String): HttpResponse<EncryptedAccessLog>

	suspend fun findAccessLogsBy(
		fromEpoch: Long? = null,
		toEpoch: Long? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		descending: Boolean? = null,
	): HttpResponse<PaginatedList<EncryptedAccessLog>>

	suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String? = null,
		startDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		descending: Boolean? = null,
	): HttpResponse<PaginatedList<EncryptedAccessLog>>

	suspend fun listAccessLogsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedAccessLog>>

	suspend fun listAccessLogIdsByDataOwnerPatientDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun getAccessLogByIds(accessLogIds: ListOfIds): HttpResponse<List<EncryptedAccessLog>>

	suspend fun findAccessLogsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedAccessLog>>

	suspend fun modifyAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedAccessLog>>>
	// endregion

	// region cloud endpoints

	suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long? = null,
		toEpoch: Long? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedAccessLog>>
	// endregion
}
