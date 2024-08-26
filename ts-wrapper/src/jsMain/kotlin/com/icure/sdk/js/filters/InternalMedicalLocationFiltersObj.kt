// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.MedicalLocationFilters
import com.icure.sdk.js.model.MedicalLocationJs
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
