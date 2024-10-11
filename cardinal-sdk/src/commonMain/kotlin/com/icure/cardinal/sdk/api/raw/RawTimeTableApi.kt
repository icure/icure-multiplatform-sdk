package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawTimeTableApi {
	// region common endpoints

	suspend fun createTimeTable(timeTableDto: EncryptedTimeTable): HttpResponse<EncryptedTimeTable>

	suspend fun deleteTimeTables(timeTableIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteTimeTablesWithRev(timeTableIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteTimeTable(
		timeTableId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteTimeTable(
		timeTableId: String,
		rev: String,
	): HttpResponse<EncryptedTimeTable>

	suspend fun purgeTimeTable(
		timeTableId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun getTimeTable(timeTableId: String): HttpResponse<EncryptedTimeTable>

	suspend fun getTimeTables(timeTableIds: ListOfIds): HttpResponse<List<EncryptedTimeTable>>

	suspend fun modifyTimeTable(timeTableDto: EncryptedTimeTable): HttpResponse<EncryptedTimeTable>

	suspend fun getTimeTablesByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedTimeTable>>

	suspend fun getTimeTablesByAgendaId(agendaId: String): HttpResponse<List<EncryptedTimeTable>>

	suspend fun matchTimeTablesBy(filter: AbstractFilter<TimeTable>): HttpResponse<List<String>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedTimeTable>>>
	// endregion
}
