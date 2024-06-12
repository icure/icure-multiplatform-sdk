package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.model.requests.RequestedPermission

public fun documentShareOptions_toJs(obj: DocumentShareOptions): DocumentShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val shareMessageId = obj.shareMessageId.name
	return DocumentShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareMessageId:shareMessageId," +
	"}"))
}

public fun documentShareOptions_fromJs(obj: DocumentShareOptionsJs): DocumentShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareMessageId = ShareMetadataBehaviour.valueOf(obj.shareMessageId)
	return DocumentShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareMessageId = shareMessageId,
	)
}
