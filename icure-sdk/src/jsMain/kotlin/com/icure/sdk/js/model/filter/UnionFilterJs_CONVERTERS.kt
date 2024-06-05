package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.UnionFilter
import kotlin.String

public fun <O : Identifiable<String>, O_JS : IdentifiableJs<String>>
		unionFilter_toJs(obj: UnionFilter<O>, convertO: (O) -> O_JS): UnionFilterJs<O_JS> {
	val desc = obj.desc
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
	return UnionFilterJs<O_JS>(js("{" +
		"desc:desc," +
		"filters:filters" +
	"}"))
}

public fun <O : IdentifiableJs<String>, O_KT : Identifiable<String>>
		unionFilter_fromJs(obj: UnionFilterJs<O>, convertO: (O) -> O_KT): UnionFilter<O_KT> {
	val desc = obj.desc
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
	return UnionFilter<O_KT>(
		desc = desc,
		filters = filters,
	)
}
