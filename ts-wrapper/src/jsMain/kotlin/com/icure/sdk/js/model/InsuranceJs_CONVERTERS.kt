// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.embed.address_fromJs
import com.icure.sdk.js.model.embed.address_toJs
import com.icure.sdk.model.Insurance
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun insurance_toJs(obj: Insurance): InsuranceJs {
	val id = obj.id
	val rev = nullToUndefined(
		obj.rev
	)
	val deletionDate = nullToUndefined(
		longToNumber(obj.deletionDate)
	)
	val name = mapToObject(
		obj.name,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val privateInsurance = obj.privateInsurance
	val hospitalisationInsurance = obj.hospitalisationInsurance
	val ambulatoryInsurance = obj.ambulatoryInsurance
	val code = nullToUndefined(
		obj.code
	)
	val agreementNumber = nullToUndefined(
		obj.agreementNumber
	)
	val parent = nullToUndefined(
		obj.parent
	)
	val address = address_toJs(obj.address)
	return InsuranceJs(js("{" +
		"id:id," +
		"rev:rev," +
		"deletionDate:deletionDate," +
		"name:name," +
		"privateInsurance:privateInsurance," +
		"hospitalisationInsurance:hospitalisationInsurance," +
		"ambulatoryInsurance:ambulatoryInsurance," +
		"code:code," +
		"agreementNumber:agreementNumber," +
		"parent:parent," +
		"address:address" +
	"}"))
}

public fun insurance_fromJs(obj: InsuranceJs): Insurance {
	val id = obj.id
	val rev = undefinedToNull(obj.rev)
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val name = objectToMap(
		obj.name,
		"obj.name",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val privateInsurance = obj.privateInsurance
	val hospitalisationInsurance = obj.hospitalisationInsurance
	val ambulatoryInsurance = obj.ambulatoryInsurance
	val code = undefinedToNull(obj.code)
	val agreementNumber = undefinedToNull(obj.agreementNumber)
	val parent = undefinedToNull(obj.parent)
	val address = address_fromJs(obj.address)
	return Insurance(
		id = id,
		rev = rev,
		deletionDate = deletionDate,
		name = name,
		privateInsurance = privateInsurance,
		hospitalisationInsurance = hospitalisationInsurance,
		ambulatoryInsurance = ambulatoryInsurance,
		code = code,
		agreementNumber = agreementNumber,
		parent = parent,
		address = address,
	)
}
