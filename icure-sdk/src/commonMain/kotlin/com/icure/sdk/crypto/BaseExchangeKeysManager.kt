package com.icure.sdk.crypto

import com.icure.kryptom.crypto.AesKey
import com.icure.sdk.crypto.entities.DataOwnerExchangeKeys
import com.icure.sdk.crypto.entities.DecryptionResult
import com.icure.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.HexString
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.model.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface BaseExchangeKeysManager {
	/**
	 * Updates the aes exchange keys between the current data owner and another data owner to allow the other data owner to access the exchange key
	 * using his new public key.
	 * @param otherDataOwner the other data owner.
	 * @param newDataOwnerPublicKey a new public key of the other data owner.
	 * @param keyPairsByFingerprint all available key pairs to use for the decryption of existing aes exchange keys.
	 */
	suspend fun giveAccessBackTo(
		otherDataOwner: String,
		newDataOwnerPublicKey: SpkiHexString,
		keyPairsByFingerprint: RsaDecryptionKeysSet
	)

	/**
	 * Get the encrypted exchange keys for a delegator-delegate pair.
	 * @param delegatorId id of the delegator data owner.
	 * @param delegateId id of the delegate data owner.
	 * @return a list of exchange keys from the delegator to delegate where each key is encrypted with one or more public keys.
	 */
	suspend fun getEncryptedExchangeKeysFor(
		delegatorId: String,
		delegateId: String
	): List<Map<KeypairFingerprintV1String?, HexString>>

	/**
	 * Get all exchange keys where the provided data owner is involved either as the delegator or as the delegate.
	 * TODO note that this method was changed significantly from the typescript implementation, in order to simplify the interpretation of the content and its usage.
	 * @param dataOwnerId id of a data owner.
	 * @param otherOwnerTypes only exchange keys between the current data owner and data owners of this type will be included in the result.
	 * @return all exchange keys involving the provided data owner. Note that there may be an overlap between some keys to and from the data owner.
	 */
	suspend fun getAllExchangeKeysWith(
		dataOwnerId: String,
		otherOwnerTypes: Set<DataOwnerType>
	): DataOwnerExchangeKeys

	/**
	 * Attempts to decrypt many exchange keys using any of the provided key pairs.
	 * @param encryptedExchangeKeys an array of exchange keys where each key is encrypted with one or more public keys.
	 * @param keyPairsByFingerprint rsa key pairs to use for decryption.
	 * @return an array all successfully decrypted exchange keys and an array containing all exchange keys which could not be decrypted.
	 */
	suspend fun tryDecryptExchangeKeys(
		encryptedExchangeKeys: List<Map<KeypairFingerprintV1String?, HexString>>,
		keyPairsByFingerprint: RsaDecryptionKeysSet
	): DecryptionResult<Map<KeypairFingerprintV1String?, HexString>, AesKey>
}