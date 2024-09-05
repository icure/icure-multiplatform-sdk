// auto-generated file
package com.icure.cardinal.sdk.py.filters.DeviceFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.DeviceFilters
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	DeviceFilters.all()
}.toPyString(BaseFilterOptions.serializer(Device.serializer()))

@Serializable
private class ByResponsibleParams(
	public val responsibleId: String,
)

public fun byResponsible(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByResponsibleParams>(params)
	DeviceFilters.byResponsible(
		decodedParams.responsibleId,
	)
}.toPyString(BaseFilterOptions.serializer(Device.serializer()))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	DeviceFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(Device.serializer()))
