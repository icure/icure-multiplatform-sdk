package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthcarePartyByNameFilter_toJs(obj: HealthcarePartyByNameFilter):
		HealthcarePartyByNameFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val name = obj.name
	val descending = nullToUndefined(
		obj.descending
	)
	return HealthcarePartyByNameFilterJs(js("{" +
		"desc:desc," +
		"name:name," +
		"descending:descending" +
	"}"))
}

public fun healthcarePartyByNameFilter_fromJs(obj: HealthcarePartyByNameFilterJs):
		HealthcarePartyByNameFilter {
	val desc = undefinedToNull(obj.desc)
	val name = obj.name
	val descending = undefinedToNull(obj.descending)
	return HealthcarePartyByNameFilter(
		desc = desc,
		name = name,
		descending = descending,
	)
}
