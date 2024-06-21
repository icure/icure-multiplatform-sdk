package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.IntersectionFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <O : Identifiable<String>, O_JS : IdentifiableJs<String>>
		intersectionFilter_toJs(obj: IntersectionFilter<O>, convertO: (O) -> O_JS):
		IntersectionFilterJs<O_JS> {
	val desc = nullToUndefined(
		obj.desc
	)
	val filters = listToArray(
		obj.filters,
		{ x1: AbstractFilter<O> ->
			abstractFilter_toJs(
				x1,
				{ x2: O ->
					convertO(x2)
				},
			)
		},
	)
	return IntersectionFilterJs<O_JS>(js("{" +
		"desc:desc," +
		"filters:filters" +
	"}"))
}

public fun <O : IdentifiableJs<String>, O_KT : Identifiable<String>>
		intersectionFilter_fromJs(obj: IntersectionFilterJs<O>, convertO: (O) -> O_KT):
		IntersectionFilter<O_KT> {
	val desc = undefinedToNull(obj.desc)
	val filters = arrayToList(
		obj.filters,
		"obj.filters",
		{ x1: AbstractFilterJs<O> ->
			abstractFilter_fromJs(
				x1,
				{ x2: O ->
					convertO(x2)
				},
			)
		},
	)
	return IntersectionFilter<O_KT>(
		desc = desc,
		filters = filters,
	)
}