package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyTagCodeFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementByHcPartyTagCodeFilter_toJs(obj: HealthElementByHcPartyTagCodeFilter):
		HealthElementByHcPartyTagCodeFilterJs {
	val desc = obj.desc ?: undefined
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
	val codeType = obj.codeType ?: undefined
	val codeCode = obj.codeCode ?: undefined
	val tagType = obj.tagType ?: undefined
	val tagCode = obj.tagCode ?: undefined
	val status = intToNumber(obj.status) ?: undefined
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
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val codeType = obj.codeType
	val codeCode = obj.codeCode
	val tagType = obj.tagType
	val tagCode = obj.tagCode
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
