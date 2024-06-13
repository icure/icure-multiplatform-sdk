package com.icure.sdk.js.model.filter.code

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.code.CodeByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun codeByIdsFilter_toJs(obj: CodeByIdsFilter): CodeByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return CodeByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun codeByIdsFilter_fromJs(obj: CodeByIdsFilterJs): CodeByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return CodeByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
