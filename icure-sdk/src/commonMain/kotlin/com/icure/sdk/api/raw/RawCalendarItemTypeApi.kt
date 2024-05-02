package com.icure.sdk.api.raw

import com.icure.sdk.model.CalendarItemType
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawCalendarItemTypeApi {
	// region common endpoints

	suspend fun getCalendarItemTypes(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<CalendarItemType>>

	suspend fun getCalendarItemTypesIncludingDeleted(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<CalendarItemType>>

	suspend fun createCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType>

	suspend fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun getCalendarItemType(calendarItemTypeId: String): HttpResponse<CalendarItemType>

	suspend fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType>
	// endregion
}
