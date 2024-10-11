// auto-generated file
package com.icure.cardinal.sdk.py.filters.TopicFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.TopicFilters
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllTopicsForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allTopicsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AllTopicsForDataOwnerParams>(params)
	TopicFilters.allTopicsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Topic::class)))

public fun allTopicsForSelf(): String = kotlin.runCatching {
	TopicFilters.allTopicsForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Topic::class)))

@Serializable
private class ByParticipantParams(
	public val participantId: String,
)

@OptIn(InternalIcureApi::class)
public fun byParticipant(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByParticipantParams>(params)
	TopicFilters.byParticipant(
		decodedParams.participantId,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Topic::class)))
