package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaByUserIdFilter
import com.icure.cardinal.sdk.model.filter.agenda.AgendaReadableByUserIdFilter
import com.icure.cardinal.sdk.model.filter.agenda.AllAgendasFilter
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable
import kotlin.coroutines.coroutineContext

object AgendaFilters {
	/**
	 * Filter options to match all agendas.
	 * These options are not sortable.
	 */
	fun all(): BaseFilterOptions<Agenda> = All

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.userId] is equal to [userId].
	 *
	 * @param userId the id of the user associated to the agenda.
	 */
	fun byUser(
		userId: String
	): BaseFilterOptions<Agenda> = ByUserId(EntityReferenceInGroup(userId, null))

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.userId] is equal to [userReference].
	 *
	 * @param userReference the id of the user associated to the agenda.
	 */
	fun byUser(
		userReference: EntityReferenceInGroup,
	): BaseFilterOptions<Agenda> = ByUserId(userReference)

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.rights] contains [userId].
	 *
	 * @param userId the id of that can read the agenda.
	 */
	fun readableByUser(
		userId: String
	): BaseFilterOptions<Agenda> = ReadableByUserId(EntityReferenceInGroup(userId, null))

	/**
	 * Options for agenda filtering that returns all the agendas where [Agenda.rights] contains [userReference].
	 *
	 * @param userReference the id of that can read the agenda.
	 */
	fun readableByUser(
		userReference: EntityReferenceInGroup
	): BaseFilterOptions<Agenda> = ReadableByUserId(userReference)

	@Serializable
	internal data object All : BaseFilterOptions<Agenda>

	@Serializable
	internal class ByUserId(
		val userId: EntityReferenceInGroup
	): BaseFilterOptions<Agenda>

	@Serializable
	internal class ReadableByUserId(
		val userId: EntityReferenceInGroup
	): BaseFilterOptions<Agenda>

}

@InternalIcureApi
internal suspend fun mapAgendaFilterOptions(
	filterOptions: FilterOptions<Agenda>,
	config: BasicApiConfiguration,
	requestGroupId: String? = null,
): AbstractFilter<Agenda> = mapAgendaFilterOptions(
	filterOptions = filterOptions,
	boundGroup = config.getBoundGroup(coroutineContext),
	requestGroupId = requestGroupId,
)

@InternalIcureApi
internal suspend fun mapAgendaFilterOptions(
	filterOptions: FilterOptions<Agenda>,
	boundGroup: SdkBoundGroup?,
	requestGroupId: String? = null,
): AbstractFilter<Agenda> = mapIfMetaFilterOptions(filterOptions) {
	mapAgendaFilterOptions(it, boundGroup, requestGroupId)
} ?: when (filterOptions) {
	is AgendaFilters.All -> AllAgendasFilter()
	is AgendaFilters.ByUserId -> AgendaByUserIdFilter(
		userId = filterOptions.userId.asReferenceStringInGroup(requestGroupId, boundGroup),
		desc = null
	)
	is AgendaFilters.ReadableByUserId -> AgendaReadableByUserIdFilter(
		userId = filterOptions.userId.asReferenceStringInGroup(requestGroupId, boundGroup),
		desc = null
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Agendas")
}
