package com.icure.sdk.js.model.filter.code

import com.icure.sdk.model.filter.code.AllCodesFilter

public fun allCodesFilter_toJs(obj: AllCodesFilter): AllCodesFilterJs {
	val desc = obj.desc
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
