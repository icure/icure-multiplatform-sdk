package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceBySecretForeignKeys_toJs(obj: ServiceBySecretForeignKeys):
		ServiceBySecretForeignKeysJs {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val patientSecretForeignKeys = setToArray(
		obj.patientSecretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	return ServiceBySecretForeignKeysJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"patientSecretForeignKeys:patientSecretForeignKeys" +
	"}"))
}

public fun serviceBySecretForeignKeys_fromJs(obj: ServiceBySecretForeignKeysJs):
		ServiceBySecretForeignKeys {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val patientSecretForeignKeys = arrayToSet(
		obj.patientSecretForeignKeys,
		"obj.patientSecretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	return ServiceBySecretForeignKeys(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		patientSecretForeignKeys = patientSecretForeignKeys,
	)
}
