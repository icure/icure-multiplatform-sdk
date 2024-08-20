// auto-generated file
package com.icure.sdk.js.filters

import com.icure.sdk.filters.CodeFilters
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.CodeJs
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalCodeFiltersObj {
	public fun all(): FilterOptionsJs<CodeJs> {
		val result = CodeFilters.all(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byIds(ids: Array<String>): BaseSortableFilterOptionsJs<CodeJs> {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = CodeFilters.byIds(
			idsConverted,
		)
		return BaseSortableFilterOptionsJsImpl(result)
	}

	public fun byLanguageTypeLabelRegion(
		language: String,
		type: String,
		options: dynamic,
	): BaseFilterOptionsJs<CodeJs> {
		val _options = options ?: js("{}")
		val languageConverted: String = language
		val typeConverted: String = type
		val labelConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"label",
			null
		) { label: String? ->
			undefinedToNull(label)
		}
		val regionConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"region",
			null
		) { region: String? ->
			undefinedToNull(region)
		}
		val result = CodeFilters.byLanguageTypeLabelRegion(
			languageConverted,
			typeConverted,
			labelConverted,
			regionConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
