package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthcarePartyByIdsFilter_toJs(obj: HealthcarePartyByIdsFilter):
		HealthcarePartyByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = nullToUndefined(
		obj.desc
	)
	return HealthcarePartyByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun healthcarePartyByIdsFilter_fromJs(obj: HealthcarePartyByIdsFilterJs):
		HealthcarePartyByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = undefinedToNull(obj.desc)
	return HealthcarePartyByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
