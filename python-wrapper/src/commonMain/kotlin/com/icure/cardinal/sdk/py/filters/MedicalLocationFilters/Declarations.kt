// auto-generated file
package com.icure.cardinal.sdk.py.filters.MedicalLocationFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.MedicalLocationFilters
import com.icure.cardinal.sdk.model.MedicalLocation
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
import kotlin.String
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	MedicalLocationFilters.all()
}.toPyString(BaseFilterOptions.serializer(MedicalLocation.serializer()))

@Serializable
private class ByPostCodeParams(
	public val postCode: String,
)

@OptIn(InternalIcureApi::class)
public fun byPostCode(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPostCodeParams>(params)
	MedicalLocationFilters.byPostCode(
		decodedParams.postCode,
	)
}.toPyString(BaseFilterOptions.serializer(MedicalLocation.serializer()))
