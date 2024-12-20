package com.icure.cardinal.sdk.crypto

import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.cardinal.sdk.crypto.entities.CardinalKeyInfo
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface UserSignatureKeysManager {
	/**
	 * Get a key which can be used to sign data in order to allow verification of the data authenticity in the future.
	 */
	suspend fun getOrCreateSignatureKeyPair(): CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>>

	/**
	 * Get a key which can be used to verify the authenticity of a signature created by the current data owner.
	 * @param fingerprint v2 fingerprint of the key to retrieve.
	 * @return all available verification keys by fingerprint.
	 */
	suspend fun getSignatureVerificationKey(fingerprint: KeypairFingerprintV2String): PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256>?
}
