package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthcarePartyByTagCodeFilter_toJs(obj: HealthcarePartyByTagCodeFilter):
		HealthcarePartyByTagCodeFilterJs {
	val tagType = nullToUndefined(
		obj.tagType
	)
	val tagCode = nullToUndefined(
		obj.tagCode
	)
	val codeType = nullToUndefined(
		obj.codeType
	)
	val codeCode = nullToUndefined(
		obj.codeCode
	)
	val desc = nullToUndefined(
		obj.desc
	)
	return HealthcarePartyByTagCodeFilterJs(js("{" +
		"tagType:tagType," +
		"tagCode:tagCode," +
		"codeType:codeType," +
		"codeCode:codeCode," +
		"desc:desc" +
	"}"))
}

public fun healthcarePartyByTagCodeFilter_fromJs(obj: HealthcarePartyByTagCodeFilterJs):
		HealthcarePartyByTagCodeFilter {
	val tagType = undefinedToNull(obj.tagType)
	val tagCode = undefinedToNull(obj.tagCode)
	val codeType = undefinedToNull(obj.codeType)
	val codeCode = undefinedToNull(obj.codeCode)
	val desc = undefinedToNull(obj.desc)
	return HealthcarePartyByTagCodeFilter(
		tagType = tagType,
		tagCode = tagCode,
		codeType = codeType,
		codeCode = codeCode,
		desc = desc,
	)
}
