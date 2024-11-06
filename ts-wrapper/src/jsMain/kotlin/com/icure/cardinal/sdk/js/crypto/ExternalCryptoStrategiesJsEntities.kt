@file:JsQualifier("crypto.CryptoStrategies")
package com.icure.cardinal.sdk.js.crypto

import com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.kryptom.crypto.external.XRsaKeypair

@JsName("KeyDataRecoveryRequest")
external interface KeyDataRecoveryRequestJs {
	val dataOwnerDetails: DataOwnerWithTypeJs
	val unknownKeys: Array<String>
	val unavailableKeys: Array<UnavailableKeyInfoJs>
}
@JsName("RecoveredKeyData")
external interface RecoveredKeyDataJs {
	val recoveredKeys: Record<String, XRsaKeypair>
	val keyAuthenticity: Record<String, Boolean>
}

@JsName("UnavailableKeyInfo")
external interface UnavailableKeyInfoJs {
	val publicKey: String
	val keyAlgorithm: String
}
