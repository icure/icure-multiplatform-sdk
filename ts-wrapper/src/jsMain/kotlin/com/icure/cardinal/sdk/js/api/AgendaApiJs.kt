// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.AgendaJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AgendaApi")
public external interface AgendaApiJs {
	public fun getAllAgendas(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<AgendaJs>>

	public fun createAgenda(agendaDto: AgendaJs): Promise<AgendaJs>

	@JsName("deleteAgendaUnsafe")
	public fun deleteAgenda(entityId: String): Promise<DocIdentifierJs>

	@JsName("deleteAgendasUnsafe")
	public fun deleteAgendas(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteAgendaById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteAgendasByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeAgendaById(id: String, rev: String): Promise<Unit>

	public fun undeleteAgendaById(id: String, rev: String): Promise<AgendaJs>

	public fun deleteAgenda(agenda: AgendaJs): Promise<DocIdentifierJs>

	public fun deleteAgendas(agendas: Array<AgendaJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeAgenda(agenda: AgendaJs): Promise<Unit>

	public fun undeleteAgenda(agenda: AgendaJs): Promise<AgendaJs>

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
