package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.raw.RawRecoveryDataApi
import com.icure.cardinal.sdk.crypto.RecoveryDataEncryption
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataRecoveryDetails
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.model.RecoveryData
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.decode
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.utils.toHexString
import com.icure.utils.InternalIcureApi
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement


// Keep name of parameters for compatibility with typescript SDK
@Serializable
private data class DelegateKeyPairInfo(
	val pair: KeyPair,
	val algorithm: ShaVersion
) {
	@Serializable
	data class KeyPair(
		val publicKey: Base64String,
		val privateKey: Base64String
	)

	@Serializable
	enum class ShaVersion {
		@SerialName("sha-1")
		SHA1,
		@SerialName("sha-256")
		SHA256
	}
}

@OptIn(InternalIcureApi::class)
class RecoveryDataEncryptionImpl(
	private val primitives: CryptoService,
	override val raw: RawRecoveryDataApi,
) : RecoveryDataEncryption {
	override suspend fun recoveryKeyToId(recoveryKey: RecoveryDataKey): String =
		primitives.digest.sha256(recoveryKey.asRawBytes()).toHexString()

	override suspend fun createAndSaveKeyPairsRecoveryDataFor(
		recipient: String,
		keyPairs: Map<String, List<RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>,
		lifetimeSeconds: Int?
	): RecoveryDataKey {
		val content: Map<String, List<DelegateKeyPairInfo>> = keyPairs.mapValues { (_, delegateKeypairs) ->
			delegateKeypairs.map { keypair ->
				DelegateKeyPairInfo(
					pair = DelegateKeyPairInfo.KeyPair(
						publicKey = primitives.rsa.exportPublicKeySpki(keypair.public).base64Encode(),
						privateKey = primitives.rsa.exportPrivateKeyPkcs8(keypair.private).base64Encode()
					),
					algorithm = when (keypair.algorithm) {
						RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 -> DelegateKeyPairInfo.ShaVersion.SHA256
						RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 -> DelegateKeyPairInfo.ShaVersion.SHA1
					}
				)
			}
		}
		return createRecoveryData(recipient, RecoveryData.Type.KeypairRecovery, lifetimeSeconds, Json.encodeToJsonElement(content))
	}

	override suspend fun getAndDecryptKeyPairsRecoveryData(
		recoveryKey: RecoveryDataKey,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>> =
		getRecoveryDataAndDecrypt(recoveryKey, RecoveryData.Type.KeypairRecovery) {
			val decoded: Map<String, List<DelegateKeyPairInfo>> = Json.decodeFromJsonElement(it)
			decoded.mapValues { (_, delegateKeypairs) ->
				delegateKeypairs.map { delegateKeyPairInfo ->
					val algorithm = when (delegateKeyPairInfo.algorithm) {
						DelegateKeyPairInfo.ShaVersion.SHA256 -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
						DelegateKeyPairInfo.ShaVersion.SHA1 -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
					}
					val declaredSpki = delegateKeyPairInfo.pair.publicKey.decode()
					val keypair = primitives.rsa.loadKeyPairPkcs8(algorithm, delegateKeyPairInfo.pair.privateKey.decode())
					val obtainedSpki = primitives.rsa.exportPublicKeySpki(keypair.public).toList()
					if (declaredSpki.toList() != obtainedSpki) throw SerializationException(
						"Deserialized public key does not match the private key."
					)
					SpkiHexString(declaredSpki.toHexString()) to keypair
				}.toMap()
			}
		}.also {
			if (autoDelete && it.isSuccess) raw.deleteRecoveryData(recoveryKeyToId(recoveryKey))
		}

	override suspend fun createAndSaveExchangeDataRecoveryData(
		recipient: String,
		exchangeDataInfo: List<ExchangeDataRecoveryDetails>,
		lifetimeSeconds: Int?
	): RecoveryDataKey =
		createRecoveryData(
			recipient,
			RecoveryData.Type.ExchangeKeyRecovery,
			lifetimeSeconds,
			Json.encodeToJsonElement(exchangeDataInfo)
		)

	override suspend fun getAndDecryptExchangeDataRecoveryData(
		recoveryKey: RecoveryDataKey
	): RecoveryResult<List<ExchangeDataRecoveryDetails>> =
		getRecoveryDataAndDecrypt(recoveryKey, RecoveryData.Type.ExchangeKeyRecovery) {
			Json.decodeFromJsonElement(it)
		}

	private suspend fun createRecoveryData(
		recipient: String,
		type: RecoveryData.Type,
		lifetimeSeconds: Int?,
		content: JsonElement
	): RecoveryDataKey {
		val recoveryKeyAes = primitives.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
		val recoveryKey = RecoveryDataKey.fromRawBytes(primitives.aes.exportKey(recoveryKeyAes))
		val id = recoveryKeyToId(recoveryKey)
		val encryptedSelf =
			primitives.aes.encrypt(
				content.toString().toByteArray(Charsets.UTF_8),
				recoveryKeyAes
			).base64Encode()
		val expirationInstant = lifetimeSeconds?.let { currentEpochMs() + it * 1000 }
		val data = RecoveryData(
			id = id,
			encryptedSelf = encryptedSelf,
			expirationInstant = expirationInstant,
			recipient = recipient,
			type = type
		)
		raw.createRecoveryData(data)
		return recoveryKey
	}

	private suspend fun <T: Any> getRecoveryDataAndDecrypt(
		recoveryKey: RecoveryDataKey,
		expectedType: RecoveryData.Type,
		decode: suspend (JsonElement) -> T
	): RecoveryResult<T> =
		raw.getRecoveryData(recoveryKeyToId(recoveryKey)).run {
			when (status.value) {
				404 -> return RecoveryResult.Failure(RecoveryDataUseFailureReason.Missing)
				403 -> return RecoveryResult.Failure(RecoveryDataUseFailureReason.Unauthorized)
				else -> successBody().let {
					if (it.type != expectedType) return RecoveryResult.Failure(RecoveryDataUseFailureReason.InvalidType)
					val decrypted = primitives.aes.decrypt(it.encryptedSelf.decode(), recoveryKey.loadAesKey(primitives))
					val decryptedUtf8 = decrypted.decodeToString()
					return try {
						RecoveryResult.Success(decode(Json.parseToJsonElement(decryptedUtf8)))
					} catch (e: SerializationException) {
						RecoveryResult.Failure(RecoveryDataUseFailureReason.InvalidContent)
					}
				}
			}
		}
}