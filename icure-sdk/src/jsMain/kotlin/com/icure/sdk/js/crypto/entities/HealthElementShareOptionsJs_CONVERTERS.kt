package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.HealthElementShareOptions
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs

public fun healthElementShareOptions_toJs(obj: HealthElementShareOptions):
		HealthElementShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_toJs(obj.sharePatientId)
	return HealthElementShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun healthElementShareOptions_fromJs(obj: HealthElementShareOptionsJs):
		HealthElementShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_fromJs(obj.sharePatientId)
	return HealthElementShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
	)
}
