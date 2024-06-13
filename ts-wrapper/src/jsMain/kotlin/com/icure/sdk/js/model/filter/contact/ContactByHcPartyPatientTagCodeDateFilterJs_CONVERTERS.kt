package com.icure.sdk.js.model.filter.contact

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun contactByHcPartyPatientTagCodeDateFilter_toJs(obj: ContactByHcPartyPatientTagCodeDateFilter):
		ContactByHcPartyPatientTagCodeDateFilterJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
	val patientSecretForeignKey = nullToUndefined(
		obj.patientSecretForeignKey
	)
	val patientSecretForeignKeys = nullToUndefined(
		listToArray(
			obj.patientSecretForeignKeys,
			{ x1: String ->
				x1
			},
		)
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
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
	val patientSecretForeignKey = undefinedToNull(obj.patientSecretForeignKey)
	val patientSecretForeignKeys = arrayToList(
		obj.patientSecretForeignKeys,
		"obj.patientSecretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val tagType = undefinedToNull(obj.tagType)
	val tagCode = undefinedToNull(obj.tagCode)
	val codeType = undefinedToNull(obj.codeType)
	val codeCode = undefinedToNull(obj.codeCode)
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
