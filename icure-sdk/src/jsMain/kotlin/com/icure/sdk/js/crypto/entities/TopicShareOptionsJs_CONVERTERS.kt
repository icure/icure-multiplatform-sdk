package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.TopicShareOptions
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs

public fun topicShareOptions_toJs(obj: TopicShareOptions): TopicShareOptionsJs {
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_toJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_toJs(obj.sharePatientId)
	return TopicShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
	"}"))
}

public fun topicShareOptions_fromJs(obj: TopicShareOptionsJs): TopicShareOptions {
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	val shareEncryptionKey = shareMetadataBehaviour_fromJs(obj.shareEncryptionKey)
	val sharePatientId = shareMetadataBehaviour_fromJs(obj.sharePatientId)
	return TopicShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
	)
}
