// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.UserFilters
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.UserJs
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalUserFiltersObj {
	public fun all(): BaseFilterOptionsJs<UserJs> {
		val result = UserFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<UserJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = UserFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byPatientId(patientId: String): BaseFilterOptionsJs<UserJs> {
		val patientIdConverted: String = patientId
		val result = UserFilters.byPatientId(
			patientIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byNameEmailOrPhone(searchString: String): BaseFilterOptionsJs<UserJs> {
		val searchStringConverted: String = searchString
		val result = UserFilters.byNameEmailOrPhone(
			searchStringConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
