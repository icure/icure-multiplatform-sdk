// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.CodeFilters
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.CodeJs
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.js.JsExport

@JsExport
public object InternalCodeFiltersObj {
	public fun all(): BaseFilterOptionsJs<CodeJs> {
		val result = CodeFilters.all(
		)
		return BaseFilterOptionsJsImpl(result)
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

	public fun byQualifiedLink(linkType: String, options: dynamic): BaseFilterOptionsJs<CodeJs> {
		val _options = options ?: js("{}")
		val linkTypeConverted: String = linkType
		val linkedIdConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"linkedId",
			null
		) { linkedId: String? ->
			undefinedToNull(linkedId)
		}
		val result = CodeFilters.byQualifiedLink(
			linkTypeConverted,
			linkedIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun byRegionTypeCodeVersion(region: String, options: dynamic): BaseFilterOptionsJs<CodeJs> {
		val _options = options ?: js("{}")
		val regionConverted: String = region
		val typeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"type",
			null
		) { type: String? ->
			undefinedToNull(type)
		}
		val codeConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"code",
			null
		) { code: String? ->
			undefinedToNull(code)
		}
		val versionConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"version",
			null
		) { version: String? ->
			undefinedToNull(version)
		}
		val result = CodeFilters.byRegionTypeCodeVersion(
			regionConverted,
			typeConverted,
			codeConverted,
			versionConverted,
		)
		return BaseFilterOptionsJsImpl(result)
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

	public fun byLanguageTypesLabelRegionVersion(
		language: String,
		types: Array<String>,
		label: String,
		options: dynamic,
	): BaseFilterOptionsJs<CodeJs> {
		val _options = options ?: js("{}")
		val languageConverted: String = language
		val typesConverted: List<String> = arrayToList(
			types,
			"types",
			{ x1: String ->
				x1
			},
		)
		val labelConverted: String = label
		val regionConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"region",
			null
		) { region: String? ->
			undefinedToNull(region)
		}
		val versionConverted: String? = convertingOptionOrDefaultNullable(
			_options,
			"version",
			null
		) { version: String? ->
			undefinedToNull(version)
		}
		val result = CodeFilters.byLanguageTypesLabelRegionVersion(
			languageConverted,
			typesConverted,
			labelConverted,
			regionConverted,
			versionConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}
}
