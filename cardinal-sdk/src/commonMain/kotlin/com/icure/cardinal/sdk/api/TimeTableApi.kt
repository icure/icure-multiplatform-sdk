package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface TimeTableApi {
	@Deprecated("Deletion without rev is unsafe", ReplaceWith("deleteTimeTableById(entityId, rev)"))
	suspend fun deleteTimeTableUnsafe(entityId: String): DocIdentifier

	@Deprecated("Deletion without rev is unsafe", ReplaceWith("deleteTimeTablesByIds(/*List of IdWithMandatoryRev*/)"))
	suspend fun deleteTimeTablesUnsafe(entityIds: List<String>): List<DocIdentifier>
	
	/**
	 * Deletes a timeTable. If you don't have write access to the timeTable the method will fail.
	 * @param entityId id of the timeTable.
	 * @param rev the latest known rev of the timeTable to delete
	 * @return the id and revision of the deleted timeTable.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteTimeTableById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many timeTables. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the timeTables to delete.
	 * @return the id and revision of the deleted timeTables. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteTimeTablesByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier>

	/**
	 * Permanently deletes a timeTable.
	 * @param id id of the timeTable to purge
	 * @param rev latest revision of the timeTable
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeTimeTableById(id: String, rev: String)

	/**
	 * Deletes a timeTable. If you don't have write access to the timeTable the method will fail.
	 * @param timeTable the timeTable to delete
	 * @return the id and revision of the deleted timeTable.
	 * @throws RevisionConflictException if the provided timeTable doesn't match the latest known revision
	 */
	suspend fun deleteTimeTable(timeTable: TimeTable): DocIdentifier =
		deleteTimeTableById(timeTable.id, requireNotNull(timeTable.rev) { "Can't delete a timeTable that has no rev" })

	/**
	 * Deletes many timeTables. Ignores timeTable for which you don't have write access or that don't match the latest revision.
	 * @param timeTables the timeTables to delete
	 * @return the id and revision of the deleted timeTables. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteTimeTables(timeTables: List<TimeTable>): List<DocIdentifier> =
		deleteTimeTablesByIds(timeTables.map { timeTable ->
			StoredDocumentIdentifier(timeTable.id, requireNotNull(timeTable.rev) { "Can't delete a timeTable that has no rev" })
		})

	/**
	 * Permanently deletes a timeTable.
	 * @param timeTable the timeTable to purge.
	 * @throws RevisionConflictException if the provided timeTable doesn't match the latest known revision
	 */
	suspend fun purgeTimeTable(timeTable: TimeTable) {
		purgeTimeTableById(timeTable.id, requireNotNull(timeTable.rev) { "Can't delete a timeTable that has no rev" })
	}

	/**
	 * Restores a timeTable that was marked as deleted.
	 * @param timeTable the timeTable to undelete
	 * @return the restored timeTable.
	 * @throws RevisionConflictException if the provided timeTable doesn't match the latest known revision
	 */
	suspend fun undeleteTimeTable(timeTable: TimeTable): TimeTable =
		undeleteTimeTableById(timeTable.id, requireNotNull(timeTable.rev) { "Can't delete a timeTable that has no rev" })

	/**
	 * Modifies a time-table. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a time-table with update content
	 * @return the time-table updated with the provided content and a new revision.
	 */
	suspend fun modifyTimeTable(entity: TimeTable): TimeTable

	/**
	 * Restores a timeTable that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteTimeTableById(id: String, rev: String): TimeTable

	/**
	 * Get a time-table by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a time-table, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a time-table id.
	 * @return the time-table with id [entityId].
	 */
	suspend fun getTimeTable(entityId: String): TimeTable

	/**
	 * Get multiple time tables by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a time table, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param timeTableIds a list of time table ids
	 * @return all patients that you can access with one of the provided ids.
	 */
	suspend fun getTimeTables(timeTableIds: List<String>): List<TimeTable>

	@Deprecated(
		message = "Use the filter method instead",
		ReplaceWith("filterTimeTablesBy(TimeTableFilters.byPeriodAndAgendaId(agendaId, startDate, endDate))", "com.icure.cardinal.sdk.filters.TimeTableFilters"),
	)
	suspend fun getTimeTablesByPeriodAndAgendaId(startDate: Long, endDate: Long, agendaId: String): List<TimeTable>

	@Deprecated(
		message = "Use the filter method instead",
		ReplaceWith("filterTimeTablesBy(TimeTableFilters.byAgendaId(agendaId))", "com.icure.cardinal.sdk.filters.TimeTableFilters"),
	)
	suspend fun getTimeTablesByAgendaId(agendaId: String): List<TimeTable>

	/**
	 * Get an iterator that iterates through all timeTables matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterTimeTablesBySorted] instead.
	 *
	 * @param filter a timeTable filter
	 * @return an iterator that iterates over all timeTables matching the provided filter.
	 */
	suspend fun filterTimeTablesBy(
		filter: BaseFilterOptions<TimeTable>
	): PaginatedListIterator<TimeTable>

	/**
	 * Get an iterator that iterates through all timeTables matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterTimeTablesBy].
	 *
	 * @param filter a timeTable filter
	 * @return an iterator that iterates over all timeTables matching the provided filter.
	 */
	suspend fun filterTimeTablesBySorted(
		filter: BaseSortableFilterOptions<TimeTable>
	): PaginatedListIterator<TimeTable>

	/**
	 * Create a new time-table.
	 * @param entity a time-table.
	 * @return the created time-table with updated revision.
	 */
	suspend fun createTimeTable(entity: TimeTable): TimeTable

	/**
	 * Get the ids of all timeTables matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchTimeTablesBySorted] instead.
	 *
	 * @param filter a timeTable filter
	 * @return a list of timeTable ids
	 */
	suspend fun matchTimeTablesBy(filter: BaseFilterOptions<TimeTable>): List<String>

	/**
	 * Get the ids of all timeTables matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchTimeTablesBy].
	 *
	 * @param filter a timeTable filter
	 * @return a list of timeTable ids
	 */
	suspend fun matchTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): List<String>
}
