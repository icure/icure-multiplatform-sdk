package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.raw.RawRecoveryDataApi
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataRecoveryDetails
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions
import com.icure.cardinal.sdk.crypto.entities.RecoveryKeySize
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi


@InternalIcureApi
interface RecoveryDataEncryption {
	val raw: RawRecoveryDataApi

	/**
	 * Gets the id corresponding to a recovery key
	 */
	suspend fun recoveryKeyToId(recoveryKey: RecoveryDataKey): String

	/**
	 * Creates recovery data with the provided key pairs.
	 * @param recipient the id of the data owner which will be able to use the recovery data.
	 * @param keyPairs a map containing the key pairs to include in the recovery data by delegate id. These should
	 * include the current data owner and optionally his parents.
	 * @param lifetimeSeconds the lifetime of the recovery data in seconds. If null, the recovery data will never expire.
	 */
	suspend fun createAndSaveKeyPairsRecoveryDataFor(
		recipient: String,
		keyPairs: Map<String, List<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>,
		lifetimeSeconds: Int?,
		recoveryKeyOptions: RecoveryKeyOptions?
	): RecoveryDataKey

	/**
	 * Gets the content of the key recovery data corresponding to the provided recovery key.
	 */
	suspend fun getAndDecryptKeyPairsRecoveryData(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>>

	/**
	 * Gets the content of the key recovery data corresponding to the provided recovery key.
	 */
	suspend fun waitAndDecryptKeyPairsRecoveryData(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean,
		waitSeconds: Int
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
		lifetimeSeconds: Int?,
		recoveryKeyOptions: RecoveryKeyOptions?
	): RecoveryDataKey

	/**
	 * Gets the content of the exchange data recovery data corresponding to the provided recovery key.
	 */
	suspend fun getAndDecryptExchangeDataRecoveryData(
		recoveryKey: RecoveryDataKey
	): RecoveryResult<List<ExchangeDataRecoveryDetails>>

	suspend fun generateNewKey(size: RecoveryKeySize): RecoveryDataKey
}
