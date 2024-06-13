package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.service.ServiceByHcPartyTagCodeDateFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceByHcPartyTagCodeDateFilter_toJs(obj: ServiceByHcPartyTagCodeDateFilter):
		ServiceByHcPartyTagCodeDateFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val patientSecretForeignKey = nullToUndefined(
		obj.patientSecretForeignKey
	)
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
	val startValueDate = nullToUndefined(
		longToNumber(obj.startValueDate)
	)
	val endValueDate = nullToUndefined(
		longToNumber(obj.endValueDate)
	)
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
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val patientSecretForeignKey = undefinedToNull(obj.patientSecretForeignKey)
	val tagType = undefinedToNull(obj.tagType)
	val tagCode = undefinedToNull(obj.tagCode)
	val codeType = undefinedToNull(obj.codeType)
	val codeCode = undefinedToNull(obj.codeCode)
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
