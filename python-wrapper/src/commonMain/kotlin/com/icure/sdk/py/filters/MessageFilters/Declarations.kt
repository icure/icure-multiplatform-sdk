// auto-generated file
package com.icure.sdk.py.filters.MessageFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.MessageFilters
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.py.serialization.MessageSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
private class AllMessagesForDataOwnerParams(
	public val dataOwnerId: String,
)

public fun allMessagesForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AllMessagesForDataOwnerParams>(params)
	MessageFilters.allMessagesForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(MessageSerializer))

public fun allMessagesForSelf(): String = kotlin.runCatching {
	MessageFilters.allMessagesForSelf()
}.toPyString(FilterOptions.serializer(MessageSerializer))

@Serializable
private class ByTransportGuidDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val transportGuid: String,
)

public fun byTransportGuidDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTransportGuidDateForDataOwnerParams>(params)
	MessageFilters.byTransportGuidDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.transportGuid,
	)
}.toPyString(BaseSortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class ByTransportGuidDateParams(
	public val transportGuid: String,
)

public fun byTransportGuidDate(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTransportGuidDateParams>(params)
	MessageFilters.byTransportGuidDate(
		decodedParams.transportGuid,
	)
}.toPyString(SortableFilterOptions.serializer(MessageSerializer))
