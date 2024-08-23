package com.icure.sdk.api

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.Agenda
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.pagination.PaginatedListIterator

interface AgendaApi {
	@Deprecated("Use filter instead")
	suspend fun getAllAgendas(
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<Agenda>

	suspend fun createAgenda(agendaDto: Agenda): Agenda

	suspend fun deleteAgendas(agendaIds: ListOfIds): List<DocIdentifier>

	suspend fun deleteAgenda(agendaId: String): DocIdentifier

	suspend fun getAgenda(agendaId: String): Agenda

	suspend fun getAgendas(agendaIds: List<String>): List<Agenda>

	@Deprecated("Use filter instead")
	suspend fun getAgendasForUser(userId: String): Agenda

	@Deprecated("Use filter instead")
	suspend fun getReadableAgendasForUser(userId: String): List<Agenda>

	suspend fun modifyAgenda(agendaDto: Agenda): Agenda

	suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String>

	suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String>

	suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda>

	suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda>
}