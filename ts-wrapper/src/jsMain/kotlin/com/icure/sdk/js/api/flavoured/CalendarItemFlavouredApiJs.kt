// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.CalendarItemShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.CalendarItemJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemFlavouredApi")
public external interface CalendarItemFlavouredApiJs<E : CalendarItemJs> {
	public fun shareWith(
		delegateId: String,
		calendarItem: E,
		options: CalendarItemFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(calendarItem: E,
			delegates: Record<String, CalendarItemShareOptionsJs>): Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(calendarItem: E, delegates: Record<String, CalendarItemShareOptionsJs>):
			Promise<E>

	public fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: CalendarItemFlavouredApi_findCalendarItemsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun linkToPatient(
		calendarItem: CalendarItemJs,
		patient: PatientJs,
		shareLinkWithDelegates: Array<String>,
	): Promise<E>

	public fun modifyCalendarItem(entity: E): Promise<E>

	public fun getCalendarItem(entityId: String): Promise<E>

	public fun getCalendarItems(entityIds: Array<String>): Promise<Array<E>>

	public fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<E>>

	public fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<E>>

	public fun getCalendarItemsWithIds(entityIds: Array<String>): Promise<Array<E>>

	public fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<E>>
}

public external interface CalendarItemFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface CalendarItemFlavouredApi_findCalendarItemsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}
