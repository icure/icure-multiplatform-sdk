package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.DelegateShareOptions
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.requests.requestedPermission_fromJs
import com.icure.sdk.js.model.requests.requestedPermission_toJs
import com.icure.sdk.js.model.specializations.hexString_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.model.specializations.HexString
import kotlin.String

public fun delegateShareOptions_toJs(obj: DelegateShareOptions): DelegateShareOptionsJs {
	val shareSecretIds = setToArray(
		obj.shareSecretIds,
		{ x1: String ->
			x1
		},
	)
	val shareEncryptionKeys = setToArray(
		obj.shareEncryptionKeys,
		{ x1: HexString ->
			hexString_toJs(x1)
		},
	)
	val shareOwningEntityIds = setToArray(
		obj.shareOwningEntityIds,
		{ x1: String ->
			x1
		},
	)
	val requestedPermissions = requestedPermission_toJs(obj.requestedPermissions)
	return DelegateShareOptionsJs(js("{" +
		"shareSecretIds:shareSecretIds," +
		"shareEncryptionKeys:shareEncryptionKeys," +
		"shareOwningEntityIds:shareOwningEntityIds," +
		"requestedPermissions:requestedPermissions" +
	"}"))
}

public fun delegateShareOptions_fromJs(obj: DelegateShareOptionsJs): DelegateShareOptions {
	val shareSecretIds = arrayToSet(
		obj.shareSecretIds,
		"obj.shareSecretIds",
		{ x1: String ->
			x1
		},
	)
	val shareEncryptionKeys = arrayToSet(
		obj.shareEncryptionKeys,
		"obj.shareEncryptionKeys",
		{ x1: String ->
			hexString_fromJs(x1)
		},
	)
	val shareOwningEntityIds = arrayToSet(
		obj.shareOwningEntityIds,
		"obj.shareOwningEntityIds",
		{ x1: String ->
			x1
		},
	)
	val requestedPermissions = requestedPermission_fromJs(obj.requestedPermissions)
	return DelegateShareOptions(
		shareSecretIds = shareSecretIds,
		shareEncryptionKeys = shareEncryptionKeys,
		shareOwningEntityIds = shareOwningEntityIds,
		requestedPermissions = requestedPermissions,
	)
}
