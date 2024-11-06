// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.MedicalLocationFilters
import com.icure.cardinal.sdk.js.model.MedicalLocationJs
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalMedicalLocationFiltersObj {
	public fun all(): BaseFilterOptionsJs<MedicalLocationJs> {
		val result = MedicalLocationFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byPostCode(postCode: String): BaseFilterOptionsJs<MedicalLocationJs> {
		val postCodeConverted: String = postCode
		val result = MedicalLocationFilters.byPostCode(
			postCodeConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
