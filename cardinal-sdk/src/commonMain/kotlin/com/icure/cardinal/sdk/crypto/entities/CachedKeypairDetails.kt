package com.icure.cardinal.sdk.crypto.entities

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class CachedKeypairDetails(
	/**
	 * The key pair
	 */
	val keyPair: CardinalKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
	/**
	 * If the keypair authenticity was verified through the [CryptoStrategies] OR through cached verification
	 * information.
	 */
	val isVerified: Boolean,
	/**
	 * If the keypair was created on the current device.
	 */
	val isDevice: Boolean
) {
	/**
	 * If the keypair is safe to use for encryption. True if [isVerified] or [isDevice] is true.
	 */
	val isSafeForEncryption: Boolean = isVerified || isDevice
}