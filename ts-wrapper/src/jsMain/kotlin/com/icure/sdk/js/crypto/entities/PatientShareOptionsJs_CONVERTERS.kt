package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.requests.RequestedPermission
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientShareOptions_toJs(obj: PatientShareOptions): PatientShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
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
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareSecretIds = arrayToSet(
		obj.shareSecretIds,
		"obj.shareSecretIds",
		{ x1: String ->
			x1
		},
	)
	return PatientShareOptions(
		shareSecretIds = shareSecretIds,
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
	)
}
