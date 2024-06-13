package com.icure.sdk.js.model.filter.code

import com.icure.sdk.model.filter.code.AllCodesFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun allCodesFilter_toJs(obj: AllCodesFilter): AllCodesFilterJs {
	val desc = obj.desc ?: undefined
	return AllCodesFilterJs(js("{" +
		"desc:desc" +
	"}"))
}

public fun allCodesFilter_fromJs(obj: AllCodesFilterJs): AllCodesFilter {
	val desc = obj.desc
	return AllCodesFilter(
		desc = desc,
	)
}
