package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs
import kotlin.String

public fun patientShareOptions_toJs(obj: PatientShareOptions): PatientShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	val shareSecretIds = setToArray(
		obj.shareSecretIds,
		{ x1: String ->
			x1
		},
	)
	return PatientShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretIds:shareSecretIds," +
	"}"))
}

public fun patientShareOptions_fromJs(obj: PatientShareOptionsJs): PatientShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	val shareSecretIds = arrayToSet(
		obj.shareSecretIds,
		"obj.shareSecretIds",
		{ x1: String ->
			x1
		},
	)
	return PatientShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretIds = shareSecretIds,
	)
}
