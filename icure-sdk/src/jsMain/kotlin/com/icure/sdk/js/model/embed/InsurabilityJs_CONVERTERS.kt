package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.DecryptedInsurability
import com.icure.sdk.model.embed.EncryptedInsurability
import com.icure.sdk.model.embed.Insurability
import kotlin.String

public fun insurability_toJs(obj: DecryptedInsurability): DecryptedInsurabilityJs {
	val parameters = mapToObject<_, _, String>(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = obj.hospitalisation
	val ambulatory = obj.ambulatory
	val dental = obj.dental
	val identificationNumber = obj.identificationNumber
	val insuranceId = obj.insuranceId
	val startDate = longToNumber(obj.startDate)
	val endDate = longToNumber(obj.endDate)
	val titularyId = obj.titularyId
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedInsurabilityJs(js("{" +
		"parameters:parameters," +
		"hospitalisation:hospitalisation," +
		"ambulatory:ambulatory," +
		"dental:dental," +
		"identificationNumber:identificationNumber," +
		"insuranceId:insuranceId," +
		"startDate:startDate," +
		"endDate:endDate," +
		"titularyId:titularyId," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun insurability_fromJs(obj: DecryptedInsurabilityJs): DecryptedInsurability {
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = obj.hospitalisation
	val ambulatory = obj.ambulatory
	val dental = obj.dental
	val identificationNumber = obj.identificationNumber
	val insuranceId = obj.insuranceId
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val titularyId = obj.titularyId
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedInsurability(
		parameters = parameters,
		hospitalisation = hospitalisation,
		ambulatory = ambulatory,
		dental = dental,
		identificationNumber = identificationNumber,
		insuranceId = insuranceId,
		startDate = startDate,
		endDate = endDate,
		titularyId = titularyId,
		encryptedSelf = encryptedSelf,
	)
}

public fun insurability_toJs(obj: EncryptedInsurability): EncryptedInsurabilityJs {
	val parameters = mapToObject<_, _, String>(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = obj.hospitalisation
	val ambulatory = obj.ambulatory
	val dental = obj.dental
	val identificationNumber = obj.identificationNumber
	val insuranceId = obj.insuranceId
	val startDate = longToNumber(obj.startDate)
	val endDate = longToNumber(obj.endDate)
	val titularyId = obj.titularyId
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedInsurabilityJs(js("{" +
		"parameters:parameters," +
		"hospitalisation:hospitalisation," +
		"ambulatory:ambulatory," +
		"dental:dental," +
		"identificationNumber:identificationNumber," +
		"insuranceId:insuranceId," +
		"startDate:startDate," +
		"endDate:endDate," +
		"titularyId:titularyId," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun insurability_fromJs(obj: EncryptedInsurabilityJs): EncryptedInsurability {
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val hospitalisation = obj.hospitalisation
	val ambulatory = obj.ambulatory
	val dental = obj.dental
	val identificationNumber = obj.identificationNumber
	val insuranceId = obj.insuranceId
	val startDate = numberToLong(obj.startDate, "obj.startDate")
	val endDate = numberToLong(obj.endDate, "obj.endDate")
	val titularyId = obj.titularyId
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedInsurability(
		parameters = parameters,
		hospitalisation = hospitalisation,
		ambulatory = ambulatory,
		dental = dental,
		identificationNumber = identificationNumber,
		insuranceId = insuranceId,
		startDate = startDate,
		endDate = endDate,
		titularyId = titularyId,
		encryptedSelf = encryptedSelf,
	)
}

public fun insurability_toJs(obj: Insurability): InsurabilityJs = when (obj) {
	is EncryptedInsurability -> insurability_toJs(obj)
	is DecryptedInsurability -> insurability_toJs(obj)
}

public fun insurability_fromJs(obj: InsurabilityJs): Insurability = if (obj.isEncrypted) {
	insurability_fromJs(obj as EncryptedInsurabilityJs)
} else {
	insurability_fromJs(obj as DecryptedInsurabilityJs)
}
