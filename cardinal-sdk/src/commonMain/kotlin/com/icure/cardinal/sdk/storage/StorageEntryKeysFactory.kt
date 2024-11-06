package com.icure.cardinal.sdk.storage

import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String

/**
 * Specifies the entry keys to use for storage of data needed by iCure.
 */
interface StorageEntryKeysFactory {
	/**
	 * Get the entry key for the storage of a key pair of a data owner which was created on this device. All keys created on this device will be
	 * considered as verified and safe.
	 * This entry key will be used in a {@link KeyStorageFacade}.
	 * @param dataOwnerId Id of a data owner.
	 * @param publicKeyFingerprint Fingerprint of the public key in a keypair of the data owner.
	 * @return entry key for the keypair.
	 */
	fun deviceKeypairOfDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String

	/**
	 * Get the entry key for the storage of a key pair of a data owner which was recovered from transfer keys or shamir.
	 * These keys are going to be considered as UNSAFE for encryption unless their public key has been verified by the human user and has been stored in
	 * {@link selfPublicKeysVerificationCacheForDataOwner}.
	 * This entry key will be used in a {@link KeyStorageFacade}.
	 * @param dataOwnerId Id of a data owner.
	 * @param publicKeyFingerprint Fingerprint of the public key in a keypair of the data owner.
	 * @return entry key for the keypair.
	 */
	fun cachedRecoveredKeypairOfDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String

	/**
	 * Get the entry key for the storage of answers to own public key verification.
	 * This entry key will be used in a {@link StorageFacade}.
	 * @param dataOwnerId Id of a data owner.
	 * @return entry key for verified public keys of the data owner.
	 */
	fun selfPublicKeysVerificationCacheForDataOwner(dataOwnerId: String): String

	/**
	 * Get the entry key for the storage of the private key of a data owner to use for signature.
	 * @param dataOwnerId Id of a data owner.
	 * @return entry key for signature private key of the data owner.
	 */
	fun signatureKeyForDataOwner(dataOwnerId: String): String

	/**
	 * Get the entry key for the storage of a public key of a data owner to use for signature verification.
	 * @param dataOwnerId Id of a data owner.
	 * @param publicKeyFingerprint fingerprint of the public key.
	 * @return entry key for a signature verification public key of the data owner.
	 */
	fun signatureVerificationKeyForDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String

	/*
	 * There is no need to store verified public keys for other data owners: we verify only when we want to create a new exchange key, and we need to
	 * create an exchange key to each user only once unless we lose our key. But we can lose our key only if we delete our data, which means we would
	 * also used the verified keys for other data owners...
	 */
}
