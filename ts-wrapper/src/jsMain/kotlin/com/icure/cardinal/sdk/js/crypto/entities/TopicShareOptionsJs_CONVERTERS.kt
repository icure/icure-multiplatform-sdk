// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.cardinal.sdk.crypto.entities.TopicShareOptions
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun topicShareOptions_toJs(obj: TopicShareOptions): TopicShareOptionsJs {
	val requestedPermissions = obj.requestedPermissions.name
	val shareEncryptionKey = obj.shareEncryptionKey.name
	val sharePatientId = obj.sharePatientId.name
	val shareSecretIds = secretIdShareOptions_toJs(obj.shareSecretIds)
	return TopicShareOptionsJs(js("{" +
		"requestedPermissions:requestedPermissions," +
		"shareEncryptionKey:shareEncryptionKey," +
		"sharePatientId:sharePatientId," +
		"shareSecretIds:shareSecretIds," +
	"}"))
}

public fun topicShareOptions_fromJs(obj: TopicShareOptionsJs): TopicShareOptions {
	val requestedPermissions = RequestedPermission.valueOf(obj.requestedPermissions)
	val shareEncryptionKey = ShareMetadataBehaviour.valueOf(obj.shareEncryptionKey)
	val sharePatientId = ShareMetadataBehaviour.valueOf(obj.sharePatientId)
	val shareSecretIds = secretIdShareOptions_fromJs(obj.shareSecretIds)
	return TopicShareOptions(
		requestedPermissions = requestedPermissions,
		shareEncryptionKey = shareEncryptionKey,
		sharePatientId = sharePatientId,
		shareSecretIds = shareSecretIds,
	)
}
