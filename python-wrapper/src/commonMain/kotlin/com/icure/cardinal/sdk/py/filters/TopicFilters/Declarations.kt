// auto-generated file
package com.icure.cardinal.sdk.py.filters.TopicFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.TopicFilters
import com.icure.cardinal.sdk.py.serialization.TopicSerializer
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
private class AllTopicsForDataOwnerParams(
	public val dataOwnerId: String,
)

public fun allTopicsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AllTopicsForDataOwnerParams>(params)
	TopicFilters.allTopicsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(TopicSerializer))

public fun allTopicsForSelf(): String = kotlin.runCatching {
	TopicFilters.allTopicsForSelf()
}.toPyString(FilterOptions.serializer(TopicSerializer))

@Serializable
private class ByParticipantParams(
	public val participantId: String,
)

public fun byParticipant(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByParticipantParams>(params)
	TopicFilters.byParticipant(
		decodedParams.participantId,
	)
}.toPyString(FilterOptions.serializer(TopicSerializer))
