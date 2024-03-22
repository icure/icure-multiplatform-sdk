package com.icure.sdk.storage

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.PublicRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm.RsaEncryptionAlgorithm
import com.icure.kryptom.crypto.RsaAlgorithm.RsaSignatureAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.crypto.impl.exportSpkiHex
import com.icure.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.IllegalEntityException
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.ensure
import kotlinx.serialization.encodeToString

/**
 * Simplifies access to the storage facades for iCure-specific data storage.
 */
@InternalIcureApi
class IcureStorageFacade(
	/**
	 * Facade used to store keys, including private keys.
	 */
	private val keys: KeyStorageFacade,
	/**
	 * Used to store non-key data, such as verification result. Won't be used to store anything sensitive.
	 */
	private val data: StorageFacade,
	/**
	 * Factory for the storage entry keys to use, for different kinds of data.
	 */
	private val entryFor: StorageEntryKeysFactory,
	/**
	 * Service used to perform cryptographic operations (import/export keys).
	 */
	private val cryptoService: CryptoService,
	/**
	 * If true, the storage facade will look for keys in the locations used by the typescript SDK <v7.
	 */
	private val lookupKeysInLegacyTsLocations: Boolean
) {
	data class LoadedKeypairDetails(
		val pair: RsaKeypair<RsaEncryptionAlgorithm>,
		val isDevice: Boolean
	)

	/**
	 * Saves an encryption key pair for the data owner.
	 * @param dataOwnerId id of the data owner with the key.
	 * @param keyPair a key pair of the data owner.
	 * @param isDevice true if the key was generated on this device.
	 */
	suspend fun saveEncryptionKeypair(
		dataOwnerId: String,
		keyPair: RsaKeypair<RsaEncryptionAlgorithm>,
		isDevice: Boolean
	) {
		val publicKeyFingerprint = cryptoService.rsa.exportSpkiHex(keyPair.public).fingerprintV1()
		val storageEntryKey = if (isDevice) {
			entryFor.deviceKeypairOfDataOwner(dataOwnerId, publicKeyFingerprint)
		} else {
			entryFor.cachedRecoveredKeypairOfDataOwner(dataOwnerId, publicKeyFingerprint)
		}
		keys.storePrivateKey(storageEntryKey, cryptoService.rsa.exportPrivateKeyPkcs8(keyPair.private))
	}

	/**
	 * Get an existing key pair for the data owner.
	 * @param dataOwnerId id of the data owner with the key.
	 * @param publicKeyFingerprint fingerprint of a public key of the data owner.
	 * @param legacyPublicKey the legacy public key of the data owner, if present (only used to know if we should search for the key in 'legacy' storage
	 * locations.
	 * @return the keypair and if the key was generated on this device or undefined if the key pair could not be found.
	 */
	suspend fun loadEncryptionKeypair(
		dataOwnerId: String,
		publicKeyFingerprint: KeypairFingerprintV1String,
		legacyPublicKey: SpkiHexString?,
		algorithm: RsaEncryptionAlgorithm
	): LoadedKeypairDetails? {
		if (
			legacyPublicKey != null
			&& publicKeyFingerprint == KeypairFingerprintV1String.fromPublicKeySpki(legacyPublicKey)
		) ensure (algorithm == RsaEncryptionAlgorithm.OaepWithSha1) {
			"Required key is the legacy public key, algorithm must be OaepWithSha1, but got $algorithm"
		}
		val deviceKey = keys.getPrivateKeyPkcs8(entryFor.deviceKeypairOfDataOwner(dataOwnerId, publicKeyFingerprint))
			?: if (lookupKeysInLegacyTsLocations) {
				loadKeyFromLegacyAesExchangeKeysLocation(dataOwnerId, publicKeyFingerprint, algorithm)
				?: loadKeyFromLegacySingleKeyLocation(dataOwnerId, publicKeyFingerprint, legacyPublicKey, algorithm)
			} else null
		if (deviceKey != null) return LoadedKeypairDetails(
			pair = cryptoService.rsa.loadKeyPairPkcs8(algorithm, deviceKey),
			isDevice = true
		)
		val cachedKey = keys.getPrivateKeyPkcs8(entryFor.cachedRecoveredKeypairOfDataOwner(dataOwnerId, publicKeyFingerprint))
		if (cachedKey != null) return LoadedKeypairDetails(
			pair = cryptoService.rsa.loadKeyPairPkcs8(algorithm, cachedKey),
			isDevice = false
		)
		return null
	}

	/**
	 * Save the results of public key verification. If there were already results stored the entries will be merged. In case of conflicts the new
	 * {@link verificationDetails} take priority over the stored data.
	 * @param dataOwnerId id of a data owner.
	 * @param verificationDetails results of verification, associates key fingerprints to true if they were verified by the user or false otherwise.
	 * @return the updated keys
	 */
	suspend fun updateAndSaveSelfVerifiedKeys(
		dataOwnerId: String,
		verificationDetails: Map<KeypairFingerprintV1String, Boolean>
	): Map<KeypairFingerprintV1String, Boolean> {
		val stored = loadSelfVerifiedKeys(dataOwnerId)
		val updated = stored + verificationDetails
		data.setItem(
			entryFor.selfPublicKeysVerificationCacheForDataOwner(dataOwnerId),
			Serialization.json.encodeToString(updated)
		)
		return updated
	}

	/**
	 * Get the last saved results of public key verification.
	 * @param dataOwnerId id of a data owner.
	 * @return saved results of verification, associates key fingerprints to true if they were verified by the user or false otherwise. If no results
	 * were saved returns an empty object instead.
	 * @throws IllegalEntityException if the stored results are not in a valid format.
	 */
	suspend fun loadSelfVerifiedKeys(dataOwnerId: String): Map<KeypairFingerprintV1String, Boolean> =
		data.getItem(entryFor.selfPublicKeysVerificationCacheForDataOwner(dataOwnerId))?.let { dataString ->
			try {
				Serialization.json.decodeFromString<Map<KeypairFingerprintV1String, Boolean>>(dataString)
			} catch (e: IllegalArgumentException) {
				throw IllegalEntityException("The stored value is not a valid map of key fingerprints to verification results", e)
			}
		} ?: emptyMap()

	/**
	 * Saves a signature and verification key pair. Overrides previously saved signature keys (but keeps signature verification keys).
	 * @param dataOwnerId id of the data owner with the key.
	 * @param keyPair the key pair to save.
	 */
	suspend fun saveSignatureKeyPair(
		dataOwnerId: String,
		keyPair: RsaKeypair<RsaSignatureAlgorithm.PssWithSha256>
	) {
		val publicKeyFingerprint = cryptoService.rsa.exportSpkiHex(keyPair.public).fingerprintV1()
		keys.storePrivateKey(
			entryFor.signatureKeyForDataOwner(dataOwnerId),
			cryptoService.rsa.exportPrivateKeyPkcs8(keyPair.private)
		)
		keys.storePublicKey(
			entryFor.signatureVerificationKeyForDataOwner(dataOwnerId, publicKeyFingerprint),
			cryptoService.rsa.exportPublicKeySpki(keyPair.public)
		)
	}

	/**
	 * Loads the signature key for the data owner.
	 * @param dataOwnerId id of the data owner with the key.
	 * @return the signature key for the data owner or undefined if there is no signature key stored.
	 */
	suspend fun loadSignatureKey(dataOwnerId: String): RsaKeypair<RsaSignatureAlgorithm.PssWithSha256>? =
		keys.getPrivateKeyPkcs8(entryFor.signatureKeyForDataOwner(dataOwnerId))?.let {
			cryptoService.rsa.loadKeyPairPkcs8(RsaSignatureAlgorithm.PssWithSha256, it)
		}

	/**
	 * Loads the signature verification key for a data owner with the provided fingerprint.
	 * @param dataOwnerId id of the data owner with the key.
	 * @param publicKeyFingerprint fingerprint of the verification key.
	 * @return the requested signature verification key or undefined if the key could not be found.
	 */
	suspend fun loadSignatureVerificationKey(
		dataOwnerId: String,
		publicKeyFingerprint: KeypairFingerprintV1String
	): PublicRsaKey<RsaSignatureAlgorithm.PssWithSha256>? =
		keys.getPublicKeySpki(entryFor.signatureVerificationKeyForDataOwner(dataOwnerId, publicKeyFingerprint))?.let { 
			cryptoService.rsa.loadPublicKeySpki(RsaSignatureAlgorithm.PssWithSha256, it)
		}

	// Lookup in legacy location from before configurability for aes exchange keys
	private suspend fun loadKeyFromLegacyAesExchangeKeysLocation(
		dataOwnerId: String,
		publicKeyFingerprint: KeypairFingerprintV1String,
		algorithm: RsaEncryptionAlgorithm
	): ByteArray? =
		keys.getPrivateKeyPkcs8("org.taktik.icure.rsa.${dataOwnerId}.${publicKeyFingerprint}")?.also {
			ensure(algorithm == RsaEncryptionAlgorithm.OaepWithSha1) {
				"Found a key in legacy aes exchange keys location, algorithm must be OaepWithSha1, but got $algorithm"
			}
		}

	// Lookup in legacy location when data owners could only have one key
	private suspend fun loadKeyFromLegacySingleKeyLocation(
		dataOwnerId: String,
		publicKeyFingerprint: KeypairFingerprintV1String,
		legacyPublicKey: SpkiHexString?,
		algorithm: RsaEncryptionAlgorithm
	): ByteArray? =
		legacyPublicKey?.takeIf {
			KeypairFingerprintV1String.fromPublicKeySpki(it) == publicKeyFingerprint
		}?.let {
			ensure(algorithm == RsaEncryptionAlgorithm.OaepWithSha1) {
				"Required key is the legacy public key, algorithm must be OaepWithSha1, but got $algorithm"
			}
			keys.getPrivateKeyPkcs8("org.taktik.icure.rsa.${dataOwnerId}")
		}
}