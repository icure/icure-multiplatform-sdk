package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun contactByHcPartyPatientTagCodeDateFilter_toJs(obj: ContactByHcPartyPatientTagCodeDateFilter):
		ContactByHcPartyPatientTagCodeDateFilterJs {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val patientSecretForeignKey = obj.patientSecretForeignKey
	val patientSecretForeignKeys = listToArray(
		obj.patientSecretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val tagType = obj.tagType
	val tagCode = obj.tagCode
	val codeType = obj.codeType
	val codeCode = obj.codeCode
	val startOfContactOpeningDate = longToNumber(obj.startOfContactOpeningDate)
	val endOfContactOpeningDate = longToNumber(obj.endOfContactOpeningDate)
	return ContactByHcPartyPatientTagCodeDateFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"patientSecretForeignKey:patientSecretForeignKey," +
		"patientSecretForeignKeys:patientSecretForeignKeys," +
		"tagType:tagType," +
		"tagCode:tagCode," +
		"codeType:codeType," +
		"codeCode:codeCode," +
		"startOfContactOpeningDate:startOfContactOpeningDate," +
		"endOfContactOpeningDate:endOfContactOpeningDate" +
	"}"))
}

public
		fun contactByHcPartyPatientTagCodeDateFilter_fromJs(obj: ContactByHcPartyPatientTagCodeDateFilterJs):
		ContactByHcPartyPatientTagCodeDateFilter {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val patientSecretForeignKey = obj.patientSecretForeignKey
	val patientSecretForeignKeys = arrayToList(
		obj.patientSecretForeignKeys,
		"obj.patientSecretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val tagType = obj.tagType
	val tagCode = obj.tagCode
	val codeType = obj.codeType
	val codeCode = obj.codeCode
	val startOfContactOpeningDate = numberToLong(obj.startOfContactOpeningDate,
			"obj.startOfContactOpeningDate")
	val endOfContactOpeningDate = numberToLong(obj.endOfContactOpeningDate,
			"obj.endOfContactOpeningDate")
	return ContactByHcPartyPatientTagCodeDateFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		patientSecretForeignKey = patientSecretForeignKey,
		patientSecretForeignKeys = patientSecretForeignKeys,
		tagType = tagType,
		tagCode = tagCode,
		codeType = codeType,
		codeCode = codeCode,
		startOfContactOpeningDate = startOfContactOpeningDate,
		endOfContactOpeningDate = endOfContactOpeningDate,
	)
}
