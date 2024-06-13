package com.icure.sdk.js.model.filter.code

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.code.AllCodesFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun allCodesFilter_toJs(obj: AllCodesFilter): AllCodesFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	return AllCodesFilterJs(js("{" +
		"desc:desc" +
	"}"))
}

public fun allCodesFilter_fromJs(obj: AllCodesFilterJs): AllCodesFilter {
	val desc = undefinedToNull(obj.desc)
	return AllCodesFilter(
		desc = desc,
	)
}
