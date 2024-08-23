package com.icure.sdk.api.impl

import com.icure.sdk.api.AgendaApi
import com.icure.sdk.api.raw.RawAgendaApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.mapAgendaFilterOptions
import com.icure.sdk.model.Agenda
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator

@InternalIcureApi
internal class AgendaApiImpl (
	private val rawApi: RawAgendaApi,
) : AgendaApi {
	@Deprecated("Use filter instead")
	override suspend fun getAllAgendas(
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<Agenda> = rawApi.getAgendas(startDocumentId, limit).successBody()

	override suspend fun createAgenda(agendaDto: Agenda): Agenda = rawApi.createAgenda(agendaDto).successBody()

	override suspend fun deleteAgendas(agendaIds: ListOfIds): List<DocIdentifier> = rawApi.deleteAgendas(agendaIds).successBody()

	override suspend fun deleteAgenda(agendaId: String): DocIdentifier = rawApi.deleteAgenda(agendaId).successBody()

	override suspend fun getAgenda(agendaId: String): Agenda = rawApi.getAgenda(agendaId).successBody()

	override suspend fun getAgendas(agendaIds: List<String>): List<Agenda> = rawApi.getAgendasByIds(ListOfIds(agendaIds)).successBody()

	@Deprecated("Use filter instead")
	override suspend fun getAgendasForUser(userId: String): Agenda = rawApi.getAgendasForUser(userId).successBody()

	@Deprecated("Use filter instead")
	override suspend fun getReadableAgendasForUser(userId: String): List<Agenda> = rawApi.getReadableAgendasForUser(userId).successBody()

	override suspend fun modifyAgenda(agendaDto: Agenda): Agenda = rawApi.modifyAgenda(agendaDto).successBody()

	override suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String> =
		rawApi.matchAgendasBy(mapAgendaFilterOptions(filter)).successBody()

	override suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String> =
		matchAgendasBy(filter)

	override suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		IdsPageIterator(matchAgendasBy(filter), ::getAgendas)

	override suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		filterAgendasBy(filter)
}