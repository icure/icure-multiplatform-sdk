// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.cardinal.sdk.js.crypto.entities.TimeTableShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.TimeTableJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TimeTableFlavouredApi")
public external interface TimeTableFlavouredApiJs<E : TimeTableJs> {
	public fun shareWith(
		delegateId: String,
		timeTable: E,
		options: dynamic,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(timeTable: E, delegates: Record<String, TimeTableShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(timeTable: E, delegates: Record<String, TimeTableShareOptionsJs>):
			Promise<E>

	public fun filterTimeTablesBy(filter: FilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterTimeTablesBySorted(filter: SortableFilterOptionsJs<TimeTableJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun modifyTimeTable(entity: E): Promise<E>

	public fun getTimeTable(entityId: String): Promise<E>

	public fun getTimeTables(timeTableIds: Array<String>): Promise<Array<E>>

	public fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<E>>

	public fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<E>>
}
