package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface AgendaApi {

	val inGroup: AgendaInGroupApi

	@Deprecated("Use filter instead")
	suspend fun getAllAgendas(
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<Agenda>

	suspend fun createAgenda(agendaDto: Agenda): Agenda

	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteAgendaUnsafe(entityId: String): DocIdentifier
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteAgendasUnsafe(entityIds: List<String>): List<DocIdentifier>

	/**
	 * Deletes an agenda. If you don't have write access to the agenda the method will fail.
	 * @param entityId id of the agenda.
	 * @param rev the latest known rev of the agenda to delete
	 * @return the id and revision of the deleted agenda.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteAgendaById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many agendas. Ids that don't correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the agendas to delete.
	 * @return the id and revision of the deleted agendas. If some entities couldn't be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteAgendasByIds(entityIds: List<StoredDocumentIdentifier>): List<DocIdentifier>

	/**
	 * Permanently deletes a agenda.
	 * @param id id of the agenda to purge
	 * @param rev latest revision of the agenda
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeAgendaById(id: String, rev: String)

	/**
	 * Restores an agenda that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteAgendaById(id: String, rev: String): Agenda

	/**
	 * Deletes an agenda. If you don't have write access to the agenda the method will fail.
	 * @param agenda the agenda to delete
	 * @return the id and revision of the deleted agenda.
	 * @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	suspend fun deleteAgenda(agenda: Agenda): DocIdentifier =
		deleteAgendaById(agenda.id, requireNotNull(agenda.rev) { "Can't delete an agenda that has no rev" })

	/**
	 * Deletes many agendas. Ignores agenda for which you don't have write access or that don't match the latest revision.
	 * @param agendas the agendas to delete
	 * @return the id and revision of the deleted agendas. If some entities couldn't be deleted they will not be
	 * included in this list.
	 */
	suspend fun deleteAgendas(agendas: List<Agenda>): List<DocIdentifier> =
		deleteAgendasByIds(agendas.map { agenda ->
			StoredDocumentIdentifier(agenda.id, requireNotNull(agenda.rev) { "Can't delete an agenda that has no rev" })
		})

	/**
	 * Permanently deletes a agenda.
	 * @param agenda the agenda to purge.
	 * @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	suspend fun purgeAgenda(agenda: Agenda) {
		purgeAgendaById(agenda.id, requireNotNull(agenda.rev) { "Can't delete an agenda that has no rev" })
	}

	/**
	 * Restores an agenda that was marked as deleted.
	 * @param agenda the agenda to undelete
	 * @return the restored agenda.
	 * @throws RevisionConflictException if the provided agenda doesn't match the latest known revision
	 */
	suspend fun undeleteAgenda(agenda: Agenda): Agenda =
		undeleteAgendaById(agenda.id, requireNotNull(agenda.rev) { "Can't delete an agenda that has no rev" })

	suspend fun getAgenda(agendaId: String): Agenda?

	suspend fun getAgendas(agendaIds: List<String>): List<Agenda>

	@Deprecated("Use filter instead")
	suspend fun getAgendasForUser(userId: String): Agenda

	suspend fun modifyAgenda(agendaDto: Agenda): Agenda

	suspend fun matchAgendasBy(filter: BaseFilterOptions<Agenda>): List<String>

	suspend fun matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): List<String>

	suspend fun filterAgendasBy(filter: BaseFilterOptions<Agenda>): PaginatedListIterator<Agenda>

	suspend fun filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<Agenda>
}


interface AgendaInGroupApi {

	suspend fun getAgenda(groupId: String, entityId: String): GroupScoped<Agenda>?

	suspend fun getAgendas(groupId: String, entityIds: List<String>): List<GroupScoped<Agenda>>

	suspend fun createAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda>

	suspend fun modifyAgenda(entity: GroupScoped<Agenda>): GroupScoped<Agenda>

	suspend fun deleteAgendas(agendas: List<GroupScoped<Agenda>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteAgenda(agenda: GroupScoped<Agenda>): GroupScoped<StoredDocumentIdentifier>

	suspend fun deleteAgendasByIds(entityIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>

	suspend fun deleteAgendaById(entityId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>

	suspend fun matchAgendasBy(groupId: String, filter: BaseFilterOptions<Agenda>): List<String>

	suspend fun matchAgendasBySorted(groupId: String, filter: BaseSortableFilterOptions<Agenda>): List<String>

	suspend fun filterAgendasBy(groupId: String, filter: BaseFilterOptions<Agenda>): PaginatedListIterator<GroupScoped<Agenda>>

	suspend fun filterAgendasBySorted(groupId: String, filter: BaseSortableFilterOptions<Agenda>): PaginatedListIterator<GroupScoped<Agenda>>
}
