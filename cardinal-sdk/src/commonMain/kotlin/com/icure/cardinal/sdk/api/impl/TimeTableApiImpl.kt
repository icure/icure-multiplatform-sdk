package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.TimeTableApi
import com.icure.cardinal.sdk.api.raw.RawTimeTableApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapTimeTableFilterOptions
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class TimeTableApiImpl(
	private val rawApi: RawTimeTableApi,
) : TimeTableApi {

	@Deprecated("Deletion without rev is unsafe", ReplaceWith("deleteTimeTableById(entityId, rev)"))
	override suspend fun deleteTimeTableUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteTimeTable(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe", ReplaceWith("deleteTimeTablesByIds(/*List of IdWithMandatoryRev*/)"))
	override suspend fun deleteTimeTablesUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteTimeTables(ListOfIds(entityIds)).successBody()

	override suspend fun deleteTimeTableById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteTimeTable(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteTimeTablesByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier> =
		rawApi.deleteTimeTablesWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeTimeTableById(id: String, rev: String) {
		rawApi.purgeTimeTable(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun modifyTimeTable(entity: TimeTable): TimeTable =
		rawApi.modifyTimeTable(entity).successBodyOrThrowRevisionConflict()


	override suspend fun undeleteTimeTableById(id: String, rev: String): TimeTable =
		rawApi.undeleteTimeTable(id, rev).successBodyOrThrowRevisionConflict()

	override suspend fun getTimeTable(entityId: String): TimeTable? =
		rawApi.getTimeTable(entityId).successBodyOrNull404()

	override suspend fun getTimeTables(timeTableIds: List<String>): List<TimeTable> =
		rawApi.getTimeTables(ListOfIds(timeTableIds)).successBody()

	@Deprecated(
		"Use the filter method instead",
		replaceWith = ReplaceWith(
			"filterTimeTablesBy(TimeTableFilters.byPeriodAndAgendaId(agendaId, startDate, endDate))",
			"com.icure.cardinal.sdk.filters.TimeTableFilters"
		)
	)
	override suspend fun getTimeTablesByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<TimeTable> =
		rawApi.getTimeTablesByPeriodAndAgendaId(startDate, endDate, agendaId).successBody()

	@Deprecated(
		"Use the filter method instead",
		replaceWith = ReplaceWith(
			"filterTimeTablesBy(TimeTableFilters.byAgendaId(agendaId))",
			"com.icure.cardinal.sdk.filters.TimeTableFilters"
		)
	)
	override suspend fun getTimeTablesByAgendaId(agendaId: String): List<TimeTable> =
		rawApi.getTimeTablesByAgendaId(agendaId).successBody()

	override suspend fun filterTimeTablesBy(filter: BaseFilterOptions<TimeTable>): PaginatedListIterator<TimeTable> =
		IdsPageIterator(matchTimeTablesBy(filter), this::getTimeTables)

	override suspend fun filterTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): PaginatedListIterator<TimeTable> =
		IdsPageIterator(matchTimeTablesBySorted(filter), this::getTimeTables)

	override suspend fun createTimeTable(entity: TimeTable): TimeTable =
		rawApi.createTimeTable(entity).successBodyOrThrowRevisionConflict()

	override suspend fun matchTimeTablesBy(filter: BaseFilterOptions<TimeTable>): List<String> =
		rawApi.matchTimeTablesBy(mapTimeTableFilterOptions(filter)).successBody()

	override suspend fun matchTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): List<String> =
		matchTimeTablesBy(filter)
}
