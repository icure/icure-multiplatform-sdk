package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.timetable.TimeTableByAgendaIdFilter
import com.icure.cardinal.sdk.model.filter.timetable.TimeTableByPeriodAndAgendaIdFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

object TimeTableFilters {

	/**
	 * Options for time table filtering that match all the time tables where [TimeTable.agendaId] is equal to [agendaId].
	 *
	 * @param agendaId the agenda id to use in the filter.
	 */
	fun byAgendaId(
		agendaId: String
	): BaseFilterOptions<TimeTable> = ByAgendaId(agendaId)

	/**
	 * Options for time table filtering that will match all the time tables where [TimeTable.agendaId] is equal to [agendaId] and the interval
	 * [TimeTable.startTime] to [TimeTable.endTime] intersects with the [from] to [to] interval.
	 * If the [from] timestamp is null, the interval starts from 0.
	 * If the [to] timestamp is null, the interval ends to the greatest long number.
	 *
	 * These options are sortable. When sorting using these options the services will be sorted by [TimeTable.startTime].
	 *
	 * @param agendaId the agenda id to use in the filter.
	 * @param from the timestamp that marks the starts of the reference interval (default: 0).
	 * @param to the timestamp that marks the end of the reference interval (default: max long).
	 * @param descending whether to sort the results in descending or ascending order by [TimeTable.startTime]
	 */
	fun byPeriodAndAgendaId(
		agendaId: String,
		@DefaultValue("null")
		from: Long? = null,
		@DefaultValue("null")
		to: Long? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<TimeTable> = ByPeriodAndAgendaId(agendaId, from, to, descending)

	@Serializable
	internal class ByAgendaId(
		val agendaId: String
	): BaseFilterOptions<TimeTable>

	@Serializable
	internal class ByPeriodAndAgendaId(
		val agendaId: String,
		val from: Long?,
		val to: Long?,
		val descending: Boolean
	): BaseSortableFilterOptions<TimeTable>
}

@InternalIcureApi
internal suspend fun mapTimeTableFilterOptions(
	filterOptions: FilterOptions<TimeTable>
): AbstractFilter<TimeTable> = mapIfMetaFilterOptions(filterOptions, ::mapTimeTableFilterOptions) ?: when (filterOptions) {
	is TimeTableFilters.ByAgendaId -> TimeTableByAgendaIdFilter(agendaId = filterOptions.agendaId)
	is TimeTableFilters.ByPeriodAndAgendaId -> TimeTableByPeriodAndAgendaIdFilter(
		agendaId = filterOptions.agendaId,
		startDate = filterOptions.from,
		endDate = filterOptions.to,
		descending = filterOptions.descending
	)
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering TimeTables")
}
