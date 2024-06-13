package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementByHcPartyTagCodeFilter_toJs(obj: HealthElementByHcPartyTagCodeFilter):
		HealthElementByHcPartyTagCodeFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val codeType = nullToUndefined(
		obj.codeType
	)
	val codeCode = nullToUndefined(
		obj.codeCode
	)
	val tagType = nullToUndefined(
		obj.tagType
	)
	val tagCode = nullToUndefined(
		obj.tagCode
	)
	val status = nullToUndefined(
		intToNumber(obj.status)
	)
	return HealthElementByHcPartyTagCodeFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"codeType:codeType," +
		"codeCode:codeCode," +
		"tagType:tagType," +
		"tagCode:tagCode," +
		"status:status" +
	"}"))
}

public fun healthElementByHcPartyTagCodeFilter_fromJs(obj: HealthElementByHcPartyTagCodeFilterJs):
		HealthElementByHcPartyTagCodeFilter {
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val codeType = undefinedToNull(obj.codeType)
	val codeCode = undefinedToNull(obj.codeCode)
	val tagType = undefinedToNull(obj.tagType)
	val tagCode = undefinedToNull(obj.tagCode)
	val status = numberToInt(obj.status, "obj.status")
	return HealthElementByHcPartyTagCodeFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		codeType = codeType,
		codeCode = codeCode,
		tagType = tagType,
		tagCode = tagCode,
		status = status,
	)
}
