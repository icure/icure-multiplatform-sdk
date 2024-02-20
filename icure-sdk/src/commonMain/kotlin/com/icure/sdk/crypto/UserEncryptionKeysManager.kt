package com.icure.sdk.crypto

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.crypto.entities.CachedKeypairDetails
import com.icure.sdk.crypto.entities.IcureKeyInfo
import com.icure.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.sdk.crypto.entities.UserKeyPairInformation
import com.icure.sdk.model.CryptoActorStub
import com.icure.sdk.model.KeypairFingerprintV2String
import com.icure.sdk.model.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi

/**
 * Allows to manage public and private keys for the current user and his parent hierarchy.
 */
@InternalIcureApi
interface UserEncryptionKeysManager {
	interface Factory {
		/**
		 * Details of a newly initialised encryption keys manager.
		 */
		data class InitialisationDetails internal constructor(
			/**
			 * The newly created keys manager.
			 */
			val manager: UserEncryptionKeysManager,
			/**
			 * If the initialisation required a new key to be created, the newly created key, else undefined.
			 */
			val newKey: IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>?
		)

		/**
		 * Initializes a new manager, containing all keys for the current data owner.
		 */
		suspend fun initialise(): InitialisationDetails
	}

	/**
	 * Get all key pairs available for the current data owner and his parents.
	 * @return an object with:
	 * - `self` an object containing the current data owner id and the list of key pairs available for the current data owner with verification details.
	 * - `parents` the list of parents to the current data owner with the list of key pairs available for each parent. The list is ordered from the
	 *   topmost ancestor (at index 0) to the direct parent of the current data owner (at the last index, may be 0).
	 */
	fun getCurrentUserHierarchyAvailableKeypairs(): UserKeyPairInformation

	/**
	 * Get the public keys of available key pairs for the current user in hex-encoded spki representation (uses cached keys: no request is done to the
	 * server).
	 * By setting {@link verifiedOnly} to true only the public keys for verified key pairs will be returned: these will include only key pairs created
	 * on this device or which have been verified using {@link CryptoStrategies} on this device.
	 * @param verifiedOnly if true only the verified public keys will be returned.
	 * @return the spki representation of public keys of available keypairs for the current user.
	 */
	fun getCurrentUserAvailablePublicKeysHex(verifiedOnly: Boolean): Set<SpkiHexString>

	/**
	 * Get the public keys of available key pairs for the current user and his parents in hex-encoded spki representation (uses cached keys: no request
	 * is done to the server).
	 * Note that this will also include unverified keys.
	 * @return the spki representation of public keys of available keypairs for the current user.
	 */
	fun getCurrentUserHierarchyAvailablePublicKeysHex(): Set<SpkiHexString>

	/**
	 * Get a key pair with the provided fingerprint if present.
	 * @param fingerprint a key-pair/public-key fingerprint
	 * @return the pair associated to the fingerprint and a boolean indicating if the pair is verified, if present, else undefined
	 */
	fun getKeyPairForFingerprint(fingerprint: KeypairFingerprintV2String): CachedKeypairDetails?

	/**
	 * Get all verified key pairs for the current data owner which can safely be used for encryption. The keys are in no
	 * particular order. The returned keys include all key pairs created on the current device and all recovered key
	 * pairs which have been verified through the crypto strategies.
	 */
	fun getSelfVerifiedKeys(): Set<IcureKeyInfo<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>

	/**
	 * Get all verified keys for a member of the current data owner hierarchy in no particular order.
	 * @param dataOwner the current data owner or a member of his hierarchy.
	 * @throws IllegalArgumentException if the provided data owner is not part of the current data owner hierarchy
	 */
	fun getVerifiedPublicKeysFor(dataOwner: CryptoActorStub): Set<SpkiHexString>

	/**
	 * Get all key pairs for the current data owner and his parents. These keys should be used only for decryption as they may have not been verified.
	 * @return all key pairs available for decryption.
	 */
	fun getDecryptionKeys(): RsaDecryptionKeysSet

	/**
	 * Forces to reload keys for the current data owner. This could be useful if the data owner has logged in from another device in order to
	 * update the transfer keys.
	 * Concurrent calls to this method are not allowed, however, it is possible (although discouraged) to continue using the previously
	 * cached keys through the other methods while this method is running.
	 * This method will complete only after keys have been reloaded successfully.
	 * @throws IllegalStateException if there are concurrent reloading requests.
	 */
	suspend fun reloadKeys()
}
