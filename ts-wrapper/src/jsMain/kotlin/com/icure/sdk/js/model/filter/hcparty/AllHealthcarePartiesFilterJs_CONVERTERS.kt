package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun allHealthcarePartiesFilter_toJs(obj: AllHealthcarePartiesFilter):
		AllHealthcarePartiesFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	return AllHealthcarePartiesFilterJs(js("{" +
		"desc:desc" +
	"}"))
}

public fun allHealthcarePartiesFilter_fromJs(obj: AllHealthcarePartiesFilterJs):
		AllHealthcarePartiesFilter {
	val desc = undefinedToNull(obj.desc)
	return AllHealthcarePartiesFilter(
		desc = desc,
	)
}
