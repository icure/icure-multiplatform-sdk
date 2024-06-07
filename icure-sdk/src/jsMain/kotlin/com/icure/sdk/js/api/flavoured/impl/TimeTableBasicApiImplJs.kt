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
import com.icure.sdk.js.model.timeTable_fromJs
import com.icure.sdk.js.model.timeTable_toJs
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class TimeTableBasicApiImplJs(
	private val timeTableBasicApi: TimeTableBasicApi,
) : TimeTableBasicApiJs {
	override fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = timeTableBasicApi.deleteTimeTable(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = timeTableBasicApi.deleteTimeTables(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun modifyTimeTable(entity: EncryptedTimeTableJs): Promise<EncryptedTimeTableJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedTimeTable = timeTable_fromJs(entity)
		val result = timeTableBasicApi.modifyTimeTable(
			entityConverted,
		)
		timeTable_toJs(result)
	}

	override fun getTimeTable(entityId: String): Promise<EncryptedTimeTableJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = timeTableBasicApi.getTimeTable(
			entityIdConverted,
		)
		timeTable_toJs(result)
	}

	override fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedTimeTableJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val agendaIdConverted: String = agendaId
		val result = timeTableBasicApi.getTimeTablesByPeriodAndAgendaId(
			startDateConverted,
			endDateConverted,
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
	}

	override fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<EncryptedTimeTableJs>> =
			GlobalScope.promise {
		val agendaIdConverted: String = agendaId
		val result = timeTableBasicApi.getTimeTablesByAgendaId(
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
	}
}
