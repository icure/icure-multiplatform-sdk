package com.icure.sdk.crypto

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import com.icure.sdk.crypto.entities.DecryptionResult
import com.icure.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.sdk.crypto.entities.RsaSignatureKeysSet
import com.icure.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.sdk.model.specializations.AccessControlSecret
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.utils.InternalIcureApi

/**
 * Functions to create and get exchange data.
 * The methods of this api require to pass the appropriate keys for encryption/decryption manually.
 */
@InternalIcureApi
interface BaseExchangeDataManager {
	/**
	 * Get all the exchange data where the current data owner is the delegator or the delegate if the implementation
	 * allows it.
	 * Since "explicit" data owners (usually HCPs) may have a prohibitively high amount of exchange data this method only
	 * returns an array if the current data owner is an "anonymous" data owner (according to the crypto strategies), else
	 * it will return null.
	 * @return all the exchange data for the current data owner or null if the crypto strategies don't allow to retrieve
	 * all data for the current data owner.
	 */
	suspend fun getAllExchangeDataForCurrentDataOwnerIfAllowed(): List<ExchangeData>?

	/**
	 * Get all exchange data for the provided delegator-delegate pair.
	 * @param delegatorId id of a delegator data owner.
	 * @param delegateId id of a delegate data owner.
	 * @return all exchange data for the provided delegator-delegate pair.
	 */
	suspend fun getExchangeDataByDelegatorDelegatePair(delegatorId: String, delegateId: String): List<ExchangeData>

	/**
	 * Get the exchange data with the provided id.
	 * @param exchangeDataId id of the exchange data.
	 * @return the exchange data with the provided id or undefined if no exchange data with such id could be found.
	 */
	suspend fun getExchangeDataById(exchangeDataId: String): ExchangeData?

	/**
	 * Verifies the authenticity of the exchange data by checking the signature.
	 * Note that all exchange data created by data owners other than the current data owner (including members of his hierarchy)
	 * will always be unverified.
	 * @param data information about the exchange data to verify.
	 * @param rsaVerificationKeyProvider provides the rsa verification keys of the current data owenr, used only if verifyAsDelegator is true.
	 * @param verifyAsDelegator if true the method will also verify that the hmac key used for the signature was created by the delegator of the
	 * exchange data. If true and the data was not created by the current data owner this method will return false.
	 * @return the exchange data which could be verified given his signature and the available verification keys.
	 * @throws IllegalArgumentException if any of the provided exchange data has been created by a data owner other than the current data owner.
	 */
	suspend fun verifyExchangeData(
		data: ExchangeDataWithUnencryptedContent,
		rsaVerificationKeyProvider: RsaVerificationKeyProvider,
		verifyAsDelegator: Boolean
	): Boolean

	/**
	 * Extracts and decrypts the access control secret from the provided exchange data.
	 * These need to be hashed together with the entity class in order to get the actual access control key which will be
	 * sent to the server.
	 * @param exchangeData the exchange data from which to extract access control secrets.
	 * @param decryptionKeys rsa key pairs to use for decryption of the access control secret.
	 * @return an object composed of:
	 * - successfulDecryptions: array of all successfully decrypted access control keys
	 * - failedDecryptions: array containing all exchange data for which the access control key could not be decrypted (using the provided keys).
	 */
	suspend fun tryDecryptAccessControlSecret(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, AccessControlSecret>

	/**
	 * Extract and decrypts the exchange keys from the provided exchange data.
	 * @param exchangeData the exchange data from which to extract exchange keys.
	 * @param decryptionKeys rsa key pairs to use for the decryption of the exchange keys.
	 * @return an object composed of:
	 * - successfulDecryptions: array containing the successfully decrypted exchange keys.
	 * - failedDecryptions: array containing all exchange data for which the access control key could not be decrypted (using the provided keys).
	 */
	suspend fun tryDecryptExchangeKeys(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, AesKey>

	/**
	 * Extract and decrypts the shared signature key from the provided exchange data.
	 * @param exchangeData the exchange data from which to extract exchange keys.
	 * @param decryptionKeys rsa key pairs to use for the decryption of the exchange keys.
	 * @return an object composed of:
	 * - successfulDecryptions: array containing the successfully decrypted exchange keys.
	 * - failedDecryptions: array containing all exchange data for which the access control key could not be decrypted (using the provided keys).
	 */
	suspend fun tryDecryptSharedSignatureKeys(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, HmacKey<HmacAlgorithm.HmacSha512>>

	/**
	 * Creates exchange data from the current data owner to the provided delegate, uploading the newly created exchange data to the cloud.
	 * This assumes that the keys have been verified.
	 * @param delegateId id of the delegate for the new exchange data.
	 * @param signatureKeys private keys to use for signing the created data.
	 * @param encryptionKeys public keys to use for the encryption of the exchange data (from delegator and delegate).
	 * @param exchangeDataId allows to specify the id for the new data to create. If null the id will be generated by this
	 * method.
	 * @return the newly created exchange data, and its decrypted exchange key and access control secret.
	 */
	suspend fun createExchangeData(
		delegateId: String,
		signatureKeys: RsaSignatureKeysSet,
		encryptionKeys: VerifiedRsaEncryptionKeysSet,
		exchangeDataId: String? = null
	): ExchangeDataWithUnencryptedContent

	/**
	 * Decrypts the content of the provided exchange data using the provided keys. Does not interpret the decrypted
	 * content, leaving it as raw bytes.
	 * @param exchangeData exchange data to decrypt.
	 * @param decryptionKeys keys to use to extract the content of the exchange data.
	 * @return the decrypted content of the exchange data as raw bytes.
	 */
	suspend fun tryRawDecryptExchangeData(
		exchangeData: ExchangeData,
		decryptionKeys: RsaDecryptionKeysSet
	): RawDecryptedExchangeData?

	/**
	 * Updates existing exchange data and uploads it to the cloud in order to share it also with additional public keys, useful for example in cases
	 * where one of the data owners involved in the exchange data has lost one of his keys.
	 * If the content of the exchange data could not be decrypted using the provided keys the method will not update anything and will return undefined.
	 * This method assumes that the new encryption keys have been verified.
	 * @param exchangeData exchange data to update.
	 * @param decryptionKeys keys to use to extract the content of the exchange data which will be shared with the new keys.
	 * @param newEncryptionKeys new keys to add to the exchange data.
	 * @return the updated exchange data, and its decrypted exchange key and access control secret, or null if the exchange data content could not
	 * be decrypted and the exchange data could not be updated.
	 */
	suspend fun tryUpdateExchangeData(
		exchangeData: ExchangeData,
		decryptionKeys: RsaDecryptionKeysSet,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet
	): ExchangeDataWithUnencryptedContent?

	/**
	 * Same as [tryUpdateExchangeData] but the decrypted content is already provided.
	 */
	suspend fun updateExchangeDataWithRawDecryptedContent(
		exchangeData: ExchangeData,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet,
		rawExchangeKey: ByteArray,
		rawAccessControlSecret: ByteArray,
		rawSharedSignatureKey: ByteArray
	): ExchangeDataWithUnencryptedContent
}
