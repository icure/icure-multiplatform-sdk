package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs

public fun documentShareOptions_toJs(obj: DocumentShareOptions): DocumentShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	val shareMessageId = shareMetadataBehaviour_toJs(obj.shareMessageId)
	return DocumentShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareMessageId:shareMessageId," +
	"}"))
}

public fun documentShareOptions_fromJs(obj: DocumentShareOptionsJs): DocumentShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	val shareMessageId = shareMetadataBehaviour_fromJs(obj.shareMessageId)
	return DocumentShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareMessageId = shareMessageId,
	)
}
