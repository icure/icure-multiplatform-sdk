package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.CalendarItemTypeApi
import com.icure.cardinal.sdk.api.raw.RawCalendarItemTypeApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class CalendarItemTypeApiImpl(
	private val rawCalendarItemTypeApi: RawCalendarItemTypeApi,
): CalendarItemTypeApi {
	override suspend fun getCalendarItemTypes(startDocumentId: String?, limit: Int?): PaginatedList<CalendarItemType> =
		rawCalendarItemTypeApi.getCalendarItemTypes(startDocumentId, limit).successBody()

	override suspend fun getCalendarItemTypesIncludingDeleted(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<CalendarItemType> = rawCalendarItemTypeApi.getCalendarItemTypesIncludingDeleted(startKey, startDocumentId, limit).successBody()

	override suspend fun createCalendarItemType(calendarItemTypeDto: CalendarItemType): CalendarItemType =
		rawCalendarItemTypeApi.createCalendarItemType(calendarItemTypeDto).successBodyOrThrowRevisionConflict()

	override suspend fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds): List<DocIdentifier> =
		rawCalendarItemTypeApi.deleteCalendarItemTypes(calendarItemTypeIds).successBody()

	override suspend fun getCalendarItemType(calendarItemTypeId: String): CalendarItemType? =
		rawCalendarItemTypeApi.getCalendarItemType(calendarItemTypeId).successBodyOrNull404()

	override suspend fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemType): CalendarItemType =
		rawCalendarItemTypeApi.modifyCalendarItemType(calendarItemTypeDto).successBodyOrThrowRevisionConflict()
}
