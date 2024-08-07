package com.icure.sdk.api

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.KeyPairRecoverer
import com.icure.sdk.crypto.entities.ExchangeDataRecoveryDetails
import com.icure.sdk.crypto.entities.RecoveryDataKey
import com.icure.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.sdk.crypto.entities.RecoveryResult
import com.icure.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.sdk.crypto.entities.map
import com.icure.sdk.crypto.entities.toPublicKeyInfo
import com.icure.sdk.model.RecoveryData
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.InternalIcureException
import com.icure.sdk.utils.base64Encode
import com.icure.sdk.utils.decode
import com.icure.sdk.utils.getLogger
import io.ktor.http.isSuccess

interface RecoveryApi {
	/**
	 * Create recovery data for the logged user and stores it encrypted on the iCure server. This allows the user that created
	 * it to recover all the currently available keypairs at a later time by just providing the string returned by this method to the
	 * {@link recoverKeyPairs} method.
	 *
	 * You can also provide an expiration time for the recovery data (through `options.lifetimeSeconds`). If you do so, the recovery dat
	 * a will be deleted automatically after that amount seconds has passed. If you don't provide an expiration time, the recovery data
	 * will be available until it is explicitly deleted.
	 *
	 * This could be used to:
	 * - Provide some sort of one-use "recovery codes" to the user, which he can use to recover his keypair if he loses
	 *   his device. In this case you should not put any expiration time on the recovery data.
	 * - Provide a way for the user to easily "copy" the key from one device to another. In this case you should put a
	 *   short expiration time on the recovery data (a few minutes), so that it will automatically be deleted if it is
	 *   not used after all.
	 *
	 * # Important
	 *
	 * A malicious user that can login as the creator of the recovery data or that can access directly the database
	 * containing the recovery data will be able to get the private key of the data owner from the recovery key returned
	 * by this method. Therefore, the resulting recovery key must be kept secret, just like a private key.
	 *
	 * @param options optional parameters:
	 * - `includeParentsKeys` if true, the recovery data will also contain any available keypairs for parents data owners.
	 * - `lifetimeSeconds` the amount of seconds the recovery data will be available. If not provided, the recovery data will be available until it is
	 *   explicitly deleted.
	 * @return an hexadecimal string that is the `recoveryKey` which will allow the user to recover his keypair later or
	 * from another device. This value must be kept secret from other users. You can use this value with {@link recoverKeyPairs}
	 */
	suspend fun createRecoveryInfoForAvailableKeyPairs(
		@DefaultValue("false")
		includeParentsKeys: Boolean = false,
		@DefaultValue("null")
		lifetimeSeconds: Int? = null
	): RecoveryDataKey

