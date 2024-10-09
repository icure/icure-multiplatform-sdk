@file:JsQualifier("crypto")
package com.icure.cardinal.sdk.js.crypto

import com.icure.cardinal.sdk.js.crypto.entities.RecoveryDataKeyJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.cardinal.sdk.js.externalsdk.CardinalApisJs
import com.icure.cardinal.sdk.js.model.CryptoActorStubWithTypeJs
import com.icure.cardinal.sdk.js.model.DataOwnerWithTypeJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.kryptom.crypto.external.XCryptoService
import com.icure.kryptom.crypto.external.XRsaKeypair
import kotlin.js.Promise

@JsName("CryptoStrategies")
external interface CryptoStrategiesJs {
	val recoverAndVerifySelfHierarchyKeys: ((
		keysData: Array<KeyDataRecoveryRequestJs>,
		cryptoPrimitives: XCryptoService,
		keyPairRecoverer: KeyPairRecovererJs
	) -> Promise<Record<String, RecoveredKeyDataJs>>)?

	val generateNewKeyForDataOwner: ((
		self: DataOwnerWithTypeJs,
		cryptoPrimitives: XCryptoService
	) -> Promise<dynamic>)? // boolean | XRsaKeypair

	val verifyDelegatePublicKeys: ((
		delegate: CryptoActorStubWithTypeJs,
		publicKeys: Array<String>,
		cryptoPrimitives: XCryptoService
	) -> Promise<Array<String>>)?

	val dataOwnerRequiresAnonymousDelegation: ((
		dataOwner: CryptoActorStubWithTypeJs
	) -> Promise<Boolean>)?

	val notifyNewKeyCreated: ((
		apis: CardinalApisJs,
		key: XRsaKeypair,
		cryptoPrimitives: XCryptoService,
	) -> Promise<Unit>)?
}

@JsName("KeyPairRecoverer")
external interface KeyPairRecovererJs {
	fun recoverWithRecoveryKey(
		recoveryKey: RecoveryDataKeyJs,
		autoDelete: Boolean
	): Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>
}