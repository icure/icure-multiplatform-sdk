package com.icure.sdk.js.model.filter.code

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.code.CodeByRegionTypeLabelLanguageFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun codeByRegionTypeLabelLanguageFilter_toJs(obj: CodeByRegionTypeLabelLanguageFilter):
		CodeByRegionTypeLabelLanguageFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val region = nullToUndefined(
		obj.region
	)
	val type = obj.type
	val language = obj.language
	val label = nullToUndefined(
		obj.label
	)
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
	val desc = undefinedToNull(obj.desc)
	val region = undefinedToNull(obj.region)
	val type = obj.type
	val language = obj.language
	val label = undefinedToNull(obj.label)
	return CodeByRegionTypeLabelLanguageFilter(
		desc = desc,
		region = region,
		type = type,
		language = language,
		label = label,
	)
}
