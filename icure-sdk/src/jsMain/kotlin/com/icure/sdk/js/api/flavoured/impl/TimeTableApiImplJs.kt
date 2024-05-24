// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.TimeTableApi
import com.icure.sdk.js.api.flavoured.TimeTableApiJs
import com.icure.sdk.js.api.flavoured.TimeTableFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.DecryptedTimeTableJs
import com.icure.sdk.js.model.EncryptedTimeTableJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TimeTableJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.timeTable_toJs
import com.icure.sdk.model.DecryptedTimeTable
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class TimeTableApiImplJs(
	private val timeTableApi: TimeTableApi,
) : TimeTableApiJs {
	override val encrypted: TimeTableFlavouredApiJs<EncryptedTimeTableJs> = object :
			TimeTableFlavouredApiJs<EncryptedTimeTableJs> {
		override fun shareWith(
			delegateId: String,
			timeTable: EncryptedTimeTableJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedTimeTableJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				timeTableApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.timeTable_fromJs(timeTable),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedTimeTable ->
					timeTable_toJs(x1)
				},
			)}


		override fun modifyTimeTable(entity: EncryptedTimeTableJs): Promise<EncryptedTimeTableJs> =
				GlobalScope.promise {
			timeTable_toJs(timeTableApi.encrypted.modifyTimeTable(com.icure.sdk.js.model.timeTable_fromJs(entity)))}


		override fun getTimeTable(entityId: String): Promise<EncryptedTimeTableJs> = GlobalScope.promise {
			timeTable_toJs(timeTableApi.encrypted.getTimeTable(entityId))}


		override fun getTimeTablesByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<EncryptedTimeTableJs>> = GlobalScope.promise {
			listToArray(
				timeTableApi.encrypted.getTimeTablesByPeriodAndAgendaId(numberToLong(startDate, "startDate"),
						numberToLong(endDate, "endDate"), agendaId),
				{ x1: EncryptedTimeTable ->
					timeTable_toJs(x1)
				},
			)}


		override fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<EncryptedTimeTableJs>> =
				GlobalScope.promise {
			listToArray(
				timeTableApi.encrypted.getTimeTablesByAgendaId(agendaId),
				{ x1: EncryptedTimeTable ->
					timeTable_toJs(x1)
				},
			)}

	}

	override val tryAndRecover: TimeTableFlavouredApiJs<TimeTableJs> = object :
			TimeTableFlavouredApiJs<TimeTableJs> {
		override fun shareWith(
			delegateId: String,
			timeTable: TimeTableJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<TimeTableJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				timeTableApi.tryAndRecover.shareWith(delegateId,
						com.icure.sdk.js.model.timeTable_fromJs(timeTable),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: TimeTable ->
					timeTable_toJs(x1)
				},
			)}


		override fun modifyTimeTable(entity: TimeTableJs): Promise<TimeTableJs> = GlobalScope.promise {
			timeTable_toJs(timeTableApi.tryAndRecover.modifyTimeTable(com.icure.sdk.js.model.timeTable_fromJs(entity)))}


		override fun getTimeTable(entityId: String): Promise<TimeTableJs> = GlobalScope.promise {
			timeTable_toJs(timeTableApi.tryAndRecover.getTimeTable(entityId))}


		override fun getTimeTablesByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<TimeTableJs>> = GlobalScope.promise {
			listToArray(
				timeTableApi.tryAndRecover.getTimeTablesByPeriodAndAgendaId(numberToLong(startDate,
						"startDate"), numberToLong(endDate, "endDate"), agendaId),
				{ x1: TimeTable ->
					timeTable_toJs(x1)
				},
			)}


		override fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<TimeTableJs>> =
				GlobalScope.promise {
			listToArray(
				timeTableApi.tryAndRecover.getTimeTablesByAgendaId(agendaId),
				{ x1: TimeTable ->
					timeTable_toJs(x1)
				},
			)}

	}

	override fun createTimeTable(entity: DecryptedTimeTableJs): Promise<DecryptedTimeTableJs> =
			GlobalScope.promise {
		timeTable_toJs(timeTableApi.createTimeTable(com.icure.sdk.js.model.timeTable_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedTimeTableJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedTimeTableJs> = GlobalScope.promise {
		timeTable_toJs(timeTableApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.timeTable_fromJs(nonNull1)
		}, patient?.let { nonNull1 ->
		  com.icure.sdk.js.model.patient_fromJs(nonNull1)
		}, user?.let { nonNull1 ->
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


	override fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(timeTableApi.deleteTimeTable(entityId))}


	override fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			timeTableApi.deleteTimeTables(arrayToList(
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
		timeTable: DecryptedTimeTableJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedTimeTableJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			timeTableApi.shareWith(delegateId, com.icure.sdk.js.model.timeTable_fromJs(timeTable),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)}

}
