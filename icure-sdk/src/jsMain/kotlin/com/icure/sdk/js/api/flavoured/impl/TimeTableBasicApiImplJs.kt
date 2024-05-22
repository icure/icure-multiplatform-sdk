// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.TimeTableBasicApi
import com.icure.sdk.js.api.flavoured.TimeTableBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.EncryptedTimeTableJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.timeTable_toJs
import com.icure.sdk.model.EncryptedTimeTable
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
public class TimeTableBasicApiImplJs private constructor(
	private val timeTableBasicApi: TimeTableBasicApi,
) : TimeTableBasicApiJs {
	override fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(timeTableBasicApi.deleteTimeTable(entityId))}


	override fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			timeTableBasicApi.deleteTimeTables(arrayToList(
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


	override fun modifyTimeTable(entity: EncryptedTimeTableJs): Promise<EncryptedTimeTableJs> =
			GlobalScope.promise {
		timeTable_toJs(timeTableBasicApi.modifyTimeTable(com.icure.sdk.js.model.timeTable_fromJs(entity)))}


	override fun getTimeTable(entityId: String): Promise<EncryptedTimeTableJs> = GlobalScope.promise {
		timeTable_toJs(timeTableBasicApi.getTimeTable(entityId))}


	override fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedTimeTableJs>> = GlobalScope.promise {
		listToArray(
			timeTableBasicApi.getTimeTablesByPeriodAndAgendaId(numberToLong(startDate, "startDate"),
					numberToLong(endDate, "endDate"), agendaId),
			{ x1: EncryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)}


	override fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<EncryptedTimeTableJs>> =
			GlobalScope.promise {
		listToArray(
			timeTableBasicApi.getTimeTablesByAgendaId(agendaId),
			{ x1: EncryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)}

}
