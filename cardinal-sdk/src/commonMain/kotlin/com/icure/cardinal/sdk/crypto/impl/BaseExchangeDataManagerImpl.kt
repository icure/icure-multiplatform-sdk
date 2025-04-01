package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.api.raw.RawExchangeDataApi
import com.icure.cardinal.sdk.crypto.BaseExchangeDataManager
import com.icure.cardinal.sdk.crypto.entities.DataOwnerReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.DecryptionResult
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataWithUnencryptedContent
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.entities.RsaDecryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.crypto.entities.SelfVerifiedKeysSet
import com.icure.cardinal.sdk.crypto.entities.UnencryptedExchangeDataContent
import com.icure.cardinal.sdk.crypto.entities.VerifiedRsaEncryptionKeysSet
import com.icure.cardinal.sdk.crypto.entities.resolve
import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.specializations.AccessControlSecret
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.decode
import com.icure.cardinal.sdk.utils.ensure
import com.icure.cardinal.sdk.utils.pagination.exhaustPaginatedRequest
import com.icure.cardinal.sdk.utils.validateResponseContent
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import com.icure.kryptom.crypto.PrivateRsaKey
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.flow.toList
import kotlinx.serialization.json.JsonPrimitive
import kotlin.reflect.KProperty1

@InternalIcureApi
class BaseExchangeDataManagerImpl(
	override val raw: RawExchangeDataApi,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService,
	private val selfIsAnonymousDataOwner: Boolean,
	private val sdkBoundGroup: SdkBoundGroup?
) : BaseExchangeDataManager {
	override suspend fun getAllExchangeDataForCurrentDataOwnerIfAllowed(inGroup: String?): List<ExchangeData>? {
		if (!selfIsAnonymousDataOwner) return null
		val selfReferenceString = dataOwnerApi.getCurrentDataOwnerReference()
			.asReferenceStringInGroup(inGroup, sdkBoundGroup)
		return exhaustPaginatedRequest { next ->
			validateResponseContent(next == null || (next.startKey as? JsonPrimitive)?.takeIf { it.isString }?.content == selfReferenceString) {
				"Received next key should be the current data owner id"
			}
			sdkBoundGroup.resolve(inGroup)?.let {
				raw.getExchangeDataByParticipant(
					dataOwnerId = selfReferenceString,
					startDocumentId = next?.startKeyDocId,
					groupId = it
				).successBody()
			} ?: if (selfReferenceString.contains('/')) {
				raw.getExchangeDataByParticipantQuery(
					dataOwnerId = selfReferenceString,
					startDocumentId = next?.startKeyDocId,
				).successBody()
			} else {
				// TODO Temporary, to allow still usage of new cardinal sdk without using inter-group sharing also on older kraken versions
				raw.getExchangeDataByParticipant(
					dataOwnerId = selfReferenceString,
					startDocumentId = next?.startKeyDocId,
				).successBody()
			}
		}.toList()
	}

	override suspend fun getExchangeDataByDelegatorDelegatePair(
		inGroup: String?,
		delegatorReference: DataOwnerReferenceInGroup,
		delegateReference: DataOwnerReferenceInGroup
	): List<ExchangeData> {
		val delegatorReferenceString = delegatorReference.asReferenceStringInGroup(inGroup, sdkBoundGroup)
		val delegateReferenceString = delegateReference.asReferenceStringInGroup(inGroup, sdkBoundGroup)
		return sdkBoundGroup.resolve(inGroup)?.let {
			raw.getExchangeDataByDelegatorDelegate(
				delegatorId = delegatorReferenceString,
				delegateId = delegateReferenceString,
				groupId = it
			).successBody()
		} ?: if (delegatorReferenceString.contains('/') || delegateReferenceString.contains('/')) {
			raw.getExchangeDataByDelegatorDelegateQuery(
				delegatorId = delegatorReferenceString,
				delegateId = delegateReferenceString
			).successBody()
		} else {
			// TODO Temporary, to allow still usage of new cardinal sdk without using inter-group sharing also on older kraken versions
			raw.getExchangeDataByDelegatorDelegate(
				delegatorId = delegatorReferenceString,
				delegateId = delegateReferenceString
			).successBody()
		}
	}

	override suspend fun getExchangeDataByIds(
		inGroup: String?,
		exchangeDataIds: Collection<String>
	): List<ExchangeData> =
		sdkBoundGroup.resolve(inGroup)?.let {
			raw.getExchangeDataByIds(
				exchangeDataIds = ListOfIds(exchangeDataIds.toList()),
				groupId = it
			).successBody()
		} ?: raw.getExchangeDataByIds(
			exchangeDataIds = ListOfIds(exchangeDataIds.toList()),
		).successBody()

	override suspend fun verifyExchangeData(
		data: ExchangeDataWithUnencryptedContent,
		delegatorSignatureKeys: SelfVerifiedKeysSet,
		verifyAsDelegator: Boolean
	): Boolean {
		if (
			verifyAsDelegator && (
				data.exchangeData.delegator !== dataOwnerApi.getCurrentDataOwnerId()
				|| !(verifyDelegatorSignature(data.exchangeData, data.unencryptedContent.sharedSignatureKey, delegatorSignatureKeys))
			)
		) return false
		val sharedSignatureData = bytesToSignForSharedSignature(
			delegator = data.exchangeData.delegator,
			delegate = data.exchangeData.delegate,
			decryptedAccessControlSecret = data.unencryptedContent.accessControlSecret,
			decryptedExchangeKey = data.unencryptedContent.exchangeKey,
			publicKeysFingerprints = (
				data.exchangeData.exchangeKey.keys
					+ data.exchangeData.accessControlSecret.keys
					+ data.exchangeData.sharedSignatureKey.keys
			)
		)
		return cryptoService.hmac.verify(
			signature = data.exchangeData.sharedSignature.decode(),
			data = sharedSignatureData,
			key = data.unencryptedContent.sharedSignatureKey
		)
	}

	override suspend fun tryDecryptAccessControlSecret(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, AccessControlSecret> =
		tryDecryptExchangeData(
			exchangeData,
			decryptionKeys,
			ExchangeData::accessControlSecret,
			::importAccessControlSecret
		)

	override suspend fun tryDecryptExchangeKeys(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, AesKey<AesAlgorithm.CbcWithPkcs7Padding>> =
		tryDecryptExchangeData(
			exchangeData,
			decryptionKeys,
			ExchangeData::exchangeKey,
			::importExchangeKey
		)

	override suspend fun tryDecryptSharedSignatureKeys(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, HmacKey<HmacAlgorithm.HmacSha512>> =
		tryDecryptExchangeData(
			exchangeData,
			decryptionKeys,
			ExchangeData::sharedSignatureKey,
			::importSharedSignatureKey
		)

	override suspend fun createExchangeData(
		inGroup: String?,
		delegateReference: DataOwnerReferenceInGroup,
		signatureKeys: SelfVerifiedKeysSet,
		encryptionKeys: VerifiedRsaEncryptionKeysSet,
		exchangeDataId: String?
	): ExchangeDataWithUnencryptedContent {
		ensure (signatureKeys.isNotEmpty() && encryptionKeys.isNotEmpty()) {
			"At least one signature key and one encryption key should have been provided"
		}
		val (exchangeKey, rawExchangeKey) = generateExchangeKey()
		val (sharedSignatureKey, rawSharedSignatureKey) = generateSharedSignatureKey()
		val (accessControlSecret, rawAccessControlSecret) = generateAccessControlSecret()
		val encryptedExchangeKey = cryptoService.encryptDataWithKeys(rawExchangeKey, encryptionKeys, KeyIdentifierFormat.FingerprintV2)
		val encryptedSharedSignatureKey = cryptoService.encryptDataWithKeys(rawSharedSignatureKey, encryptionKeys, KeyIdentifierFormat.FingerprintV2)
		val encryptedAccessControlSecret = cryptoService.encryptDataWithKeys(rawAccessControlSecret, encryptionKeys, KeyIdentifierFormat.FingerprintV2)
		val delegatorReferenceString = dataOwnerApi.getCurrentDataOwnerReference().asReferenceStringInGroup(inGroup, sdkBoundGroup)
		val delegateReferenceString = delegateReference.asReferenceStringInGroup(inGroup, sdkBoundGroup)
		val sharedSignature = cryptoService.hmac.sign(
			bytesToSignForSharedSignature(
				delegator = delegatorReferenceString,
				delegate = delegateReferenceString,
				decryptedAccessControlSecret = accessControlSecret,
				decryptedExchangeKey = exchangeKey,
				publicKeysFingerprints = encryptionKeys.allKeys.mapTo(mutableSetOf()) { it.pubSpkiHexString.fingerprintV2() }
			),
			sharedSignatureKey
		).base64Encode()
		val delegatorSignatureBytes = bytesToSignForDelegatorSignature(sharedSignatureKey = sharedSignatureKey)
		val delegatorSignature = signatureKeys.allKeys.associate { keyInfo ->
			keyInfo.pubSpkiHexString.fingerprintV2() to cryptoService.hmac.sign(
				delegatorSignatureBytes,
				selfEncryptionKeyToHmac(keyInfo.key)
			).base64Encode()
		}
		val exchangeData = ExchangeData(
			id = exchangeDataId ?: cryptoService.strongRandom.randomUUID(),
			delegator = delegatorReferenceString,
			delegate = delegateReferenceString,
			exchangeKey = encryptedExchangeKey,
			accessControlSecret = encryptedAccessControlSecret,
			sharedSignatureKey = encryptedSharedSignatureKey,
			sharedSignature = sharedSignature,
			delegatorSignature = delegatorSignature
		)
		return ExchangeDataWithUnencryptedContent(
			exchangeData = (
				sdkBoundGroup.resolve(inGroup)?.let { raw.createExchangeData(exchangeData, it) }
					?: raw.createExchangeData(exchangeData)
			).successBody(),
			unencryptedContent = UnencryptedExchangeDataContent(
				exchangeKey = exchangeKey,
				accessControlSecret = accessControlSecret,
				sharedSignatureKey = sharedSignatureKey
			)
		)
	}

	override suspend fun tryRawDecryptExchangeData(
		exchangeData: ExchangeData,
		decryptionKeys: RsaDecryptionKeysSet
	): RawDecryptedExchangeData? {
		val decryptedExchangeKey = tryDecrypt(exchangeData.exchangeKey, decryptionKeys) ?: return null
		val decryptedAccessControlSecret = tryDecrypt(exchangeData.accessControlSecret, decryptionKeys) ?: return null
		val decryptedSharedSignatureKey = tryDecrypt(exchangeData.sharedSignatureKey, decryptionKeys) ?: return null
		return RawDecryptedExchangeData(
			exchangeKey = decryptedExchangeKey,
			accessControlSecret = decryptedAccessControlSecret,
			sharedSignatureKey = decryptedSharedSignatureKey
		)
	}

	override suspend fun tryUpdateExchangeData(
		exchangeData: ExchangeData,
		decryptionKeys: RsaDecryptionKeysSet,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet
	): ExchangeDataWithUnencryptedContent? = tryRawDecryptExchangeData(exchangeData, decryptionKeys)?.let {
		updateExchangeDataWithRawDecryptedContent(
			exchangeData = exchangeData,
			newEncryptionKeys = newEncryptionKeys,
			rawExchangeKey = it.exchangeKey,
			rawAccessControlSecret = it.accessControlSecret,
			rawSharedSignatureKey = it.sharedSignatureKey
		)
	}

	override suspend fun updateExchangeDataWithRawDecryptedContent(
		exchangeData: ExchangeData,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet,
		rawExchangeKey: ByteArray,
		rawAccessControlSecret: ByteArray,
		rawSharedSignatureKey: ByteArray
	): ExchangeDataWithUnencryptedContent {
		val exchangeKey = importExchangeKey(rawExchangeKey)
		val accessControlSecret = importAccessControlSecret(rawAccessControlSecret)
		val sharedSignatureKey = importSharedSignatureKey(rawSharedSignatureKey)
		return updateExchangeDataWithDecryptedContent(
			exchangeData = exchangeData,
			newEncryptionKeys = newEncryptionKeys,
			unencryptedExchangeDataContent = UnencryptedExchangeDataContent(
				exchangeKey = exchangeKey,
				accessControlSecret = accessControlSecret,
				sharedSignatureKey = sharedSignatureKey
			)
		)
	}

	override suspend fun updateExchangeDataWithDecryptedContent(
		exchangeData: ExchangeData,
		newEncryptionKeys: VerifiedRsaEncryptionKeysSet,
		unencryptedExchangeDataContent: UnencryptedExchangeDataContent
	): ExchangeDataWithUnencryptedContent {
		val existingExchangeKeyEntries = exchangeData.exchangeKey.keys.toSet()
		val existingAcsEntries = exchangeData.accessControlSecret.keys.toSet()
		val existingSharedSignatureKeyEntries = exchangeData.sharedSignatureKey.keys.toSet()

		val missingEntries = newEncryptionKeys.allKeys.filter {
			!existingAcsEntries.contains(it.pubSpkiHexString.fingerprintV2()) ||
				!existingExchangeKeyEntries.contains(it.pubSpkiHexString.fingerprintV2()) ||
				!existingSharedSignatureKeyEntries.contains(it.pubSpkiHexString.fingerprintV2())
		}

		if (missingEntries.isEmpty()) {
			return ExchangeDataWithUnencryptedContent(
				exchangeData = exchangeData,
				unencryptedContent = UnencryptedExchangeDataContent(
					exchangeKey = unencryptedExchangeDataContent.exchangeKey,
					accessControlSecret = unencryptedExchangeDataContent.accessControlSecret,
					sharedSignatureKey = unencryptedExchangeDataContent.sharedSignatureKey
				)
			)
		}

		val encryptionKeysForMissingEntries = VerifiedRsaEncryptionKeysSet(missingEntries)
		val updatedExchangeData = exchangeData.copy(
			exchangeKey = exchangeData.exchangeKey + cryptoService.encryptDataWithKeys(
				exportExchangeKey(unencryptedExchangeDataContent.exchangeKey),
				encryptionKeysForMissingEntries,
				KeyIdentifierFormat.FingerprintV2
			),
			accessControlSecret = exchangeData.accessControlSecret + cryptoService.encryptDataWithKeys(
				exportAccessControlSecret(unencryptedExchangeDataContent.accessControlSecret),
				encryptionKeysForMissingEntries,
				KeyIdentifierFormat.FingerprintV2
			),
			sharedSignatureKey = exchangeData.sharedSignatureKey + cryptoService.encryptDataWithKeys(
				exportSharedSignatureKey(unencryptedExchangeDataContent.sharedSignatureKey),
				encryptionKeysForMissingEntries,
				KeyIdentifierFormat.FingerprintV2
			)
		).let {
			val isVerified = verifyExchangeData(
				data = ExchangeDataWithUnencryptedContent(
					exchangeData = exchangeData,
					unencryptedContent = UnencryptedExchangeDataContent(
						exchangeKey = unencryptedExchangeDataContent.exchangeKey,
						accessControlSecret = unencryptedExchangeDataContent.accessControlSecret,
						sharedSignatureKey = unencryptedExchangeDataContent.sharedSignatureKey
					)
				),
				delegatorSignatureKeys = SelfVerifiedKeysSet.empty,
				verifyAsDelegator = false
			)
			if (isVerified) it.copy(
				sharedSignature = cryptoService.hmac.sign(
					bytesToSignForSharedSignature(
						delegator = it.delegator,
						delegate = it.delegate,
						decryptedAccessControlSecret = unencryptedExchangeDataContent.accessControlSecret,
						decryptedExchangeKey = unencryptedExchangeDataContent.exchangeKey,
						publicKeysFingerprints = it.exchangeKey.keys
					),
					unencryptedExchangeDataContent.sharedSignatureKey
				).base64Encode()
			) else it
		}

		return ExchangeDataWithUnencryptedContent(
			exchangeData = raw.modifyExchangeData(updatedExchangeData).successBody(),
			unencryptedContent = UnencryptedExchangeDataContent(
				exchangeKey = unencryptedExchangeDataContent.exchangeKey,
				accessControlSecret = unencryptedExchangeDataContent.accessControlSecret,
				sharedSignatureKey = unencryptedExchangeDataContent.sharedSignatureKey
			)
		)
	}

	private suspend fun <T> tryDecryptExchangeData(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet,
		encryptedData: KProperty1<ExchangeData, Map<KeypairFingerprintV2String, Base64String>>,
		unmarshalDecrypted: suspend (ByteArray) -> T
	): DecryptionResult<ExchangeData, T> {
		val successfulDecryptions = mutableListOf<T>()
		val failedDecryptions = mutableListOf<ExchangeData>()
		exchangeData.forEach { data ->
			kotlin.runCatching {
				tryDecrypt(encryptedData.get(data), decryptionKeys)?.let { unmarshalDecrypted(it) }
			}.getOrNull()?.let {
				successfulDecryptions.add(it)
			} ?: failedDecryptions.add(data)
		}
		return DecryptionResult(failedDecryptions, successfulDecryptions)
	}

	private suspend fun tryDecrypt(
		encryptedData: Map<KeypairFingerprintV2String, Base64String>,
		decryptionKeys: RsaDecryptionKeysSet,
	): ByteArray? =
		cryptoService.decryptDataWithKeys(encryptedData, decryptionKeys, KeyIdentifierFormat.FingerprintV2, EncodedDataFormat.Base64)

	private suspend fun selfEncryptionKeyToHmac(
		key: PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): HmacKey<HmacAlgorithm.HmacSha512> {
		val keyBytes = cryptoService.digest.sha512(cryptoService.rsa.exportPrivateKeyPkcs8(key))
		return cryptoService.hmac.loadKey(HmacAlgorithm.HmacSha512, keyBytes)
	}

	private suspend fun verifyDelegatorSignature(
		exchangeData: ExchangeData,
		sharedSignatureKey: HmacKey<HmacAlgorithm.HmacSha512>,
		delegatorSignatureKeys: SelfVerifiedKeysSet
	): Boolean {
		val delegatorSignatureData = bytesToSignForDelegatorSignature(sharedSignatureKey = sharedSignatureKey)
		/*
		 * Have access to at least a signature key and all the available keys validate the signature
		 */
		return exchangeData.delegatorSignature.mapNotNull { (fp, signature) ->
			delegatorSignatureKeys.getByFingerprintV2(fp)?.let { it to signature }
		}.takeIf { it.isNotEmpty() }?.all { (key, signature) ->
			cryptoService.hmac.verify(
				signature = signature.decode(),
				data = delegatorSignatureData,
				key = selfEncryptionKeyToHmac(key)
			)
		} == true
	}

	private suspend fun bytesToSignForSharedSignature(
		delegator: String,
		delegate: String,
		decryptedAccessControlSecret: AccessControlSecret,
		decryptedExchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		publicKeysFingerprints: Set<KeypairFingerprintV2String>
	): ByteArray =
		buildString {
			append("[[\"delegator\",\"")
			append(delegator)
			append("\"],[\"delegate\",\"")
			append(delegate)
			append("\"],[\"exchangeKey\",\"")
			append(cryptoService.aes.exportKey(decryptedExchangeKey).toHexString())
			append("\"],[\"accessControlSecret\",\"")
			append(decryptedAccessControlSecret)
			append("\"],[\"publicKeysFingerprints\",[")
			publicKeysFingerprints.sortedBy { it.s }.forEachIndexed { index, fingerprint ->
				if (index > 0) append(",\"") else append('"')
				append(fingerprint.s)
				append('"')
			}
			append("]]")
		}.toByteArray(Charsets.UTF_8)

	private suspend fun bytesToSignForDelegatorSignature(
		sharedSignatureKey: HmacKey<HmacAlgorithm.HmacSha512>
	): ByteArray =
		cryptoService.digest.sha256(cryptoService.hmac.exportKey(sharedSignatureKey))

	private suspend fun generateExchangeKey(): Pair<AesKey<AesAlgorithm.CbcWithPkcs7Padding>, ByteArray> =
		cryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding).let { it to cryptoService.aes.exportKey(it) }

	private suspend fun importExchangeKey(decryptedBytes: ByteArray): AesKey<AesAlgorithm.CbcWithPkcs7Padding> =
		cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, decryptedBytes)

	private suspend fun exportExchangeKey(decryptedExchangeKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>): ByteArray =
		cryptoService.aes.exportKey(decryptedExchangeKey)

	private suspend fun generateSharedSignatureKey(): Pair<HmacKey<HmacAlgorithm.HmacSha512>, ByteArray> =
		cryptoService.hmac.generateKey(HmacAlgorithm.HmacSha512).let { it to cryptoService.hmac.exportKey(it) }

	private suspend fun importSharedSignatureKey(decryptedBytes: ByteArray): HmacKey<HmacAlgorithm.HmacSha512> =
		cryptoService.hmac.loadKey(HmacAlgorithm.HmacSha512, decryptedBytes)

	private suspend fun exportSharedSignatureKey(decryptedSharedSignatureKey: HmacKey<HmacAlgorithm>): ByteArray =
		cryptoService.hmac.exportKey(decryptedSharedSignatureKey)

	// Generates a new access control secret
	private fun generateAccessControlSecret(): Pair<AccessControlSecret, ByteArray> =
		cryptoService.strongRandom.randomBytes(16).let { AccessControlSecret(it.toHexString()) to it }

	private fun importAccessControlSecret(decryptedBytes: ByteArray): AccessControlSecret =
		AccessControlSecret(decryptedBytes.toHexString())

	private fun exportAccessControlSecret(decryptedAccessControlSecret: AccessControlSecret): ByteArray =
		hexToByteArray(decryptedAccessControlSecret.s)
}
