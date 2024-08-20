// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedCalendarItemJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemBasicApi")
public external interface CalendarItemBasicApiJs {
	public fun deleteCalendarItem(entityId: String): Promise<DocIdentifierJs>

	public fun deleteCalendarItems(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

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
