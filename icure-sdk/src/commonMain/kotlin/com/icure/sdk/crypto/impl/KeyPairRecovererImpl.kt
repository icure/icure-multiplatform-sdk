package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.crypto.KeyPairRecoverer
import com.icure.sdk.crypto.RecoveryDataEncryption
import com.icure.sdk.crypto.entities.RecoveryDataKey
import com.icure.sdk.crypto.entities.RecoveryResult
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi

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