// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun patientShareOptions_toJs(obj: PatientShareOptions): PatientShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val shareSecretIds = secretIdShareOptions_toJs(obj.shareSecretIds)
	return PatientShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretIds:shareSecretIds," +
	"}"))
}

public fun patientShareOptions_fromJs(obj: PatientShareOptionsJs): PatientShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareSecretIds = secretIdShareOptions_fromJs(obj.shareSecretIds)
	return PatientShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretIds = shareSecretIds,
	)
}
