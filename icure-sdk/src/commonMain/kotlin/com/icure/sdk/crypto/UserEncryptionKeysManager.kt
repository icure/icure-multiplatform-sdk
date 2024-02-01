package com.icure.sdk.crypto

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.model.CryptoActorStub
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class UserKeyPairInformation(
	/**
	 * Id and keys of the current data owner.
	 */
	val selfKeys: Pair<String, EncryptionKeypairDetails>,
	/**
	 * Id and keys of the current data owner parents, starting from the topmost ancestor (at index 0) to the direct parent
	 * of the current data owner (at the last index, may be the same as the topmost ancestor).
	 */
	val parentsKeys: List<Pair<String, EncryptionKeypairDetails>>
)

data class EncryptionKeypairDetails(
	val keyPair: IcureKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
	val isVerified: Boolean
)

/**
 * Allows to manage public and private keys for the current user and his parent hierarchy.
 */
@InternalIcureApi
interface UserEncryptionKeysManager {
	/**
	 * Get all key pairs available for the current data owner and his parents.
	 * @return an object with:
	 * - `self` an object containing the current data owner id and the list of key pairs available for the current data owner with verification details.
	 * - `parents` the list of parents to the current data owner with the list of key pairs available for each parent. The list is ordered from the
	 *   topmost ancestor (at index 0) to the direct parent of the current data owner (at the last index, may be 0).
	 */
	suspend fun getCurrentUserHierarchyAvailableKeypairs(): UserKeyPairInformation

	/**
	 * Get the public keys of available key pairs for the current user in hex-encoded spki representation (uses cached keys: no request is done to the
	 * server).
	 * By setting {@link verifiedOnly} to true only the public keys for verified key pairs will be returned: these will include only key pairs created
	 * on this device or which have been verified using {@link CryptoStrategies} on this device.
	 * @param verifiedOnly if true only the verified public keys will be returned.
	 * @return the spki representation of public keys of available keypairs for the current user.
	 */
	suspend fun getCurrentUserAvailablePublicKeysHex(verifiedOnly: Boolean): List<String>

	/**
	 * Get the public keys of available key pairs for the current user and his parents in hex-encoded spki representation (uses cached keys: no request
	 * is done to the server).
	 * Note that this will also include unverified keys.
	 * @return the spki representation of public keys of available keypairs for the current user.
	 */
	suspend fun getCurrentUserHierarchyAvailablePublicKeysHex(): List<String>

	/**
	 * Get a key pair with the provided fingerprint if present.
	 * @param fingerprint a key-pair/public-key fingerprint
	 * @return the pair associated to the fingerprint and a boolean indicating if the pair is verified, if present, else undefined
	 */
	fun getKeyPairForFingerprint(fingerprint: String): EncryptionKeypairDetails?

	/**
	 * Initializes all keys for the current data owner. This method needs to be called before any other method of this class can be used.
	 * @throws if the current user is not a data owner, or if there is no key and no new key could be created according to this manager crypt
	 * strategies.
	 * @return if a new key was created during initialisation the newly created key and its fingerprint v1, else undefined.
	 */
	suspend fun initialiseKeys(): Pair<KeypairFingerprintV1String, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>

	/**
	 * Forces to reload keys for the current data owner. This could be useful if the data owner has logged in from another device in order to update the
	 * transfer keys.
	 * This method will complete only after keys have been reloaded successfully.
	 */
	suspend fun reloadKeys()

	/**
	 * Get all verified key pairs for the current data owner which can safely be used for encryption. This includes all key pairs created on the current
	 * device and all recovered key pairs which have been verified.
	 * The keys returned by this method will be in the following order:
	 * 1. Legacy key pair if it is verified
	 * 2. All device key pais, in alphabetical order according to the fingerprint
	 * 3. Other verified key pairs, in alphabetical order according to the fingerprint
	 * @return all verified keys, in order.
	 */
	fun getSelfVerifiedKeys(): List<IcureKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>

	/**
	 * Get all verified keys for a member of the current data owner hierarchy in no particular order.
	 * @param dataOwner the current data owner or a member of his hierarchy.
	 * @throws if the provided data owner is not part of the current data owner hierarchy
	 */
	suspend fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): List<String>

	/**
	 * Get all key pairs for the current data owner and his parents. These keys should be used only for decryption as they may have not been verified.
	 * @return all key pairs available for decryption.
	 */
	suspend fun getDecryptionKeys(): RsaDecryptionKeysSet
}
