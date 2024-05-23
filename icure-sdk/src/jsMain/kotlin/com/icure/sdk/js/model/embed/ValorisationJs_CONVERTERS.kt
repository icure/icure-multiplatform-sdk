package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.model.embed.DecryptedValorisation
import com.icure.sdk.model.embed.EncryptedValorisation
import com.icure.sdk.model.embed.Valorisation
import kotlin.Double
import kotlin.Int
import kotlin.String

public fun valorisation_toJs(obj: DecryptedValorisation): DecryptedValorisationJs {
	val startOfValidity = longToNumber(obj.startOfValidity)
	val endOfValidity = longToNumber(obj.endOfValidity)
	val predicate = obj.predicate
	val reference = listToArray(
		obj.reference,
		{ x1: Int ->
			intToNumber(x1)
		},
	)
	val totalAmount = obj.totalAmount
	val reimbursement = obj.reimbursement
	val patientIntervention = obj.patientIntervention
	val doctorSupplement = obj.doctorSupplement
	val vat = obj.vat
	val label = mapToObject<_, _, String>(
		obj.label,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return DecryptedValorisationJs(js("{" +
		"startOfValidity:startOfValidity," +
		"endOfValidity:endOfValidity," +
		"predicate:predicate," +
		"reference:reference," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"doctorSupplement:doctorSupplement," +
		"vat:vat," +
		"label:label," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun valorisation_fromJs(obj: DecryptedValorisationJs): DecryptedValorisation {
	val startOfValidity = numberToLong(obj.startOfValidity, "obj.startOfValidity")
	val endOfValidity = numberToLong(obj.endOfValidity, "obj.endOfValidity")
	val predicate = obj.predicate
	val reference = arrayToList(
		obj.reference,
		"obj.reference",
		{ x1: Double ->
			numberToInt(x1, "x1")
		},
	)
	val totalAmount = obj.totalAmount
	val reimbursement = obj.reimbursement
	val patientIntervention = obj.patientIntervention
	val doctorSupplement = obj.doctorSupplement
	val vat = obj.vat
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedValorisation(
		startOfValidity = startOfValidity,
		endOfValidity = endOfValidity,
		predicate = predicate,
		reference = reference,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		doctorSupplement = doctorSupplement,
		vat = vat,
		label = label,
		encryptedSelf = encryptedSelf,
	)
}

public fun valorisation_toJs(obj: EncryptedValorisation): EncryptedValorisationJs {
	val startOfValidity = longToNumber(obj.startOfValidity)
	val endOfValidity = longToNumber(obj.endOfValidity)
	val predicate = obj.predicate
	val reference = listToArray(
		obj.reference,
		{ x1: Int ->
			intToNumber(x1)
		},
	)
	val totalAmount = obj.totalAmount
	val reimbursement = obj.reimbursement
	val patientIntervention = obj.patientIntervention
	val doctorSupplement = obj.doctorSupplement
	val vat = obj.vat
	val label = mapToObject<_, _, String>(
		obj.label,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	return EncryptedValorisationJs(js("{" +
		"startOfValidity:startOfValidity," +
		"endOfValidity:endOfValidity," +
		"predicate:predicate," +
		"reference:reference," +
		"totalAmount:totalAmount," +
		"reimbursement:reimbursement," +
		"patientIntervention:patientIntervention," +
		"doctorSupplement:doctorSupplement," +
		"vat:vat," +
		"label:label," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun valorisation_fromJs(obj: EncryptedValorisationJs): EncryptedValorisation {
	val startOfValidity = numberToLong(obj.startOfValidity, "obj.startOfValidity")
	val endOfValidity = numberToLong(obj.endOfValidity, "obj.endOfValidity")
	val predicate = obj.predicate
	val reference = arrayToList(
		obj.reference,
		"obj.reference",
		{ x1: Double ->
			numberToInt(x1, "x1")
		},
	)
	val totalAmount = obj.totalAmount
	val reimbursement = obj.reimbursement
	val patientIntervention = obj.patientIntervention
	val doctorSupplement = obj.doctorSupplement
	val vat = obj.vat
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedValorisation(
		startOfValidity = startOfValidity,
		endOfValidity = endOfValidity,
		predicate = predicate,
		reference = reference,
		totalAmount = totalAmount,
		reimbursement = reimbursement,
		patientIntervention = patientIntervention,
		doctorSupplement = doctorSupplement,
		vat = vat,
		label = label,
		encryptedSelf = encryptedSelf,
	)
}

public fun valorisation_toJs(obj: Valorisation): ValorisationJs = when (obj) {
	is EncryptedValorisation -> valorisation_toJs(obj)
	is DecryptedValorisation -> valorisation_toJs(obj)
}

public fun valorisation_fromJs(obj: ValorisationJs): Valorisation = if (obj.isEncrypted) {
	valorisation_fromJs(obj as EncryptedValorisationJs)
} else {
	valorisation_fromJs(obj as DecryptedValorisationJs)
}
