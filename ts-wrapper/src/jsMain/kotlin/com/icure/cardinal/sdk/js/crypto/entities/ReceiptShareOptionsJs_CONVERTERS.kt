// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.ReceiptShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun receiptShareOptions_toJs(obj: ReceiptShareOptions): ReceiptShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val shareSecretIds = secretIdShareOptions_toJs(obj.shareSecretIds)
	return ReceiptShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretIds:shareSecretIds," +
	"}"))
}

public fun receiptShareOptions_fromJs(obj: ReceiptShareOptionsJs): ReceiptShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareSecretIds = secretIdShareOptions_fromJs(obj.shareSecretIds)
	return ReceiptShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretIds = shareSecretIds,
	)
}
