package com.icure.sdk.js.model.filter.hcparty

import com.icure.sdk.model.filter.hcparty.HealthcarePartyByTagCodeFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthcarePartyByTagCodeFilter_toJs(obj: HealthcarePartyByTagCodeFilter):
		HealthcarePartyByTagCodeFilterJs {
	val tagType = obj.tagType
	val tagCode = obj.tagCode
	val codeType = obj.codeType
	val codeCode = obj.codeCode
	val desc = obj.desc
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
	val tagType = obj.tagType
	val tagCode = obj.tagCode
	val codeType = obj.codeType
	val codeCode = obj.codeCode
	val desc = obj.desc
	return HealthcarePartyByTagCodeFilter(
		tagType = tagType,
		tagCode = tagCode,
		codeType = codeType,
		codeCode = codeCode,
		desc = desc,
	)
}
