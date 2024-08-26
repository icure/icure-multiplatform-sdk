// auto-generated file
package com.icure.sdk.py.filters.AgendaFilters

import com.icure.sdk.filters.AgendaFilters
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.model.Agenda
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
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
