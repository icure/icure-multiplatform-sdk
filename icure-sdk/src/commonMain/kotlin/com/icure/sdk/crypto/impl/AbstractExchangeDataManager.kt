package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.crypto.AccessControlSecretUtils
import com.icure.sdk.crypto.BaseExchangeDataManager
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.ExchangeDataManager
import com.icure.sdk.crypto.ExchangeDataWithUnencryptedContent
import com.icure.sdk.crypto.IcureKeyInfo
import com.icure.sdk.crypto.RsaSignatureKeysSet
import com.icure.sdk.crypto.UnencryptedExchangeDataContent
import com.icure.sdk.crypto.UserEncryptionKeysManager
import com.icure.sdk.crypto.UserSignatureKeysManager
import com.icure.sdk.crypto.VerifiedRsaEncryptionKeysSet
import com.icure.sdk.crypto.toPrivateKeyInfo
import com.icure.sdk.crypto.toPublicKeyInfo
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.SpkiHexString
import com.icure.sdk.model.extensions.algorithmOfEncryptionKey
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
abstract class AbstractExchangeDataManager(
	protected val base: BaseExchangeDataManager,
	private val userEncryptionKeys: UserEncryptionKeysManager,
	private val signatureKeys: UserSignatureKeysManager,
	private val accessControlSecret: AccessControlSecretUtils,
	private val cryptoStrategies: CryptoStrategies,
	protected val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService,
	private val useParentKeys: Boolean
) : ExchangeDataManager {
	protected data class DecryptedExchangeDataContent(
		val exchangeKey: AesKey,
		val accessControlSecret: String,
		val sharedSignatureKey: HmacKey<HmacAlgorithm.HmacSha512>,
		val verified: Boolean
	)

	protected suspend fun decryptData(
		data: ExchangeData
	): DecryptedExchangeDataContent? {
		val decryptionKeys = userEncryptionKeys.getDecryptionKeys()

		val decryptedExchangeKeyResult = base.tryDecryptExchangeKeys(listOf(data), decryptionKeys)
		val decryptedExchangeKey = decryptedExchangeKeyResult.successfulDecryptions.firstOrNull()
			?: return null

		val decryptedAccessControlSecretResult = base.tryDecryptAccessControlSecret(listOf(data), decryptionKeys)
		val decryptedAccessControlSecret = decryptedAccessControlSecretResult.successfulDecryptions.firstOrNull()
			?: throw Exception("Decryption key could be decrypted but access control secret could not for data $data")

		val decryptedSharedSignatureKeyResult = base.tryDecryptSharedSignatureKeys(listOf(data), decryptionKeys)
		val decryptedSharedSignatureKey = decryptedSharedSignatureKeyResult.successfulDecryptions.firstOrNull()
			?: throw Exception("Decryption key could be decrypted but shared signature key could not for data $data")

		val verified = base.verifyExchangeData(
			ExchangeDataWithUnencryptedContent(
				exchangeData = data,
				UnencryptedExchangeDataContent(
					accessControlSecret = decryptedAccessControlSecret,
					exchangeKey = decryptedExchangeKey,
					sharedSignatureKey = decryptedSharedSignatureKey
				)
			),
			{ fp -> signatureKeys.getSignatureVerificationKey(fp) },
			true
		)

		return DecryptedExchangeDataContent(
			accessControlSecret = decryptedAccessControlSecret,
			exchangeKey = decryptedExchangeKey,
			sharedSignatureKey = decryptedSharedSignatureKey,
			verified = verified
		)
	}

	protected suspend fun createNewExchangeData(
		delegateId: String,
		newDataId: String? = null,
		allowNoDelegateKeys: Boolean = false
	): ExchangeDataWithUnencryptedContent {
		val selfEncryptionKeys = userEncryptionKeys.getSelfVerifiedKeys().map { it.toPublicKeyInfo() }
		val verifiedDelegateKeys = if (delegateId != dataOwnerApi.getCurrentDataOwnerId()) {
			val delegate = dataOwnerApi.getCryptoActorStub(delegateId)
			val delegateKeys = cryptoService.loadEncryptionKeysForDataOwner(delegate.stub)
			if (delegateKeys.isEmpty()) {
				require(allowNoDelegateKeys) { "Delegate $delegateId has no public keys and the current operation does not allow for creation of exchange data without any delegate keys." }
				emptyList()
			} else {
				val delegateKeysBySpki = delegateKeys.associateBy { it.pubSpkiHexString }
				val verifiedSpki = if (useParentKeys && delegateId in dataOwnerApi.getCurrentDataOwnerHierarchyIds()) {
					userEncryptionKeys.getVerifiedPublicKeysFor(delegate.stub).filter { delegateKeysBySpki.containsKey(it) }
				} else {
					cryptoStrategies.verifyDelegatePublicKeys(delegate, delegateKeys.map { it.pubSpkiHexString }, cryptoService)
				}
				require (allowNoDelegateKeys || verifiedSpki.isNotEmpty()) {
					"Could not create exchange data to $delegateId as no public key for the delegate could be verified."
				}
				verifiedSpki.map {
					requireNotNull(delegateKeysBySpki[it]) {
						"Key $it was marked as verified but is not a key of data owner ${delegate.stub.id}"
					}
				}
			}
		} else emptyList()
		val signatureKey = signatureKeys.getOrCreateSignatureKeyPair()
		val allEncryptionKeys = VerifiedRsaEncryptionKeysSet(selfEncryptionKeys + verifiedDelegateKeys)
		return base.createExchangeData(
			delegateId,
			RsaSignatureKeysSet(listOf(signatureKey.toPrivateKeyInfo())),
			allEncryptionKeys,
			newDataId
		)
	}

	override suspend fun giveAccessBackTo(otherDataOwner: String, newDataOwnerPublicKey: SpkiHexString) {
		val self = dataOwnerApi.getCurrentDataOwnerId()
		val other = dataOwnerApi.getCryptoActorStub(otherDataOwner)
		val importedNewKey = cryptoService.rsa.loadPublicKeySpki(
			other.stub.algorithmOfEncryptionKey(newDataOwnerPublicKey),
			newDataOwnerPublicKey.bytes()
		)
		val decryptionKeys = userEncryptionKeys.getDecryptionKeys()
		val allExchangeDataToUpdate = if (self == otherDataOwner) {
			base.getExchangeDataByDelegatorDelegatePair(self, self)
		} else {
			base.getExchangeDataByDelegatorDelegatePair(self, otherDataOwner) + base.getExchangeDataByDelegatorDelegatePair(otherDataOwner, self)
		}
		// Can improve with batch but there should not be many anyway and it is a rare operation
		allExchangeDataToUpdate.forEach {
			base.tryUpdateExchangeData(
				it,
				decryptionKeys,
				VerifiedRsaEncryptionKeysSet(listOf(IcureKeyInfo(newDataOwnerPublicKey, importedNewKey)))
			)
		}
	}
}