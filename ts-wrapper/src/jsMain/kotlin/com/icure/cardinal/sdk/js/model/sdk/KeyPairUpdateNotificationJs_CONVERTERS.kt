package com.icure.cardinal.sdk.js.model.sdk

import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification

@Suppress("UNUSED_VARIABLE")
public fun keyPairUpdateNotification_toJs(obj: KeyPairUpdateNotification):
		KeyPairUpdateNotificationJs {
	val newPublicKey = spkiHexString_toJs(obj.newPublicKey)
	val concernedDataOwnerId = obj.concernedDataOwnerId
	return KeyPairUpdateNotificationJs(js("{" +
		"newPublicKey:newPublicKey," +
		"concernedDataOwnerId:concernedDataOwnerId" +
	"}"))
}

public fun keyPairUpdateNotification_fromJs(obj: KeyPairUpdateNotificationJs):
		KeyPairUpdateNotification {
	val newPublicKey = spkiHexString_fromJs(obj.newPublicKey)
	val concernedDataOwnerId = obj.concernedDataOwnerId
	return KeyPairUpdateNotification(
		newPublicKey = newPublicKey,
		concernedDataOwnerId = concernedDataOwnerId,
	)
}
