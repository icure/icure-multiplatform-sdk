package com.icure.sdk.crypto

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.SpkiHexString
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable


/**
 * Information on some exchange data and its decrypted content.
 */
@Serializable
@InternalIcureApi
data class ExchangeDataRecoveryDetails(
	val exchangeDataId: String,
	val rawAccessControlSecret: Base64String,
	val rawSharedSignatureKey: Base64String,
	val rawExchangeKey: Base64String
)

@InternalIcureApi
interface RecoveryDataEncryption {
	/**
	 * Gets the id corresponding to a recovery key
	 */
	suspend fun recoveryKeyToId(recoveryKey: String): String

	/**
	 * Creates recovery data with the provided key pairs.
	 * @param recipient the id of the data owner which will be able to use the recovery data.
	 * @param keyPairs a map containing the key pairs to include in the recovery data by delegate id. These should
	 * include the current data owner and optionally his parents.
	 * @param lifetimeSeconds the lifetime of the recovery data in seconds. If null, the recovery data will never expire.
	 */
	suspend fun createAndSaveKeyPairsRecoveryDataFor(
		recipient: String,
		keyPairs: Map<String, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>,
		lifetimeSeconds: Long?
	): String

	/**
	 * Gets the content of the key recovery data corresponding to the provided recovery key.
	 */
	suspend fun getAndDecryptKeyPairsRecoveryData(
		recoveryKey: String,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>>

	/**
	 * Creates recovery data with the provided exchange data.
	 * @param recipient the id of the data owner which will be able to use the recovery data.
	 * @param exchangeDataInfo a list containing the details which can be recovered.
	 * @param lifetimeSeconds the lifetime of the recovery data in seconds. If null, the recovery data will never expire.
	 */
	suspend fun createAndSaveExchangeDataRecoveryData(
	recipient: String,
	exchangeDataInfo: List<ExchangeDataRecoveryDetails>,
	lifetimeSeconds: Long?
	): String

	/**
	 * Gets the content of the exchange data recovery data corresponding to the provided recovery key.
	 */
	suspend fun getAndDecryptExchangeDataRecoveryData(
		recoveryKey: String
	): RecoveryResult<List<ExchangeDataRecoveryDetails>>
}
