package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs

public fun maintenanceTaskShareOptions_toJs(obj: MaintenanceTaskShareOptions):
		MaintenanceTaskShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	return MaintenanceTaskShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
	"}"))
}

public fun maintenanceTaskShareOptions_fromJs(obj: MaintenanceTaskShareOptionsJs):
		MaintenanceTaskShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	return MaintenanceTaskShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
	)
}
