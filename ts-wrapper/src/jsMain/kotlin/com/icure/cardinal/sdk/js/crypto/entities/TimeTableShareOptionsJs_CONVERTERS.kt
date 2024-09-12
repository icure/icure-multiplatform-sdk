// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.TimeTableShareOptions
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun timeTableShareOptions_toJs(obj: TimeTableShareOptions): TimeTableShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val shareSecretIds = secretIdShareOptions_toJs(obj.shareSecretIds)
	return TimeTableShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"shareSecretIds:shareSecretIds," +
	"}"))
}

public fun timeTableShareOptions_fromJs(obj: TimeTableShareOptionsJs): TimeTableShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val shareSecretIds = secretIdShareOptions_fromJs(obj.shareSecretIds)
	return TimeTableShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		shareSecretIds = shareSecretIds,
	)
}
