package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.crypto.RecoveryDataEncryption
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class KeyPairRecovererImpl(
	private val recoveryDataEncryption: RecoveryDataEncryption
) : KeyPairRecoverer {
	override suspend fun recoverWithRecoveryKey(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		recoveryDataEncryption.getAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete)
}