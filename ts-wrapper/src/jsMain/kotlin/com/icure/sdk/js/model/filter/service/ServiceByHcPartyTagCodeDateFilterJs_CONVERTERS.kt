package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByHcPartyTagCodeDateFilter_toJs(obj: ServiceByHcPartyTagCodeDateFilter):
		ServiceByHcPartyTagCodeDateFilterJs {
	val desc = obj.desc ?: undefined
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
	val patientSecretForeignKey = obj.patientSecretForeignKey ?: undefined
	val tagType = obj.tagType ?: undefined
	val tagCode = obj.tagCode ?: undefined
	val codeType = obj.codeType ?: undefined
	val codeCode = obj.codeCode ?: undefined
	val startValueDate = longToNumber(obj.startValueDate) ?: undefined
	val endValueDate = longToNumber(obj.endValueDate) ?: undefined
	val descending = obj.descending
	return ServiceByHcPartyTagCodeDateFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"patientSecretForeignKey:patientSecretForeignKey," +
		"tagType:tagType," +
		"tagCode:tagCode," +
		"codeType:codeType," +
		"codeCode:codeCode," +
		"startValueDate:startValueDate," +
		"endValueDate:endValueDate," +
		"descending:descending" +
	"}"))
}

public fun serviceByHcPartyTagCodeDateFilter_fromJs(obj: ServiceByHcPartyTagCodeDateFilterJs):
		ServiceByHcPartyTagCodeDateFilter {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val patientSecretForeignKey = obj.patientSecretForeignKey
	val tagType = obj.tagType
	val tagCode = obj.tagCode
	val codeType = obj.codeType
	val codeCode = obj.codeCode
	val startValueDate = numberToLong(obj.startValueDate, "obj.startValueDate")
	val endValueDate = numberToLong(obj.endValueDate, "obj.endValueDate")
	val descending = obj.descending
	return ServiceByHcPartyTagCodeDateFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		patientSecretForeignKey = patientSecretForeignKey,
		tagType = tagType,
		tagCode = tagCode,
		codeType = codeType,
		codeCode = codeCode,
		startValueDate = startValueDate,
		endValueDate = endValueDate,
		descending = descending,
	)
}
