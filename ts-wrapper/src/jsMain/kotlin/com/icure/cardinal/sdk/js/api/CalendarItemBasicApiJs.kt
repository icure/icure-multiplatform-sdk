// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemBasicApi")
public external interface CalendarItemBasicApiJs {
	public fun matchCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>>

	public fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>>

	public fun filterCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>>

	public fun filterCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>>

	public fun deleteCalendarItemUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteCalendarItemsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteCalendarItemById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteCalendarItemsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeCalendarItemById(id: String, rev: String): Promise<Unit>

	public fun deleteCalendarItem(calendarItem: CalendarItemJs): Promise<DocIdentifierJs>

	public fun deleteCalendarItems(calendarItems: Array<CalendarItemJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeCalendarItem(calendarItem: CalendarItemJs): Promise<Unit>

	public fun undeleteCalendarItemById(id: String, rev: String): Promise<EncryptedCalendarItemJs>

	public fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<EncryptedCalendarItemJs>

	public fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>

	public fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs>

	public fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>>

	public fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<EncryptedCalendarItemJs>>

	public fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedCalendarItemJs>>

	public fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<EncryptedCalendarItemJs>>
}
