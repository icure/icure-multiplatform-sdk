// auto-generated file
package com.icure.cardinal.sdk.py.filters.MaintenanceTaskFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.MaintenanceTaskFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.py.serialization.MaintenanceTaskSerializer
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	MaintenanceTaskFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(MaintenanceTaskSerializer))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	MaintenanceTaskFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(MaintenanceTaskSerializer))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForSelfParams>(params)
	MaintenanceTaskFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(MaintenanceTaskSerializer))

@Serializable
private class ByTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val type: String,
)

public fun byTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTypeForDataOwnerParams>(params)
	MaintenanceTaskFilters.byTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.type,
	)
}.toPyString(BaseFilterOptions.serializer(MaintenanceTaskSerializer))

@Serializable
private class ByTypeForSelfParams(
	public val type: String,
)

public fun byTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTypeForSelfParams>(params)
	MaintenanceTaskFilters.byTypeForSelf(
		decodedParams.type,
	)
}.toPyString(FilterOptions.serializer(MaintenanceTaskSerializer))

@Serializable
private class AfterDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val date: Long,
)

public fun afterDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AfterDateForDataOwnerParams>(params)
	MaintenanceTaskFilters.afterDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.date,
	)
}.toPyString(BaseSortableFilterOptions.serializer(MaintenanceTaskSerializer))

@Serializable
private class AfterDateForSelfParams(
	public val date: Long,
)

public fun afterDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AfterDateForSelfParams>(params)
	MaintenanceTaskFilters.afterDateForSelf(
		decodedParams.date,
	)
}.toPyString(SortableFilterOptions.serializer(MaintenanceTaskSerializer))
