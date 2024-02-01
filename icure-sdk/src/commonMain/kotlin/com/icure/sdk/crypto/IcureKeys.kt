package com.icure.sdk.crypto

import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaAlgorithm.RsaEncryptionAlgorithm
import com.icure.kryptom.crypto.RsaAlgorithm.RsaSignatureAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.model.KeypairFingerprintV2String
import com.icure.sdk.utils.InternalIcureApi

/**
 * Wrapper for a key pair which also provides its fingerprint.
 */
data class IcureKeypair<A : RsaAlgorithm>(
	val fingerprintV1: String,
	val keypair: RsaKeypair<A>
)

/**
 * Generic container for a set of RSA keys. Allows to retrieve keys by their fingerprint.
 */
@InternalIcureApi
interface RsaKeysSet<KeyType> {
	/**
	 * Get the key associated with the provided fingerprint in v1 format.
	 * @param publicKeyFingerprintV1 a fingerprint in v1 format
	 * @return the key associated with the provided fingerprint, or null if no matching key was found.
	 * @throws IllegalArgumentException if the provided fingerprint is not a valid fingerprint in v1 format.
	 */
	fun getByFingerprintV1(publicKeyFingerprintV1: KeypairFingerprintV1String): KeyType

	/**
	 * Get the key associated with the provided fingerprint in v2 format.
	 * @param publicKeyFingerprintV2 a fingerprint in v2 format
	 * @return the key associated with the provided fingerprint, or null if no matching key was found.
	 * @throws IllegalArgumentException if the provided fingerprint is not a valid fingerprint in v2 format.
	 */
	fun getByFingerprintV2(publicKeyFingerprintV2: KeypairFingerprintV2String): KeyType
}

/**
 * Container for the decryption keys available to a data owner. This usually includes both personal and organisational
 * private keys available to the current data owner. The keys in this container (or part of them) MAY BE UNVERIFIED.
 */
@InternalIcureApi
interface RsaDecryptionKeysSet : RsaKeysSet<PrivateRsaKey<RsaEncryptionAlgorithm>>

/**
 * Container for encryption keys. Usually these include keys of the current data owner and keys of a "delegate" data
 * owner. This is generally used to support the sharing of data between the two.
 * Important: this container must contain ONLY VERIFIED KEYS.
 */
@InternalIcureApi
interface VerifiedRsaEncryptionKeysSet : RsaKeysSet<PrivateRsaKey<RsaEncryptionAlgorithm>>

/**
 * Container for signature keys. Usually these are the keys of the current data owner.
 * Important: this container must contain ONLY VERIFIED KEYS.
 */
@InternalIcureApi
interface RsaSignatureKeysSet : RsaKeysSet<PrivateRsaKey<RsaSignatureAlgorithm.PssWithSha256>>