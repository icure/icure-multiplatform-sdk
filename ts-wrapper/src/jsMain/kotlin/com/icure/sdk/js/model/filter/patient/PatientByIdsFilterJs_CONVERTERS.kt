package com.icure.sdk.js.model.filter.patient

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.patient.PatientByIdsFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientByIdsFilter_toJs(obj: PatientByIdsFilter): PatientByIdsFilterJs {
	val ids = setToArray(
		obj.ids,
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return PatientByIdsFilterJs(js("{" +
		"ids:ids," +
		"desc:desc" +
	"}"))
}

public fun patientByIdsFilter_fromJs(obj: PatientByIdsFilterJs): PatientByIdsFilter {
	val ids = arrayToSet(
		obj.ids,
		"obj.ids",
		{ x1: String ->
			x1
		},
	)
	val desc = obj.desc
	return PatientByIdsFilter(
		ids = ids,
		desc = desc,
	)
}
