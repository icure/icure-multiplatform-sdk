package com.icure.sdk.crypto.impl

import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.HmacKey
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.api.raw.RawExchangeDataApi
import com.icure.sdk.crypto.BaseExchangeDataManager
import com.icure.sdk.crypto.DecryptionResult
import com.icure.sdk.crypto.ExchangeDataWithUnencryptedContent
import com.icure.sdk.crypto.RawDecryptedExchangeData
import com.icure.sdk.crypto.RsaDecryptionKeysSet
import com.icure.sdk.crypto.RsaSignatureKeysSet
import com.icure.sdk.crypto.RsaVerificationKeyProvider
import com.icure.sdk.crypto.UnencryptedExchangeDataContent
import com.icure.sdk.crypto.VerifiedRsaEncryptionKeysSet
import com.icure.sdk.model.Base64String
import com.icure.sdk.model.ExchangeData
import com.icure.sdk.model.KeypairFingerprintV2String
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.base64Encode
import com.icure.sdk.utils.decode
import com.icure.sdk.utils.ensure
import com.icure.sdk.utils.exhaustPaginatedRequest
import com.icure.sdk.utils.getLogger
import com.icure.sdk.utils.validateResponseContent
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.coroutines.flow.toList
import kotlinx.serialization.json.JsonPrimitive
import kotlin.reflect.KProperty1

