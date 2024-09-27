package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface AgendaApi {
	@Deprecated("Use filter instead")
	suspend fun getAllAgendas(
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<Agenda>

	suspend fun createAgenda(agendaDto: Agenda): Agenda

	/**
	 * Deletes a agenda. If you don't have write access to the agenda the method will fail.
	 * @param entityId id of the agenda.
	 * @param rev the latest known rev of the agenda to delete
	 * @return the id and revision of the deleted agenda.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteAgenda(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many agendas. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the agendas to delete.
	 * @return the id and revision of the deleted agendas. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteAgendas(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Permanently deletes a agenda.
	 * @param id id of the agenda to purge
	 * @param rev latest revision of the agenda
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeAgenda(id: String, rev: String)

	/**
	 * Restores a agenda that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteAgenda(id: String, rev: String): Agenda

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