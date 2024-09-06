// auto-generated file
package com.icure.cardinal.sdk.py.filters.TimeTableFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.TimeTableFilters
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class ByAgendaIdParams(
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun byAgendaId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByAgendaIdParams>(params)
	TimeTableFilters.byAgendaId(
		decodedParams.agendaId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)))

@Serializable
private class ByPeriodAndAgendaIdParams(
	public val agendaId: String,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPeriodAndAgendaId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPeriodAndAgendaIdParams>(params)
	TimeTableFilters.byPeriodAndAgendaId(
		decodedParams.agendaId,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(TimeTable::class)))
