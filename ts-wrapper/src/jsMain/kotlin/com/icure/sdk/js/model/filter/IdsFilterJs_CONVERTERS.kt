package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.IdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <O : Identifiable<String>, O_JS : IdentifiableJs<String>>
		idsFilter_toJs(obj: IdsFilter<O>, convertO: (O) -> O_JS): IdsFilterJs<O_JS> {
	val desc = nullToUndefined(
		obj.desc
	)
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	return IdsFilterJs<O_JS>(js("{" +
		"desc:desc," +
		"ids:ids" +
	"}"))
}

public fun <O : IdentifiableJs<String>, O_KT : Identifiable<String>>
		idsFilter_fromJs(obj: IdsFilterJs<O>, convertO: (O) -> O_KT): IdsFilter<O_KT> {
	val desc = undefinedToNull(obj.desc)
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	return IdsFilter<O_KT>(
		desc = desc,
		ids = ids,
	)
}
