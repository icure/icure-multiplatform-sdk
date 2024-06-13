package com.icure.sdk.js.model.filter.service

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun serviceBySecretForeignKeys_toJs(obj: ServiceBySecretForeignKeys):
		ServiceBySecretForeignKeysJs {
	val desc = nullToUndefined(
		obj.desc
	)
	val healthcarePartyId = nullToUndefined(
		obj.healthcarePartyId
	)
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
	val desc = undefinedToNull(obj.desc)
	val healthcarePartyId = undefinedToNull(obj.healthcarePartyId)
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
