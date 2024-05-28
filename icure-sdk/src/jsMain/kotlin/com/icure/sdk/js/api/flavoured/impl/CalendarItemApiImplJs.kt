// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.CalendarItemApi
import com.icure.sdk.js.api.flavoured.CalendarItemApiJs
import com.icure.sdk.js.api.flavoured.CalendarItemFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CalendarItemJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.DecryptedCalendarItemJs
import com.icure.sdk.js.model.EncryptedCalendarItemJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.calendarItem_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.DecryptedCalendarItem
import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class CalendarItemApiImplJs(
	private val calendarItemApi: CalendarItemApi,
) : CalendarItemApiJs {
	override val encrypted: CalendarItemFlavouredApiJs<EncryptedCalendarItemJs> = object :
			CalendarItemFlavouredApiJs<EncryptedCalendarItemJs> {
		override fun shareWith(
			delegateId: String,
			calendarItem: EncryptedCalendarItemJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				calendarItemApi.encrypted.shareWith(delegateId,
						com.icure.sdk.js.model.calendarItem_fromJs(calendarItem),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun findCalendarItemsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				calendarItemApi.encrypted.findCalendarItemsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
				= GlobalScope.promise {
			calendarItem_toJs(calendarItemApi.encrypted.modifyCalendarItem(com.icure.sdk.js.model.calendarItem_fromJs(entity)))}


		override fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs> =
				GlobalScope.promise {
			calendarItem_toJs(calendarItemApi.encrypted.getCalendarItem(entityId))}


		override fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>> =
				GlobalScope.promise {
			listToArray(
				calendarItemApi.encrypted.getCalendarItems(arrayToList(
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
				calendarItemApi.encrypted.getCalendarItemsByPeriodAndHcPartyId(numberToLong(startDate,
						"startDate"), numberToLong(endDate, "endDate"), hcPartyId),
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
				calendarItemApi.encrypted.getCalendarsByPeriodAndAgendaId(numberToLong(startDate, "startDate"),
						numberToLong(endDate, "endDate"), agendaId),
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun getCalendarItemsWithIds(entityIds: Array<String>):
				Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
			listToArray(
				calendarItemApi.encrypted.getCalendarItemsWithIds(arrayToList(
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
				calendarItemApi.encrypted.findCalendarItemsByRecurrenceId(recurrenceId, startKey,
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)}

	}

	override val tryAndRecover: CalendarItemFlavouredApiJs<CalendarItemJs> = object :
			CalendarItemFlavouredApiJs<CalendarItemJs> {
		override fun shareWith(
			delegateId: String,
			calendarItem: CalendarItemJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<CalendarItemJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				calendarItemApi.tryAndRecover.shareWith(delegateId,
						com.icure.sdk.js.model.calendarItem_fromJs(calendarItem),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun findCalendarItemsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<CalendarItemJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				calendarItemApi.tryAndRecover.findCalendarItemsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun modifyCalendarItem(entity: CalendarItemJs): Promise<CalendarItemJs> =
				GlobalScope.promise {
			calendarItem_toJs(calendarItemApi.tryAndRecover.modifyCalendarItem(com.icure.sdk.js.model.calendarItem_fromJs(entity)))}


		override fun getCalendarItem(entityId: String): Promise<CalendarItemJs> = GlobalScope.promise {
			calendarItem_toJs(calendarItemApi.tryAndRecover.getCalendarItem(entityId))}


		override fun getCalendarItems(entityIds: Array<String>): Promise<Array<CalendarItemJs>> =
				GlobalScope.promise {
			listToArray(
				calendarItemApi.tryAndRecover.getCalendarItems(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun getCalendarItemsByPeriodAndHcPartyId(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
		): Promise<Array<CalendarItemJs>> = GlobalScope.promise {
			listToArray(
				calendarItemApi.tryAndRecover.getCalendarItemsByPeriodAndHcPartyId(numberToLong(startDate,
						"startDate"), numberToLong(endDate, "endDate"), hcPartyId),
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun getCalendarsByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<CalendarItemJs>> = GlobalScope.promise {
			listToArray(
				calendarItemApi.tryAndRecover.getCalendarsByPeriodAndAgendaId(numberToLong(startDate,
						"startDate"), numberToLong(endDate, "endDate"), agendaId),
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun getCalendarItemsWithIds(entityIds: Array<String>): Promise<Array<CalendarItemJs>> =
				GlobalScope.promise {
			listToArray(
				calendarItemApi.tryAndRecover.getCalendarItemsWithIds(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)}


		override fun findCalendarItemsByRecurrenceId(
			recurrenceId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double,
		): Promise<PaginatedListJs<CalendarItemJs>> = GlobalScope.promise {
			paginatedList_toJs(
				calendarItemApi.tryAndRecover.findCalendarItemsByRecurrenceId(recurrenceId, startKey,
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)}

	}

	override fun createCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>
			= GlobalScope.promise {
		calendarItem_toJs(calendarItemApi.createCalendarItem(com.icure.sdk.js.model.calendarItem_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedCalendarItemJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedCalendarItemJs> = GlobalScope.promise {
		calendarItem_toJs(calendarItemApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.calendarItem_fromJs(nonNull1)
		}, com.icure.sdk.js.model.patient_fromJs(patient), user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.js.model.embed.accessLevel_fromJs(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun deleteCalendarItem(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(calendarItemApi.deleteCalendarItem(entityId))}


	override fun deleteCalendarItems(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			calendarItemApi.deleteCalendarItems(arrayToList(
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


	override fun shareWith(
		delegateId: String,
		calendarItem: DecryptedCalendarItemJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			calendarItemApi.shareWith(delegateId, com.icure.sdk.js.model.calendarItem_fromJs(calendarItem),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			calendarItemApi.findCalendarItemsByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun modifyCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>
			= GlobalScope.promise {
		calendarItem_toJs(calendarItemApi.modifyCalendarItem(com.icure.sdk.js.model.calendarItem_fromJs(entity)))}


	override fun getCalendarItem(entityId: String): Promise<DecryptedCalendarItemJs> =
			GlobalScope.promise {
		calendarItem_toJs(calendarItemApi.getCalendarItem(entityId))}


	override fun getCalendarItems(entityIds: Array<String>): Promise<Array<DecryptedCalendarItemJs>> =
			GlobalScope.promise {
		listToArray(
			calendarItemApi.getCalendarItems(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		listToArray(
			calendarItemApi.getCalendarItemsByPeriodAndHcPartyId(numberToLong(startDate, "startDate"),
					numberToLong(endDate, "endDate"), hcPartyId),
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		listToArray(
			calendarItemApi.getCalendarsByPeriodAndAgendaId(numberToLong(startDate, "startDate"),
					numberToLong(endDate, "endDate"), agendaId),
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun getCalendarItemsWithIds(entityIds: Array<String>):
			Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		listToArray(
			calendarItemApi.getCalendarItemsWithIds(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}


	override fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		paginatedList_toJs(
			calendarItemApi.findCalendarItemsByRecurrenceId(recurrenceId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)}

}
