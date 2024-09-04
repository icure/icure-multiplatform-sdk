// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AgendaJs
import com.icure.cardinal.sdk.js.model.ListOfIdsJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AgendaApi")
public external interface AgendaApiJs {
	public fun getAllAgendas(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<AgendaJs>>

	public fun createAgenda(agendaDto: AgendaJs): Promise<AgendaJs>

	public fun deleteAgendas(agendaIds: ListOfIdsJs): Promise<Array<DocIdentifierJs>>

	public fun deleteAgenda(agendaId: String): Promise<DocIdentifierJs>

	public fun getAgenda(agendaId: String): Promise<AgendaJs>

	public fun getAgendas(agendaIds: Array<String>): Promise<Array<AgendaJs>>

	public fun getAgendasForUser(userId: String): Promise<AgendaJs>

	public fun getReadableAgendasForUser(userId: String): Promise<Array<AgendaJs>>

	public fun modifyAgenda(agendaDto: AgendaJs): Promise<AgendaJs>

	public fun matchAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>): Promise<Array<String>>

	public fun matchAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<Array<String>>

	public fun filterAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>>

	public fun filterAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>>
}
