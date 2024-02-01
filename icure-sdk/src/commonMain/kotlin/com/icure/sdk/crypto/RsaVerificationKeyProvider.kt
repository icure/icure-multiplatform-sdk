package com.icure.sdk.crypto

import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm.RsaSignatureAlgorithm
import com.icure.sdk.model.KeypairFingerprintV2String

/**
 * Provides access to public keys of the current user that can be used to verify the authenticity of exchange data.
 */
interface RsaVerificationKeyProvider {
	/**
	 * Provides the public key of the current user that can be used to verify the authenticity of exchange data.
	 * @param fingerprint the fingerprint of the key to retrieve.
	 */
	suspend fun getByFingerprint(fingerprint: KeypairFingerprintV2String): PublicRsaKey<RsaSignatureAlgorithm>?
}