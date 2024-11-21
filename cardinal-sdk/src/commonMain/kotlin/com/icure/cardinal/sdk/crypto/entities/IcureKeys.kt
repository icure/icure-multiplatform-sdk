package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaAlgorithm.RsaEncryptionAlgorithm
import com.icure.kryptom.crypto.RsaKey
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi

/**
 * Wrapper for a key pair which also provides its fingerprint.
 * Equality is based on the public key hex representation and the type of the key (whether it is only a public key, only
 * a private key or a full key pair). No additional information of the key is used (e.g. the algorithm of the intended
 * key use is ignored).
 */
@InternalIcureApi
class CardinalKeyInfo<out KeyType : RsaKey>(
	val pubSpkiHexString: SpkiHexString,
	val key: KeyType
) {
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is CardinalKeyInfo<*>) return false

		if (pubSpkiHexString != other.pubSpkiHexString) return false
		if (key::class != other.key::class) return false

		return true
	}

	override fun hashCode(): Int {
		var result = pubSpkiHexString.hashCode()
		result = 31 * result + key::class.hashCode()
		return result
	}

	override fun toString(): String {
		return "IcureKeyInfo(pubSpkiHexString=$pubSpkiHexString, keypair=$key)"
	}
}

@InternalIcureApi
fun <A : RsaAlgorithm, K : RsaKeypair<A>> CardinalKeyInfo<K>.toPrivateKeyInfo() =
	CardinalKeyInfo(pubSpkiHexString, key.private)

@InternalIcureApi
fun <A : RsaAlgorithm, K : RsaKeypair<A>> CardinalKeyInfo<K>.toPublicKeyInfo() =
	CardinalKeyInfo(pubSpkiHexString, key.public)

/**
 * Generic container for a set of RSA keys. Allows to retrieve keys by their fingerprint.
 */
@InternalIcureApi
open class RsaKeysSet<KeyType : RsaKey>(
	private val keys: Collection<CardinalKeyInfo<KeyType>>
) {
	private val keysByFingerprintV1: Map<KeypairFingerprintV1String, KeyType> by lazy {
		keys.associate { it.pubSpkiHexString.fingerprintV1() to it.key }
	}

	private val keysByFingerprintV2: Map<KeypairFingerprintV2String, KeyType> by lazy {
		keys.associate { it.pubSpkiHexString.fingerprintV2() to it.key }
	}

	/**
	 * Get the key associated with the provided fingerprint in v1 format.
	 * @param publicKeyFingerprintV1 a fingerprint in v1 format
	 * @return the key associated with the provided fingerprint, or null if no matching key was found.
	 * @throws IllegalArgumentException if the provided fingerprint is not a valid fingerprint in v1 format.
	 */
	fun getByFingerprintV1(publicKeyFingerprintV1: KeypairFingerprintV1String): KeyType? =
		keysByFingerprintV1[publicKeyFingerprintV1]

	/**
	 * Get the key associated with the provided fingerprint in v2 format.
	 * @param publicKeyFingerprintV2 a fingerprint in v2 format
	 * @return the key associated with the provided fingerprint, or null if no matching key was found.
	 * @throws IllegalArgumentException if the provided fingerprint is not a valid fingerprint in v2 format.
	 */
	fun getByFingerprintV2(publicKeyFingerprintV2: KeypairFingerprintV2String): KeyType? =
		keysByFingerprintV2[publicKeyFingerprintV2]

	/**
	 * Get all keys in this set
	 */
	val allKeys: Collection<CardinalKeyInfo<KeyType>> get() = keys

	/**
	 * @true if the set contains at least one element
	 */
	fun isNotEmpty(): Boolean = keys.isNotEmpty()
}

/**
 * Container for the decryption keys available to a data owner. This usually includes both personal and organizational
 * private keys available to the current data owner. The keys in this container (or part of them) MAY BE UNVERIFIED.
 */
@InternalIcureApi
class RsaDecryptionKeysSet(
	keys: Collection<CardinalKeyInfo<PrivateRsaKey<RsaEncryptionAlgorithm>>>
) : RsaKeysSet<PrivateRsaKey<RsaEncryptionAlgorithm>>(keys)

/**
 * Container for encryption keys. Usually these include keys of the current data owner (excludes organization keys) and
 * keys of a "delegate" data owner.
 * This is generally used to support the sharing of data between the two.
 * Important: this container must contain ONLY VERIFIED KEYS.
 */
@InternalIcureApi
class VerifiedRsaEncryptionKeysSet(
	keys: Collection<CardinalKeyInfo<PublicRsaKey<RsaEncryptionAlgorithm>>>
) : RsaKeysSet<PublicRsaKey<RsaEncryptionAlgorithm>>(keys)


/**
 * Container for the verified keys of the current data owner (excludes organization keys).
 * Used for signing and verifying exchange data created by the current data owner.
 */
@InternalIcureApi
class SelfVerifiedKeysSet(
	keys: Collection<CardinalKeyInfo<PrivateRsaKey<RsaEncryptionAlgorithm>>>
) : RsaKeysSet<PrivateRsaKey<RsaEncryptionAlgorithm>>(keys) {
	companion object {
		val empty = SelfVerifiedKeysSet(emptyList())
	}
}