// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.CalendarItemTypeJs
import com.icure.cardinal.sdk.js.model.ListOfIdsJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemTypeApi")
public external interface CalendarItemTypeApiJs {
	public fun getCalendarItemTypes(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<CalendarItemTypeJs>>

	public fun getCalendarItemTypesIncludingDeleted(
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<CalendarItemTypeJs>>

	public fun createCalendarItemType(calendarItemTypeDto: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs>

	public fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIdsJs):
			Promise<Array<DocIdentifierJs>>

	public fun getCalendarItemType(calendarItemTypeId: String): Promise<CalendarItemTypeJs>

	public fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs>

	public fun listCalendarItemTypesByAgendaId(agendaId: String): Promise<Array<CalendarItemTypeJs>>
}
