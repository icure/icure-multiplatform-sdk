// auto-generated file
package com.icure.sdk.py.filters.MedicalLocationFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.MedicalLocationFilters
import com.icure.sdk.model.MedicalLocation
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.String
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	MedicalLocationFilters.all()
}.toPyString(BaseFilterOptions.serializer(MedicalLocation.serializer()))

@Serializable
private class ByPostCodeParams(
	public val postCode: String,
)

public fun byPostCode(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPostCodeParams>(params)
	MedicalLocationFilters.byPostCode(
		decodedParams.postCode,
	)
}.toPyString(BaseFilterOptions.serializer(MedicalLocation.serializer()))
