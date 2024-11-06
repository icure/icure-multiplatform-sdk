// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun documentShareOptions_toJs(obj: DocumentShareOptions): DocumentShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val shareMessageId = obj.shareMessageId.name
	val shareSecretIds = secretIdShareOptions_toJs(obj.shareSecretIds)
	return DocumentShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareMessageId:shareMessageId," +
		"shareSecretIds:shareSecretIds," +
	"}"))
}

public fun documentShareOptions_fromJs(obj: DocumentShareOptionsJs): DocumentShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareMessageId = ShareMetadataBehaviour.valueOf(obj.shareMessageId)
	val shareSecretIds = secretIdShareOptions_fromJs(obj.shareSecretIds)
	return DocumentShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareMessageId = shareMessageId,
		shareSecretIds = shareSecretIds,
	)
}
