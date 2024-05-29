package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.FormShareOptions
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs

public fun formShareOptions_toJs(obj: FormShareOptions): FormShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_toJs(obj.sharePatientId)
	return FormShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun formShareOptions_fromJs(obj: FormShareOptionsJs): FormShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_fromJs(obj.sharePatientId)
	return FormShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
	)
}
