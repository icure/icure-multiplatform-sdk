package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.raw.RawAgendaApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapAgendaFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class AgendaApiImpl (
	private val rawApi: RawAgendaApi,
) : AgendaApi {
	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteAgendaUnsafe(entityId: String): DocIdentifier =
		rawApi.deleteAgenda(entityId).successBodyOrThrowRevisionConflict()

	@Deprecated("Deletion without rev is unsafe")
	override suspend fun deleteAgendasUnsafe(entityIds: List<String>): List<DocIdentifier> =
		rawApi.deleteAgendas(ListOfIds(entityIds)).successBody()
	
	@Deprecated("Use filter instead")
	override suspend fun getAllAgendas(
		startDocumentId: String?,
		limit: Int?,
	): PaginatedList<Agenda> = rawApi.getAgendas(startDocumentId, limit).successBody()

	override suspend fun createAgenda(agendaDto: Agenda): Agenda = rawApi.createAgenda(agendaDto).successBody()

	override suspend fun deleteAgendaById(entityId: String, rev: String): DocIdentifier =
		rawApi.deleteAgenda(entityId, rev).successBodyOrThrowRevisionConflict()

	override suspend fun deleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier> =
		rawApi.deleteAgendasWithRev(ListOfIdsAndRev(entityIds)).successBody()

	override suspend fun purgeAgendaById(id: String, rev: String) {
		rawApi.purgeAgenda(id, rev).successBodyOrThrowRevisionConflict()
	}

	override suspend fun undeleteAgendaById(id: String, rev: String): Agenda =
		rawApi.undeleteAgenda(id, rev).successBodyOrThrowRevisionConflict()

	override suspend fun getAgenda(agendaId: String): Agenda = rawApi.getAgenda(agendaId).successBody()

	override suspend fun getAgendas(agendaIds: List<String>): List<Agenda> = rawApi.getAgendasByIds(ListOfIds(agendaIds)).successBody()

	@Deprecated("Use filter instead")
	override suspend fun getAgendasForUser(userId: String): Agenda = rawApi.getAgendasForUser(userId).successBody()

	override suspend fun modifyAgenda(agendaDto: Agenda): Agenda = rawApi.modifyAgenda(agendaDto).successBodyOrThrowRevisionConflict()

	override suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String> =
		rawApi.matchAgendasBy(mapAgendaFilterOptions(filter)).successBody()

	override suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String> =
		matchAgendasBy(filter)

	override suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		IdsPageIterator(matchAgendasBy(filter), ::getAgendas)

	override suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		filterAgendasBy(filter)
}