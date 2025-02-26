// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.TimeTableJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TimeTableApi")
public external interface TimeTableApiJs {
	public fun deleteTimeTableUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteTimeTablesUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteTimeTableById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteTimeTablesByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeTimeTableById(id: String, rev: String): Promise<Unit>

	public fun deleteTimeTable(timeTable: TimeTableJs): Promise<DocIdentifierJs>

	public fun deleteTimeTables(timeTables: Array<TimeTableJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeTimeTable(timeTable: TimeTableJs): Promise<Unit>

	public fun undeleteTimeTable(timeTable: TimeTableJs): Promise<TimeTableJs>

	public fun modifyTimeTable(entity: TimeTableJs): Promise<TimeTableJs>

	public fun undeleteTimeTableById(id: String, rev: String): Promise<TimeTableJs>

	public fun getTimeTable(entityId: String): Promise<TimeTableJs>

	public fun getTimeTables(timeTableIds: Array<String>): Promise<Array<TimeTableJs>>

	public fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<TimeTableJs>>

	public fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<TimeTableJs>>

	public fun filterTimeTablesBy(filter: BaseFilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<TimeTableJs>>

	public fun filterTimeTablesBySorted(filter: BaseSortableFilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<TimeTableJs>>

	public fun createTimeTable(entity: TimeTableJs): Promise<TimeTableJs>

	public fun matchTimeTablesBy(filter: BaseFilterOptionsJs<TimeTableJs>): Promise<Array<String>>

	public fun matchTimeTablesBySorted(filter: BaseSortableFilterOptionsJs<TimeTableJs>):
			Promise<Array<String>>
}
