package com.icure.sdk.crypto

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm.RsaEncryptionAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.HexString
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.model.SpkiHexString

/**
 * Allows to customise the behaviour of the crypto api to better suit your needs.
 *
 * An important task which should be done in these crypto strategies is public key verification: in general there is no guarantee that the public keys
 * stored in the iCure database are authentic, i.e. created by the data owner they are associated to. This is because the database admins or a
 * malicious attacker may have added his own public keys to the data owner's public keys.
 * Sharing any kind of data using unverified public keys could potentially cause a data leak: this is why when creating new exchange keys or when
 * creating recovery data only verified keys will be considered. For decrypting existing data instead unverified keys will be used without issues.
 */
interface CryptoStrategies {
	/**
	 * A request to recover key data that was not found for a user.
	 */
	data class KeyDataRecoveryRequest(
		/**
		 * The data owner for which the key data should be recovered.
		 */
		val dataOwnerDetails: DataOwnerWithType,
		/**
		 * All public keys (in hex-encoded spki format) of `dataOwner` for which the authenticity status (verified or unverified) is
		 * unknown (no result was cached from a previous api instantiation and the key was not generated on the current device).
		 * This could include keys that were recovered automatically by the sdk.
		 */
		val unknownKeys: List<SpkiHexString>,
		/**
		 * All public keys (in hex-encoded spki format) of `dataOwner` for which the sdk could not recover a private key. May overlap
		 * (partially or completely) with `unknownKeys`.
		 */
		val unavailableKeys: List<SpkiHexString>
	)

	/**
	 * Data recovered for a data owner.
	 */
	data class RecoveredKeyData(
		/**
		 * All keys recovered for the data owner (will be automatically considered as verified), by fingerprint.
		 */
		val recoveredKeys: Map<KeypairFingerprintV1String, RsaKeypair<RsaEncryptionAlgorithm>>,
		/**
		 * associates each public key fingerprint its authenticity. Note that if any of the keys from `unknownKeys` is
		 * completely missing from this object the key will be considered as unverified in this api instance (same as
		 * if associated to false), but this value won't be cached (will be again part of `unknownKeys` in future
		 * instances.
		 */
		val keyAuthenticity: Map<KeypairFingerprintV1String, Boolean>
	)

	/**
	 * Specifies how the SDK should behave when a new key pair is required for a data owner.
	 */
	sealed interface KeyGenerationRequestResult {
		/**
		 * Allows the SDK to generate a new key pair for the current data owner.
		 */
		data object Allow : KeyGenerationRequestResult

		/**
		 * The SDK must not generate a new key for the data owner. The SDK initialisation should fail with a predefined
		 * error.
		 */
		data object Deny : KeyGenerationRequestResult

		/**
		 * The SDK should use the provided key pair as a new key for the data owner.
		 */
		data class Use(val keyPair: RsaKeypair<RsaEncryptionAlgorithm.OaepWithSha256>) : KeyGenerationRequestResult
	}

	/**
	 * Method called during initialisation of the crypto API to validate keys recovered through iCure's recovery methods and/or to allow recovery of
	 * missing keys using means external to iCure.
	 * On startup the iCure sdk will try to load all keys for the current data owner and its parent hierarchy: if the sdk can't find some of the keys
	 * for any of the data owners (according to the public keys for the data owner in the iCure server) and/or the sdk could recover some private keys
	 * but can't verify the authenticity of the key pairs this method will be called.
	 * The recovered and verified keys will automatically be cached using the current api {@link KeyStorageFacade} and {@link StorageFacade}
	 *
	 * The input is a list containing an object for each data owner part of the current data owner hierarchy. The objects are ordered from the data
	 * for the topmost parent of the current data owner hierarchy (first element) to the data for the current data owner (last element).
	 *
	 * The returned value must be an object associating to each data owner id an object with:
	 * - `recoveredKeys`:
	 * - `keyAuthenticity`: an object
	 * @param keysData all information on unknown and unavailable keys for each data owner part of the current data owner hierarchy.
	 * @param cryptoPrimitives cryptographic primitives you can use to support the process.
	 * @param keyPairRecoverer a key pair recoverer you can use to support the process
	 * @return a map that associates to each given data owner id the recovered data.
	 */
	suspend fun recoverAndVerifySelfHierarchyKeys(
		keysData: List<KeyDataRecoveryRequest>,
		cryptoPrimitives: CryptoService,
		keyPairRecoverer: KeyPairRecoverer
	): Map<String, RecoveredKeyData>

	/**
	 * The correct initialisation of the crypto API requires that at least 1 verified (or device) key pair is available for each data owner part of the
	 * current data owner hierarchy. If no verified key is available for any of the data owner parents the api initialisation will automatically fail,
	 * however if there is no verified key for the current data owner you can instead create a new crypto key.
	 * @param self the current data owner.
	 * @param cryptoPrimitives cryptographic primitives you can use to support the process.
	 * @return an instance of [KeyGenerationRequestResult] specifying how the SDK should behave.
	 * @throws Exception you can throw any exception, and it will simply propagate to the api initialisation method.
	 */
	suspend fun generateNewKeyForDataOwner(
		self: DataOwnerWithType,
		cryptoPrimitives: CryptoService
	): KeyGenerationRequestResult

	/**
	 * Verifies if the public keys of a data owner which will be the delegate of a new exchange key do actually belong to the person the data owner
	 * represents. This method is not called when the delegate would be the current data owner for the api.
	 *
	 * The user will have to obtain the verified public keys of the delegate from outside iCure, for example by email with another hcp, by checking the
	 * personal website of the other user, or by scanning verification qr codes at the doctor office...
	 *
	 * As long as one of the public keys is verified the creation of a new exchange key will succeed. If no public key is verified the operation will
	 * fail.
	 * @param delegate the potential data owner delegate.
	 * @param publicKeys public keys requiring verification, in spki hex-encoded format.
	 * @param cryptoPrimitives cryptographic primitives you can use to support the process.
	 * @return all verified public keys, in spki hex-encoded format.
	 */
	suspend fun verifyDelegatePublicKeys(
		delegate: CryptoActorStubWithType,
		publicKeys: List<SpkiHexString>,
		cryptoPrimitives: CryptoService
	): List<SpkiHexString>

	/**
	 * Specifies if a data owner requires anonymous delegations, i.e. his id should not appear unencrypted in new secure delegations. This should always
	 * be the case for patient data owners.
	 * @param dataOwner a data owner.
	 * @return true if the delegations for the provided data owner should be anonymous.
	 */
	suspend fun dataOwnerRequiresAnonymousDelegation(dataOwner: CryptoActorStubWithType): Boolean
}