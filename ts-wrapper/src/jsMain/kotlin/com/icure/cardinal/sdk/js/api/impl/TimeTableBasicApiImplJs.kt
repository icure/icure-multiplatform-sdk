// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.TimeTableBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.TimeTableBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.EncryptedTimeTableJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.TimeTableJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.model.timeTable_fromJs
import com.icure.cardinal.sdk.js.model.timeTable_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class TimeTableBasicApiImplJs(
	private val timeTableBasicApi: TimeTableBasicApi,
) : TimeTableBasicApiJs {
	override fun matchTimeTablesBy(filter: BaseFilterOptionsJs<TimeTableJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<TimeTable> = baseFilterOptions_fromJs(filter)
		val result = timeTableBasicApi.matchTimeTablesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchTimeTablesBySorted(filter: BaseSortableFilterOptionsJs<TimeTableJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<TimeTable> =
				baseSortableFilterOptions_fromJs(filter)
		val result = timeTableBasicApi.matchTimeTablesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterTimeTablesBy(filter: BaseFilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<EncryptedTimeTableJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<TimeTable> = baseFilterOptions_fromJs(filter)
		val result = timeTableBasicApi.filterTimeTablesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
	}

	override fun filterTimeTablesBySorted(filter: BaseSortableFilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<EncryptedTimeTableJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<TimeTable> =
				baseSortableFilterOptions_fromJs(filter)
		val result = timeTableBasicApi.filterTimeTablesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
	}

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

	override fun deleteTimeTableById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = timeTableBasicApi.deleteTimeTableById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTimeTablesByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<IdWithMandatoryRev> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = timeTableBasicApi.deleteTimeTablesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeTimeTableById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		timeTableBasicApi.purgeTimeTableById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteTimeTable(timeTable: TimeTableJs): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
		val result = timeTableBasicApi.deleteTimeTable(
			timeTableConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTimeTables(timeTables: Array<TimeTableJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val timeTablesConverted: List<TimeTable> = arrayToList(
			timeTables,
			"timeTables",
			{ x1: TimeTableJs ->
				timeTable_fromJs(x1)
			},
		)
		val result = timeTableBasicApi.deleteTimeTables(
			timeTablesConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeTimeTable(timeTable: TimeTableJs): Promise<Unit> = GlobalScope.promise {
		val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
		timeTableBasicApi.purgeTimeTable(
			timeTableConverted,
		)

	}

	override fun undeleteTimeTable(timeTable: TimeTableJs): Promise<TimeTableJs> =
			GlobalScope.promise {
		val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
		val result = timeTableBasicApi.undeleteTimeTable(
			timeTableConverted,
		)
		timeTable_toJs(result)
	}

	override fun modifyTimeTable(entity: EncryptedTimeTableJs): Promise<EncryptedTimeTableJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedTimeTable = timeTable_fromJs(entity)
		val result = timeTableBasicApi.modifyTimeTable(
			entityConverted,
		)
		timeTable_toJs(result)
	}

	override fun undeleteTimeTableById(id: String, rev: String): Promise<EncryptedTimeTableJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = timeTableBasicApi.undeleteTimeTableById(
			idConverted,
			revConverted,
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

	override fun getTimeTables(timeTableIds: Array<String>): Promise<Array<EncryptedTimeTableJs>> =
			GlobalScope.promise {
		val timeTableIdsConverted: List<String> = arrayToList(
			timeTableIds,
			"timeTableIds",
			{ x1: String ->
				x1
			},
		)
		val result = timeTableBasicApi.getTimeTables(
			timeTableIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
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
