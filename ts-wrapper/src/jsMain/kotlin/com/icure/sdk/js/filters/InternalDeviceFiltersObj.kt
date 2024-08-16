// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.DeviceFilters
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.DeviceJs
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalDeviceFiltersObj {
	public fun all(): BaseFilterOptionsJs<DeviceJs> {
		val result = DeviceFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byResponsible(responsibleId: String): BaseFilterOptionsJs<DeviceJs> {
		val responsibleIdConverted: String = responsibleId
		val result = DeviceFilters.byResponsible(
			responsibleIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<DeviceJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = DeviceFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}
}
