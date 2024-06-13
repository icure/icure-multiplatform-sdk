package com.icure.sdk.js.model.filter.code

import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun codeByRegionTypeLabelLanguageFilter_toJs(obj: CodeByRegionTypeLabelLanguageFilter):
		CodeByRegionTypeLabelLanguageFilterJs {
	val desc = obj.desc ?: undefined
	val region = obj.region ?: undefined
	val type = obj.type
	val language = obj.language
	val label = obj.label ?: undefined
	return CodeByRegionTypeLabelLanguageFilterJs(js("{" +
		"desc:desc," +
		"region:region," +
		"type:type," +
		"language:language," +
		"label:label" +
	"}"))
}

public fun codeByRegionTypeLabelLanguageFilter_fromJs(obj: CodeByRegionTypeLabelLanguageFilterJs):
		CodeByRegionTypeLabelLanguageFilter {
	val desc = obj.desc
	val region = obj.region
	val type = obj.type
	val language = obj.language
	val label = obj.label
	return CodeByRegionTypeLabelLanguageFilter(
		desc = desc,
		region = region,
		type = type,
		language = language,
		label = label,
	)
}
