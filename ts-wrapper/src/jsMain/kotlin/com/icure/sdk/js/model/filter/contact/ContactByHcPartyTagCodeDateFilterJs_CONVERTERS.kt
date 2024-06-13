package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun contactByHcPartyTagCodeDateFilter_toJs(obj: ContactByHcPartyTagCodeDateFilter):
		ContactByHcPartyTagCodeDateFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
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
	val startOfContactOpeningDate = nullToUndefined(
		longToNumber(obj.startOfContactOpeningDate)
	)
	val endOfContactOpeningDate = nullToUndefined(
		longToNumber(obj.endOfContactOpeningDate)
	)
	return ContactByHcPartyTagCodeDateFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"tagType:tagType," +
		"tagCode:tagCode," +
		"codeType:codeType," +
		"codeCode:codeCode," +
		"startOfContactOpeningDate:startOfContactOpeningDate," +
		"endOfContactOpeningDate:endOfContactOpeningDate" +
	"}"))
}

public fun contactByHcPartyTagCodeDateFilter_fromJs(obj: ContactByHcPartyTagCodeDateFilterJs):
		ContactByHcPartyTagCodeDateFilter {
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val tagType = undefinedToNull(obj.tagType)
	val tagCode = undefinedToNull(obj.tagCode)
	val codeType = undefinedToNull(obj.codeType)
	val codeCode = undefinedToNull(obj.codeCode)
	val startOfContactOpeningDate = numberToLong(obj.startOfContactOpeningDate,
			"obj.startOfContactOpeningDate")
	val endOfContactOpeningDate = numberToLong(obj.endOfContactOpeningDate,
			"obj.endOfContactOpeningDate")
	return ContactByHcPartyTagCodeDateFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		tagType = tagType,
		tagCode = tagCode,
		codeType = codeType,
		codeCode = codeCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
	)
}
