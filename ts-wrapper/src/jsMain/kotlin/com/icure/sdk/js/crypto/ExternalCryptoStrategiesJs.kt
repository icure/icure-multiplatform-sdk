@file:JsQualifier("crypto")
package com.icure.sdk.js.crypto

import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.XRsaKeypair
import com.icure.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.sdk.js.model.DataOwnerWithTypeJs
import com.icure.sdk.js.utils.Record
import kotlin.js.Promise

@JsName("CryptoStrategies")
external interface CryptoStrategiesJs {
	fun recoverAndVerifySelfHierarchyKeys(
		keysData: Array<KeyDataRecoveryRequestJs>,
		cryptoPrimitives: XCryptoService,
		keyPairRecoverer: KeyPairRecovererJs
	): Promise<Record<String, RecoveredKeyDataJs>>

	fun generateNewKeyForDataOwner(
		self: DataOwnerWithTypeJs,
		cryptoPrimitives: XCryptoService
	): Promise<dynamic> // boolean | XRsaKeypair

	fun verifyDelegatePublicKeys(
		delegate: CryptoActorStubWithTypeJs,
		publicKeys: Array<String>,
		cryptoPrimitives: XCryptoService
	): Promise<Array<String>>

	fun dataOwnerRequiresAnonymousDelegation(
		dataOwner: CryptoActorStubWithTypeJs
	): Promise<Boolean>
}

@JsName("KeyPairRecoverer")
external interface KeyPairRecovererJs {
	fun recoverWithRecoveryKey(
		recoveryKey: String,
		autoDelete: Boolean
	): Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>
}