package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.AgendaInGroupApi
import com.icure.cardinal.sdk.api.raw.RawAgendaApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapAgendaFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class AgendaApiImpl (
	private val rawApi: RawAgendaApi,
	private val config: BasicApiConfiguration,
) : AgendaApi {

	override val inGroup: AgendaInGroupApi = AgendaGroupApiImpl(rawApi, config)

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

	override suspend fun getAgenda(agendaId: String): Agenda? = rawApi.getAgenda(agendaId).successBodyOrNull404()

	override suspend fun getAgendas(agendaIds: List<String>): List<Agenda> = rawApi.getAgendasByIds(ListOfIds(agendaIds)).successBody()

	@Deprecated("Use filter instead")
	override suspend fun getAgendasForUser(userId: String): Agenda = rawApi.getAgendasForUser(userId).successBody()

	override suspend fun modifyAgenda(agendaDto: Agenda): Agenda = rawApi.modifyAgenda(agendaDto).successBodyOrThrowRevisionConflict()

	override suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String> =
		rawApi.matchAgendasBy(mapAgendaFilterOptions(filter, config)).successBody()

	override suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String> =
		matchAgendasBy(filter)

	override suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		IdsPageIterator(matchAgendasBy(filter), ::getAgendas)

	override suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda> =
		filterAgendasBy(filter)
}

@InternalIcureApi
internal class AgendaGroupApiImpl (
	private val rawApi: RawAgendaApi,
	private val config: BasicApiConfiguration,
) : AgendaInGroupApi {

	override suspend fun getAgenda(
		groupId: String,
		entityId: String,
	): GroupScoped<Agenda>? =
		rawApi.getAgendaInGroup(groupId, entityId).successBodyOrNull404()?.let { GroupScoped(it, groupId) }

	override suspend fun getAgendas(
		groupId: String,
		entityIds: List<String>,
	): List<GroupScoped<Agenda>> =
		rawApi.getAgendasInGroup(groupId, ListOfIds(entityIds)).successBody().map { GroupScoped(it, groupId) }

	override suspend fun createAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda> =
		rawApi.createAgendaInGroup(entity.groupId, entity.entity ).successBody().let { GroupScoped(it, entity.groupId) }

	override suspend fun modifyAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda> =
		rawApi.modifyAgendaInGroup(entity.groupId, entity.entity ).successBody().let { GroupScoped(it, entity.groupId) }

	override suspend fun deleteAgendas(agendas: List<GroupScoped<Agenda>>): List<GroupScoped<StoredDocumentIdentifier>> =
		agendas.mapUniqueIdentifiablesChunkedByGroup { groupId, entities ->
			rawApi.deleteAgendasInGroup(
				groupId = groupId,
				agendaIdsAndRevs = ListOfIdsAndRev(entities.map { IdWithRev(it.id, it.rev) })
			).successBody().map { it.toStoredDocumentIdentifier() }
		}

	override suspend fun deleteAgenda(agenda: GroupScoped<Agenda>): GroupScoped<StoredDocumentIdentifier> =
		rawApi.deleteAgendaInGroup(agenda.groupId, agenda.entity.id, agenda.entity.rev).successBody().let {
			GroupScoped(it.toStoredDocumentIdentifier(), agenda.groupId)
		}

	override suspend fun deleteAgendasByIds(
		entityIds: List<GroupScoped<StoredDocumentIdentifier>>
	): List<GroupScoped<StoredDocumentIdentifier>> = entityIds.mapUniqueIdentifiablesChunkedByGroup { groupId, entityIds ->
		rawApi.deleteAgendasInGroup(
			groupId = groupId,
			agendaIdsAndRevs = ListOfIdsAndRev(entityIds.map { IdWithRev(it.id, it.rev) })
		).successBody().map { it.toStoredDocumentIdentifier() }
	}

	override suspend fun deleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		 rawApi.deleteAgendaInGroup(entityId.groupId, entityId.entity.id, entityId.entity.rev).successBody().let {
			 GroupScoped(it.toStoredDocumentIdentifier(), entityId.groupId)
		 }

	override suspend fun matchAgendasBy(
		groupId: String,
		filter: BaseFilterOptions<Agenda>,
	): List<String> = rawApi.matchAgendasInGroup(
		groupId = groupId,
		filter = mapAgendaFilterOptions(filter, config, groupId)
	).successBody()

	override suspend fun matchAgendasBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Agenda>,
	): List<String> = matchAgendasBy(groupId, filter)

	override suspend fun filterAgendasBy(
		groupId: String,
		filter: BaseFilterOptions<Agenda>,
	): PaginatedListIterator<GroupScoped<Agenda>> {
		val ids = matchAgendasBy(groupId, filter)
		return IdsPageIterator(ids) { getAgendas(groupId, it) }
	}

	override suspend fun filterAgendasBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<Agenda>,
	): PaginatedListIterator<GroupScoped<Agenda>> = filterAgendasBy(groupId, filter)


}
