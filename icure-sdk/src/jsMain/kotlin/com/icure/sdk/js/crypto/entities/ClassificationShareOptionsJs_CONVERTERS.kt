package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.ClassificationShareOptions
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs

public fun classificationShareOptions_toJs(obj: ClassificationShareOptions):
		ClassificationShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_toJs(obj.sharePatientId)
	return ClassificationShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun classificationShareOptions_fromJs(obj: ClassificationShareOptionsJs):
		ClassificationShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_fromJs(obj.sharePatientId)
	return ClassificationShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
	)
}
