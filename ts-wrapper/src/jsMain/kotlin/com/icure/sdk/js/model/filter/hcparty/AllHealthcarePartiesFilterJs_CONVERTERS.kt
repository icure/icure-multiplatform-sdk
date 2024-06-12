package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter

public fun allHealthcarePartiesFilter_toJs(obj: AllHealthcarePartiesFilter):
		AllHealthcarePartiesFilterJs {
	val desc = obj.desc
	return AllHealthcarePartiesFilterJs(js("{" +
		"desc:desc" +
	"}"))
}

public fun allHealthcarePartiesFilter_fromJs(obj: AllHealthcarePartiesFilterJs):
		AllHealthcarePartiesFilter {
	val desc = obj.desc
	return AllHealthcarePartiesFilter(
		desc = desc,
	)
}
