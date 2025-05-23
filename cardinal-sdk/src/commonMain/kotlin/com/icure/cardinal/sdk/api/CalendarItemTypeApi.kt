package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier

interface CalendarItemTypeApi {
	@Deprecated("Will be replaced by filters")
	suspend fun getCalendarItemTypes(startDocumentId: String? = null, limit: Int? = null): PaginatedList<CalendarItemType>

	@Deprecated("Will be replaced by filters")
	suspend fun getCalendarItemTypesIncludingDeleted(startKey: String? = null, startDocumentId: String? = null, limit: Int? = null): PaginatedList<CalendarItemType>

	suspend fun createCalendarItemType(calendarItemTypeDto: CalendarItemType): CalendarItemType

	suspend fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds): List<DocIdentifier>

	suspend fun getCalendarItemType(calendarItemTypeId: String): CalendarItemType?

	suspend fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemType): CalendarItemType

	suspend fun listCalendarItemTypesByAgendaId(agendaId: String): List<CalendarItemType>
}
