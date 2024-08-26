// auto-generated file
package com.icure.sdk.py.filters.TimeTableFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.TimeTableFilters
import com.icure.sdk.py.serialization.TimeTableSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
private class ByAgendaIdParams(
	public val agendaId: String,
)

public fun byAgendaId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByAgendaIdParams>(params)
	TimeTableFilters.byAgendaId(
		decodedParams.agendaId,
	)
}.toPyString(BaseFilterOptions.serializer(TimeTableSerializer))

@Serializable
private class ByPeriodAndAgendaIdParams(
	public val agendaId: String,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

public fun byPeriodAndAgendaId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPeriodAndAgendaIdParams>(params)
	TimeTableFilters.byPeriodAndAgendaId(
		decodedParams.agendaId,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(TimeTableSerializer))
