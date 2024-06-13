package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.TimeTableShareOptions
import com.icure.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun timeTableShareOptions_toJs(obj: TimeTableShareOptions): TimeTableShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	return TimeTableShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
	"}"))
}

public fun timeTableShareOptions_fromJs(obj: TimeTableShareOptionsJs): TimeTableShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	return TimeTableShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
	)
}
