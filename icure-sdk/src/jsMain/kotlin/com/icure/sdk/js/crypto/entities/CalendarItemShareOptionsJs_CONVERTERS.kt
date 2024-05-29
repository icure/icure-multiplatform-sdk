package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs

public fun calendarItemShareOptions_toJs(obj: CalendarItemShareOptions):
		CalendarItemShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_toJs(obj.sharePatientId)
	return CalendarItemShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun calendarItemShareOptions_fromJs(obj: CalendarItemShareOptionsJs):
		CalendarItemShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_fromJs(obj.sharePatientId)
	return CalendarItemShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
	)
}
