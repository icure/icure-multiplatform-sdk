package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.TopicShareOptions
import com.icure.sdk.model.requests.RequestedPermission

public fun topicShareOptions_toJs(obj: TopicShareOptions): TopicShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val sharePatientId = obj.sharePatientId.name
	return TopicShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun topicShareOptions_fromJs(obj: TopicShareOptionsJs): TopicShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val sharePatientId = ShareMetadataBehaviour.valueOf(obj.sharePatientId)
	return TopicShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
	)
}
