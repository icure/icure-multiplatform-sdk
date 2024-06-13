package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.filter.contact.ContactByHcPartyTagCodeDateFilter
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun contactByHcPartyTagCodeDateFilter_toJs(obj: ContactByHcPartyTagCodeDateFilter):
		ContactByHcPartyTagCodeDateFilterJs {
	val desc = obj.desc ?: undefined
	val healthcarePartyId = obj.healthcarePartyId ?: undefined
	val tagType = obj.tagType ?: undefined
	val tagCode = obj.tagCode ?: undefined
	val codeType = obj.codeType ?: undefined
	val codeCode = obj.codeCode ?: undefined
	val startOfContactOpeningDate = longToNumber(obj.startOfContactOpeningDate) ?: undefined
	val endOfContactOpeningDate = longToNumber(obj.endOfContactOpeningDate) ?: undefined
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
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val tagType = obj.tagType
	val tagCode = obj.tagCode
	val codeType = obj.codeType
	val codeCode = obj.codeCode
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
