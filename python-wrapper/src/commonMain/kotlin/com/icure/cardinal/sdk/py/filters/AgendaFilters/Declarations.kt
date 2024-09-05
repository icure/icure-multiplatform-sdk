// auto-generated file
package com.icure.cardinal.sdk.py.filters.AgendaFilters

import com.icure.cardinal.sdk.filters.AgendaFilters
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.String
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	AgendaFilters.all()
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ByUserParams(
	public val userId: String,
)

public fun byUser(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByUserParams>(params)
	AgendaFilters.byUser(
		decodedParams.userId,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ReadableByUserParams(
	public val userId: String,
)

public fun readableByUser(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ReadableByUserParams>(params)
	AgendaFilters.readableByUser(
		decodedParams.userId,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))