@InternalIcureApi
class BaseExchangeDataManagerImpl(
	private val rawApi: RawExchangeDataApi,
	private val dataOwnerApi: DataOwnerApi,
	private val cryptoService: CryptoService,
	private val selfIsAnonymousDataOwner: Boolean
) : BaseExchangeDataManager {
	companion object {
		private val log = getLogger("BaseExchangeDataManager")
	}

	override suspend fun getAllExchangeDataForCurrentDataOwnerIfAllowed(): List<ExchangeData>? {
		if (!selfIsAnonymousDataOwner) return null
		val selfId = dataOwnerApi.getCurrentDataOwnerId()
		return exhaustPaginatedRequest { next ->
			validateResponseContent(next == null || (next.startKey as? JsonPrimitive)?.takeIf { it.isString }?.content == selfId) {
				"Received next key should be the current data owner id"
			}
			rawApi.getExchangeDataByParticipant(selfId, startDocumentId = next?.startKeyDocId).successBody()
		}.toList()
	}

	override suspend fun getExchangeDataByDelegatorDelegatePair(
		delegatorId: String,
		delegateId: String
	): List<ExchangeData> =
		rawApi.getExchangeDataByDelegatorDelegate(delegatorId, delegateId).successBody()

	override suspend fun getExchangeDataById(exchangeDataId: String): ExchangeData? =
		rawApi.getExchangeDataById(exchangeDataId).successBodyOrNull404()

	override suspend fun verifyExchangeData(
		data: ExchangeDataWithUnencryptedContent,
		rsaVerificationKeyProvider: RsaVerificationKeyProvider,
		verifyAsDelegator: Boolean
	): Boolean {
		if (
			verifyAsDelegator && (
				data.exchangeData.delegator !== dataOwnerApi.getCurrentDataOwnerId()
				|| !(verifyDelegatorSignature(data.exchangeData, data.unencryptedContent.sharedSignatureKey, rsaVerificationKeyProvider))
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
	): DecryptionResult<ExchangeData, String> =
		tryDecryptExchangeData(
			exchangeData,
			decryptionKeys,
			ExchangeData::accessControlSecret,
			::importAccessControlSecret
		)

	override suspend fun tryDecryptExchangeKeys(
		exchangeData: List<ExchangeData>,
		decryptionKeys: RsaDecryptionKeysSet
	): DecryptionResult<ExchangeData, AesKey> =
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
		delegateId: String,
		signatureKeys: RsaSignatureKeysSet,
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
		val delegator = dataOwnerApi.getCurrentDataOwnerId()
		val sharedSignature = cryptoService.hmac.sign(
			bytesToSignForSharedSignature(
				delegator = delegator,
				delegate = delegateId,
				decryptedAccessControlSecret = accessControlSecret,
				decryptedExchangeKey = exchangeKey,
				publicKeysFingerprints = encryptionKeys.allKeys.mapTo(mutableSetOf()) { it.pubSpkiHexString.fingerprintV2() }
			),
			sharedSignatureKey
		).base64Encode()
		val delegatorSignature = cryptoService.signDataWithKeys(
			bytesToSignForDelegatorSignature(sharedSignatureKey = sharedSignatureKey),
			signatureKeys,
			KeyIdentifierFormat.FingerprintV2
		)
		val exchangeData = ExchangeData(
			id = exchangeDataId ?: cryptoService.strongRandom.randomUUID(),
			delegator = delegator,
			delegate = delegateId,
			exchangeKey = encryptedExchangeKey,
			accessControlSecret = encryptedAccessControlSecret,
			sharedSignatureKey = encryptedSharedSignatureKey,
			sharedSignature = sharedSignature,
			delegatorSignature = delegatorSignature
		)
		return ExchangeDataWithUnencryptedContent(
			exchangeData = rawApi.createExchangeData(exchangeData).successBody(),
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
					exchangeKey = exchangeKey,
					accessControlSecret = accessControlSecret,
					sharedSignatureKey = sharedSignatureKey
				)
			)
		}

		val encryptionKeysForMissingEntries = VerifiedRsaEncryptionKeysSet(missingEntries)
		val updatedExchangeData = exchangeData.copy(
			exchangeKey = exchangeData.exchangeKey + cryptoService.encryptDataWithKeys(rawExchangeKey, encryptionKeysForMissingEntries, KeyIdentifierFormat.FingerprintV2),
			accessControlSecret = exchangeData.accessControlSecret + cryptoService.encryptDataWithKeys(rawAccessControlSecret, encryptionKeysForMissingEntries, KeyIdentifierFormat.FingerprintV2),
			sharedSignatureKey = exchangeData.sharedSignatureKey + cryptoService.encryptDataWithKeys(rawSharedSignatureKey, encryptionKeysForMissingEntries, KeyIdentifierFormat.FingerprintV2)
		).let {
			val isVerified = verifyExchangeData(
				data = ExchangeDataWithUnencryptedContent(
					exchangeData = exchangeData,
					unencryptedContent = UnencryptedExchangeDataContent(
						exchangeKey = exchangeKey,
						accessControlSecret = accessControlSecret,
						sharedSignatureKey = sharedSignatureKey
					)
				),
				rsaVerificationKeyProvider = { null },
				verifyAsDelegator = false
			)
			if (isVerified) it.copy(
				sharedSignature = cryptoService.hmac.sign(
					bytesToSignForSharedSignature(
						delegator = it.delegator,
						delegate = it.delegate,
						decryptedAccessControlSecret = accessControlSecret,
						decryptedExchangeKey = exchangeKey,
						publicKeysFingerprints = it.exchangeKey.keys
					),
					sharedSignatureKey
				).base64Encode()
			) else it
		}

		return ExchangeDataWithUnencryptedContent(
			exchangeData = rawApi.modifyExchangeData(updatedExchangeData).successBody(),
			unencryptedContent = UnencryptedExchangeDataContent(
				exchangeKey = exchangeKey,
				accessControlSecret = accessControlSecret,
				sharedSignatureKey = sharedSignatureKey
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
		encryptedData.firstNotNullOfOrNull { (fp, encrypted) ->
			kotlin.runCatching {
				decryptionKeys.getByFingerprintV2(fp)?.let {
					cryptoService.rsa.decrypt(encrypted.decode(), it)
				}
			}.onFailure {
				log.w(it) { "Failed to decrypt data using RSA key $fp" }
			}.getOrNull()
		}

	private suspend fun verifyDelegatorSignature(
		exchangeData: ExchangeData,
		sharedSignatureKey: HmacKey<HmacAlgorithm.HmacSha512>,
		verificationKeyProvider: RsaVerificationKeyProvider
	): Boolean {
		val delegatorSignatureData = bytesToSignForDelegatorSignature(sharedSignatureKey = sharedSignatureKey)
		/*
		 * Have access to at least a signature key and all the available keys validate the signature
		 */
		return exchangeData.delegatorSignature.mapNotNull { (fp, signature) ->
			verificationKeyProvider.getByFingerprint(fp)?.let { it to signature }
		}.takeIf { it.isNotEmpty() }?.all { (key, signature) ->
			cryptoService.rsa.verifySignature(
				signature = signature.decode(),
				data = delegatorSignatureData,
				publicKey = key
			)
		} == true
	}

	private suspend fun bytesToSignForSharedSignature(
		delegator: String,
		delegate: String,
		decryptedAccessControlSecret: String,
		decryptedExchangeKey: AesKey,
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

	private suspend fun generateExchangeKey(): Pair<AesKey, ByteArray> =
		cryptoService.aes.generateKey().let { it to cryptoService.aes.exportKey(it) }

	private suspend fun importExchangeKey(decryptedBytes: ByteArray): AesKey =
		cryptoService.aes.loadKey(decryptedBytes)

	private suspend fun generateSharedSignatureKey(): Pair<HmacKey<HmacAlgorithm.HmacSha512>, ByteArray> =
		cryptoService.hmac.generateKey(HmacAlgorithm.HmacSha512).let { it to cryptoService.hmac.exportKey(it) }

	private suspend fun importSharedSignatureKey(decryptedBytes: ByteArray): HmacKey<HmacAlgorithm.HmacSha512> =
		cryptoService.hmac.loadKey(HmacAlgorithm.HmacSha512, decryptedBytes)

	// Generates a new access control secret
	private fun generateAccessControlSecret(): Pair<String, ByteArray> =
		cryptoService.strongRandom.randomBytes(16).let { it.toHexString() to it }

	private fun importAccessControlSecret(decryptedBytes: ByteArray): String  =
		decryptedBytes.toHexString()
}