// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.HealthElementShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun healthElementShareOptions_toJs(obj: HealthElementShareOptions):
		HealthElementShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val sharePatientId = obj.sharePatientId.name
	return HealthElementShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun healthElementShareOptions_fromJs(obj: HealthElementShareOptionsJs):
		HealthElementShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val sharePatientId = ShareMetadataBehaviour.valueOf(obj.sharePatientId)
	return HealthElementShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
	)
}