	/**
	 * Equivalent to [KeyPairRecoverer.recoverWithRecoveryKey]
	 */
	suspend fun recoverKeyPairs(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>>

	/**
	 * Create recovery data that allows the delegate {@link delegateId} recover the content of exchange data from the
	 * current data owner to the delegate.
	 *
	 * This can be useful in the following situations:
	 * - A user lost access to his old keypair and is asking for access back to his data. This is similar to the
	 *   give-access-back mechanism, except that instead of having to verify the public key of the delegate as in the
	 *   give-access-back, the delegator has to provide the recovery key to the delegate: the delegator has to properly
	 *   identify the delegate instead of validating that the public key belongs to the delegate.
	 * - A patient is not yet registered in the system and therefore has no keypair, but the doctor wants to already share
	 *   some data with them. The doctor can create some placeholder exchange data, encrypted only with his own key
	 *   through the {@link IccPatientXApi.forceInitializeExchangeDataToNewlyInvitedPatient} method, then create recovery data
	 *   for it and share the recovery key with the patient. The moment the patient logs in and creates his keypair he
	 *   will use the {@link recoverExchangeData} method to "complete" the placeholder exchange data.
	 *
	 * @param delegateId id of the delegate that needs access to his exchange data from the current data owner. This can't
	 * be the id of the current data owner (you should instead recover the keypair).
	 * @param options optional parameters:
	 * - `lifetimeSeconds` the amount of seconds the recovery data will be available. If not provided, the recovery data will be available until it is
	 *   explicitly deleted.
	 * @return an hexadecimal string that is the `recoveryKey` which will allow the delegate to gain access to the exchange data.
	 * This value must be kept secret from users other than the current data owner and the delegate.
	 * You can use this value with {@link recoverExchangeData}
	 */
	suspend fun createExchangeDataRecoveryInfo(
		delegateId: String,
		@DefaultValue("null")
		lifetimeSeconds: Int? = null
	): RecoveryDataKey

	/**
	 * Recover the content of exchange data from the delegator that created the recovery data at the provided.
	 * {@link recoveryKey} to the current delegate. This will enable the current user to access the exchange data with
	 * any of his private keys available on the device from which this method was called.
	 * The exchange data will be automatically deleted from the server after the process completes successfully.
	 *
	 * @param recoveryKey the result of a call to {@link createExchangeDataRecoveryInfo} by a delegator.
	 * @return null on success or a failure reason if the recovery data could not be used to perform the operation.
	 * @throws If the recovery data is valid but the process fails for other reasons.
	 */
	suspend fun recoverExchangeData(recoveryKey: RecoveryDataKey): RecoveryDataUseFailureReason?

	/**
	 * Deletes the recovery information associated to a certain recovery key. You can use this method with the recovery key for any kind of data,
	 * regardless of how you obtained the recovery key (from the {@link createRecoveryInfoForAvailableKeyPairs} or from the
	 * {@link createExchangeDataRecoveryInfo} methods).
	 * If there is no data associated to the provided recovery key, this method will do nothing.
	 * @param recoveryKey the recovery key associated to the recovery information to delete.
	 */
	suspend fun deleteRecoveryInfo(recoveryKey: RecoveryDataKey)

	/**
	 * Deletes the recovery information associated to a certain data owner, regardless of type.
	 * @param dataOwnerId the data owner for which to delete the recovery data.
	 * @return the number of deleted recovery information.
	 */
	suspend fun deleteAllRecoveryInfoFor(dataOwnerId: String): Int

	/**
	 * Deletes all key pair recovery information for a certain data owner.
	 * @param dataOwnerId the data owner for which to delete the key pair recovery information.
	 * @return the number of deleted key pair recovery information.
	 */
	suspend fun deleteAllKeyPairRecoveryInfoFor(dataOwnerId: String): Int

	/**
	 * Deletes all exchange data recovery information for a certain data owner.
	 * @param dataOwnerId the data owner for which to delete the exchange data recovery information.
	 * @return the number of deleted exchange data recovery information.
	 */
	suspend fun deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Int
}

@InternalIcureApi
internal class RecoveryApiImpl(
	private val crypto: InternalCryptoServices
): RecoveryApi {
	companion object {
		private val log = getLogger("RecoveryApiImpl")
	}

	override suspend fun createRecoveryInfoForAvailableKeyPairs(
		includeParentsKeys: Boolean,
		lifetimeSeconds: Int?
	): RecoveryDataKey {
		val selfId = crypto.dataOwnerApi.getCurrentDataOwnerId()
		val allAvailableKeys = crypto.userEncryptionKeysManager.getCurrentUserHierarchyAvailableKeypairs()
		val dataOwnersToInclude = if (includeParentsKeys) {
			listOf(allAvailableKeys.self, *allAvailableKeys.parents.toTypedArray())
		} else {
			listOf(allAvailableKeys.self)
		}
		val keyPairsToSave = dataOwnersToInclude.associate { dataOwnerKeyInfo ->
			dataOwnerKeyInfo.dataOwnerId to dataOwnerKeyInfo.keys.mapNotNull {
				if (it.isVerified || it.isDevice) {
					it.keyPair.key
				} else null
			}
		}
		return crypto.recoveryDataEncryption.createAndSaveKeyPairsRecoveryDataFor(selfId, keyPairsToSave, lifetimeSeconds)
	}

	override suspend fun recoverKeyPairs(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		crypto.recoveryDataEncryption.getAndDecryptKeyPairsRecoveryData(recoveryKey, autoDelete)

	override suspend fun createExchangeDataRecoveryInfo(delegateId: String, lifetimeSeconds: Int?): RecoveryDataKey {
		val exchangeDataToDelegate = crypto.exchangeDataManager.base.getExchangeDataByDelegatorDelegatePair(
			crypto.dataOwnerApi.getCurrentDataOwnerId(),
			delegateId
		)
		val decryptionKeys = crypto.userEncryptionKeysManager.getDecryptionKeys()
		val decryptedInformation = exchangeDataToDelegate.mapNotNull { exchangeData ->
			crypto.exchangeDataManager.base.tryRawDecryptExchangeData(exchangeData, decryptionKeys)?.let { decryptedData ->
				ExchangeDataRecoveryDetails(
					exchangeDataId = exchangeData.id,
					rawExchangeKey = decryptedData.exchangeKey.base64Encode(),
					rawAccessControlSecret = decryptedData.accessControlSecret.base64Encode(),
					rawSharedSignatureKey = decryptedData.sharedSignatureKey.base64Encode()
				)
			}
		}
		return crypto.recoveryDataEncryption.createAndSaveExchangeDataRecoveryData(delegateId, decryptedInformation, lifetimeSeconds)
	}

	override suspend fun recoverExchangeData(recoveryKey: RecoveryDataKey): RecoveryDataUseFailureReason? =
		crypto.recoveryDataEncryption.getAndDecryptExchangeDataRecoveryData(recoveryKey).map { recoveredExchangeData ->
			val selfEncryptionKeys = VerifiedRsaEncryptionKeysSet(
				crypto.userEncryptionKeysManager.getSelfVerifiedKeys().map { it.toPublicKeyInfo() }
			)
			recoveredExchangeData.forEach { exchangeDataInfo ->
				val retrievedData = crypto.exchangeDataManager.base.getExchangeDataById(exchangeDataInfo.exchangeDataId)
				if (retrievedData == null) {
					log.w { "Could not recover exchange data with id ${exchangeDataInfo.exchangeDataId} as it was not found. Ignoring" }
				} else {
					crypto.exchangeDataManager.base.updateExchangeDataWithRawDecryptedContent(
						retrievedData,
						selfEncryptionKeys,
						exchangeDataInfo.rawExchangeKey.decode(),
						exchangeDataInfo.rawAccessControlSecret.decode(),
						exchangeDataInfo.rawSharedSignatureKey.decode()
					)
				}
			}
		}.let {
			if (it is RecoveryResult.Failure) {
				it.reason
			} else {
				val deleteResult = crypto.recoveryDataEncryption.raw.deleteRecoveryData(crypto.recoveryDataEncryption.recoveryKeyToId(recoveryKey))
				if (!deleteResult.status.isSuccess()) {
					log.w { "Could not delete recovery data with id $recoveryKey after successful recovery: ${deleteResult.status}. Ignoring." }
				}
				crypto.exchangeDataManager.clearOrRepopulateCache()
				null
			}
		}

	override suspend fun deleteRecoveryInfo(recoveryKey: RecoveryDataKey) {
		crypto.recoveryDataEncryption.raw.deleteRecoveryData(
			crypto.recoveryDataEncryption.recoveryKeyToId(recoveryKey)
		).successBody()
	}

	override suspend fun deleteAllRecoveryInfoFor(dataOwnerId: String): Int =
		crypto.recoveryDataEncryption.raw.deleteAllRecoveryDataForRecipient(dataOwnerId).getCount()

	override suspend fun deleteAllKeyPairRecoveryInfoFor(dataOwnerId: String): Int =
		crypto.recoveryDataEncryption.raw.deleteAllRecoveryDataOfTypeForRecipient(
			RecoveryData.Type.KeypairRecovery,
			dataOwnerId
		).getCount()

	override suspend fun deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Int =
		crypto.recoveryDataEncryption.raw.deleteAllRecoveryDataOfTypeForRecipient(
			RecoveryData.Type.ExchangeKeyRecovery,
			dataOwnerId
		).getCount()

	private suspend fun HttpResponse<EncryptedContent>.getCount() =
		successBody().let {
			it.numberValue?.toInt() ?: throw InternalIcureException("Could not parse count from response body: $it")
		}
}