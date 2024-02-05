package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.crypto.IcureKeyRecovery
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.utils.InternalIcureApi

/**
 * Temporary implementation of the key recovery interface. Does not recover anything.
 */
@InternalIcureApi
object NoopKeyRecovery : IcureKeyRecovery{
	override suspend fun recoverKeys(
		dataOwner: DataOwnerWithType,
		knownKeys: Map<KeypairFingerprintV1String, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
	): Map<KeypairFingerprintV1String, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> = emptyMap()
}