// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.CalendarItemBasicApi
import com.icure.sdk.js.api.flavoured.CalendarItemBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.EncryptedCalendarItemJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.calendarItem_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

@OptIn(DelicateCoroutinesApi::class)
public class CalendarItemBasicApiImplJs private constructor(
	private val calendarItemBasicApi: CalendarItemBasicApi,
) : CalendarItemBasicApiJs {
	override fun deleteCalendarItem(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(calendarItemBasicApi.deleteCalendarItem(entityId))}


	override fun deleteCalendarItems(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			calendarItemBasicApi.deleteCalendarItems(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
			= GlobalScope.promise {
		calendarItem_toJs(calendarItemBasicApi.modifyCalendarItem(com.icure.sdk.js.model.calendarItem_fromJs(entity)))}


	override fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs> =
			GlobalScope.promise {
		calendarItem_toJs(calendarItemBasicApi.getCalendarItem(entityId))}


	override fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>> =
			GlobalScope.promise {
		listToArray(
			calendarItemBasicApi.getCalendarItems(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		listToArray(
			calendarItemBasicApi.getCalendarItemsByPeriodAndHcPartyId(numberToLong(startDate, "startDate"),
					numberToLong(endDate, "endDate"), hcPartyId),
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		listToArray(
			calendarItemBasicApi.getCalendarsByPeriodAndAgendaId(numberToLong(startDate, "startDate"),
					numberToLong(endDate, "endDate"), agendaId),
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun getCalendarItemsWithIds(entityIds: Array<String>):
			Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
		listToArray(
			calendarItemBasicApi.getCalendarItemsWithIds(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
		paginatedList_toJs(
			calendarItemBasicApi.findCalendarItemsByRecurrenceId(recurrenceId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}

}
