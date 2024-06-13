package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.ComplementFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <O : Identifiable<String>, O_JS : IdentifiableJs<String>>
		complementFilter_toJs(obj: ComplementFilter<O>, convertO: (O) -> O_JS): ComplementFilterJs<O_JS> {
	val desc = nullToUndefined(
		obj.desc
	)
	val superSet = abstractFilter_toJs(
		obj.superSet,
		{ x1: O ->
			convertO(x1)
		},
	)
	val subSet = abstractFilter_toJs(
		obj.subSet,
		{ x1: O ->
			convertO(x1)
		},
	)
	return ComplementFilterJs<O_JS>(js("{" +
		"desc:desc," +
		"superSet:superSet," +
		"subSet:subSet" +
	"}"))
}

public fun <O : IdentifiableJs<String>, O_KT : Identifiable<String>>
		complementFilter_fromJs(obj: ComplementFilterJs<O>, convertO: (O) -> O_KT):
		ComplementFilter<O_KT> {
	val desc = undefinedToNull(obj.desc)
	val superSet = abstractFilter_fromJs(
		obj.superSet,
		{ x1: O ->
			convertO(x1)
		},
	)
	val subSet = abstractFilter_fromJs(
		obj.subSet,
		{ x1: O ->
			convertO(x1)
		},
	)
	return ComplementFilter<O_KT>(
		desc = desc,
		superSet = superSet,
		subSet = subSet,
	)
}
