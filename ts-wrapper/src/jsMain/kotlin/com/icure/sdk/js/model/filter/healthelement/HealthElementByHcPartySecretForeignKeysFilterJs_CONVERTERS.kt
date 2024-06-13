package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun healthElementByHcPartySecretForeignKeysFilter_toJs(obj: HealthElementByHcPartySecretForeignKeysFilter):
		HealthElementByHcPartySecretForeignKeysFilterJs {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val patientSecretForeignKeys = setToArray(
		obj.patientSecretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	return HealthElementByHcPartySecretForeignKeysFilterJs(js("{" +
		"desc:desc," +
		"healthcarePartyId:healthcarePartyId," +
		"patientSecretForeignKeys:patientSecretForeignKeys" +
	"}"))
}

public
		fun healthElementByHcPartySecretForeignKeysFilter_fromJs(obj: HealthElementByHcPartySecretForeignKeysFilterJs):
		HealthElementByHcPartySecretForeignKeysFilter {
	val desc = obj.desc
	val healthcarePartyId = obj.healthcarePartyId
	val patientSecretForeignKeys = arrayToSet(
		obj.patientSecretForeignKeys,
		"obj.patientSecretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	return HealthElementByHcPartySecretForeignKeysFilter(
		desc = desc,
		healthcarePartyId = healthcarePartyId,
		patientSecretForeignKeys = patientSecretForeignKeys,
	)
}
