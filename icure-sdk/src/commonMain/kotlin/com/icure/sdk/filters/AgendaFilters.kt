package com.icure.sdk.filters

import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.model.Agenda
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.agenda.AgendaByUserIdFilter
import com.icure.sdk.model.filter.agenda.AgendaReadableByUserIdFilter
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable

object AgendaFilters {

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.userId] is equal to [userId].
	 *
	 * @param userId the id of the user associated to the agenda.
	 */
	fun byUser(
		userId: String
	): BaseFilterOptions<Agenda> = ByUserId(userId)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.rights] contains [userId].
	 *
	 * @param userId the id of that can read the agenda.
	 */
	fun readableByUser(
		userId: String
	): BaseFilterOptions<Agenda> = ReadableByUserId(userId)

	@Serializable
	internal class ByUserId(
		val userId: String
	): BaseFilterOptions<Agenda>

	@Serializable
	internal class ReadableByUserId(
		val userId: String
	): BaseFilterOptions<Agenda>

}

@InternalIcureApi
internal suspend fun mapAgendaFilterOptions(
	filterOptions: FilterOptions<Agenda>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Agenda> = mapIfMetaFilterOptions(filterOptions) {
	mapAgendaFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is AgendaFilters.ByUserId -> AgendaByUserIdFilter(
		userId = filterOptions.userId,
		desc = null
	)
	is AgendaFilters.ReadableByUserId -> AgendaReadableByUserIdFilter(
		userId = filterOptions.userId,
		desc = null
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Agendas")
}
