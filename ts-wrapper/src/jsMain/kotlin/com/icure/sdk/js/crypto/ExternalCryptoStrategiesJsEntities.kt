@file:JsQualifier("crypto.CryptoStrategies")
package com.icure.sdk.js.crypto

import com.icure.kryptom.crypto.external.XRsaKeypair
import com.icure.sdk.js.model.DataOwnerWithTypeJs
import com.icure.sdk.js.utils.Record

@JsName("KeyDataRecoveryRequest")
external interface KeyDataRecoveryRequestJs {
	val dataOwnerDetails: DataOwnerWithTypeJs
	val unknownKeys: Array<String>
	val unavailableKeys: Array<String>
}
@JsName("RecoveredKeyData")
external interface RecoveredKeyDataJs {
	val recoveredKeys: Record<String, XRsaKeypair>
	val keyAuthenticity: Record<String, Boolean>
}
