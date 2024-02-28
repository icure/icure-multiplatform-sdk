package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.crypto.KeyPairRecoverer
import com.icure.sdk.crypto.entities.RecoveryResult
import com.icure.sdk.model.SpkiHexString

/**
 * TODO Temporary implementation of the key recovery interface. Always fails.
 */
object NoopKeyRecoverer : KeyPairRecoverer {
	override suspend fun recoverWithRecoveryKey(
		recoveryKey: String,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		TODO("This is not yet implemented")
}