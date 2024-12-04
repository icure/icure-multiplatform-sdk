package com.icure.cardinal.sdk.model.specializations

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.utils.base64Encode
import com.icure.cardinal.sdk.utils.concat
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * A string that represents the keypair used for the encryption of an aes exchange key entry. This should usually be
 * a fingerprint v1, but due to bugs in older iCure version it may also be a public key in hex-encoded spki format, or
 * due to corruption of some healthcare parties public key it may also be an empty string, to represent the fact that
 * the key used for the encryption is unknown.
 */
@JvmInline
@Serializable
value class AesExchangeKeyEncryptionKeypairIdentifier(val s: String) {
	fun toFingerprintV1OrNull(): KeypairFingerprintV1String? =
		if (s.length >= 32) KeypairFingerprintV1String(s.takeLast(32)) else null

	internal fun sliceIfNeeded() =
		if (s.length > 32) AesExchangeKeyEncryptionKeypairIdentifier(s.take(32)) else this
}

@JvmInline
@Serializable
value class Base64String(val s: String)

@JvmInline
@Serializable
value class HexString(val s: String) {
	fun decodedBytes(): ByteArray = hexToByteArray(s)
}

@JvmInline
@Serializable
value class Sha256HexString(val s: String)

@JvmInline
@Serializable
value class AccessControlSecret(val s: String) {
	/**
	 * One way operation to get all possible secure delegation keys corresponding to this access control secret
	 */
	internal suspend fun allAccessControlKeys(cryptoService: CryptoService): Set<AccessControlKeyHexString> =
		EntityWithEncryptionMetadataTypeName.entries.mapTo(mutableSetOf()) { toAccessControlKeyStringFor(it, cryptoService) }

	/**
	 * Get the secure delegation key corresponding to an access control secret for a specific entity type
	 */
	internal suspend fun toAccessControlKeyStringFor(
		entityType: EntityWithEncryptionMetadataTypeName,
		cryptoService: CryptoService
	): AccessControlKeyHexString =
		AccessControlKeyHexString(cryptoService.digest.sha256((s + entityType.id).toByteArray(Charsets.UTF_8)).sliceArray(0 until AccessControlKeyHexString.BYTES_LENGTH).toHexString())

	internal suspend fun toSecureDelegationKeyFor(
		entityType: EntityWithEncryptionMetadataTypeName,
		cryptoService: CryptoService
	) = toAccessControlKeyStringFor(entityType, cryptoService).toSecureDelegationKeyString(cryptoService)
}

@JvmInline
@Serializable
value class AccessControlKeyHexString(val s: String) {
	companion object {
		val BYTES_LENGTH = 16
		private val HEX_LENGTH = 32
	}
	/**
	 * One way operation to get the secure delegation key string corresponding to an access control key string
	 */
	internal suspend fun toSecureDelegationKeyString(cryptoService: CryptoService): SecureDelegationKeyString {
		return SecureDelegationKeyString(cryptoService.digest.sha256(bytes()).toHexString())
	}

	internal fun bytes(): ByteArray = hexToByteArray(s)

	init {
		require(s.length == HEX_LENGTH) { "An access control key should be exactly $BYTES_LENGTH bytes (before encoding); got $s" }
	}
}
// Conservative value obtained by assuming a maximum allowed size for headers of 8kb (popular choice amongst
// various clients and servers)
// Multiple of 3 to avoid any padding in base64 encoding
const val MAX_ACCESS_CONTROL_KEYS_PER_HEADER = 360
internal fun Iterable<AccessControlKeyHexString>.encodeAsAccessControlHeaders(): List<Base64String> =
	chunked(MAX_ACCESS_CONTROL_KEYS_PER_HEADER).map { chunk ->
		chunk.map { it.bytes() }.concat().base64Encode()
	}

@JvmInline
@Serializable
value class SecureDelegationKeyString(val s: String)

// We may want to disable the inits once the sdk is ready, but now they help to secure the development

@JvmInline
@Serializable
value class SpkiHexString(
	val s: String
) {
	companion object {
		private const val PREFIX_2048 = "30820122300d06092a864886f70d01010105000382010f003082010a0282010100"
		private const val PREFIX_4096 = "30820222300d06092a864886f70d01010105000382020f003082020a0282020100"
		private const val POSTFIX = "0203010001"
		private val pattern2048 = Regex("^$PREFIX_2048[0-9a-f]{512}$POSTFIX\$")
		private val pattern4096 = Regex("^$PREFIX_4096[0-9a-f]{1024}$POSTFIX\$")
	}

	init {
		require(pattern2048.matches(s) || pattern4096.matches(s)) { "Invalid spki hex string: $s" }
	}

	fun fingerprintV1(): KeypairFingerprintV1String {
		return KeypairFingerprintV1String.fromPublicKeySpki(this)
	}

	fun fingerprintV2(): KeypairFingerprintV2String {
		return KeypairFingerprintV2String.fromPublicKeySpki(this)
	}

	internal fun bytes(): ByteArray =
		hexToByteArray(s)
}

@JvmInline
@Serializable
value class Pkcs8Bytes(
	val bytes: ByteArray
)

@JvmInline
@Serializable
value class KeypairFingerprintV1String(
	val s: String
) {
	companion object {
		private const val TRAILING_CONSTANT = "0203010001"
		const val LENGTH = 32
		private val pattern = Regex("^[0-9a-f]{22}$TRAILING_CONSTANT\$")

		fun fromPublicKeySpki(publicKeySpki: SpkiHexString): KeypairFingerprintV1String {
			return KeypairFingerprintV1String(publicKeySpki.s.takeLast(32))
		}

		fun fromV2(v2: KeypairFingerprintV2String): KeypairFingerprintV1String {
			return KeypairFingerprintV1String(v2.s + TRAILING_CONSTANT)
		}
	}

	init {
		require(pattern.matches(s)) { "Invalid fingerprint v1 string: $s" }
	}

	fun toV2(): KeypairFingerprintV2String {
		return KeypairFingerprintV2String.fromV1(this)
	}

	internal fun asAmbiguousIdentifier(): AesExchangeKeyEncryptionKeypairIdentifier {
		return AesExchangeKeyEncryptionKeypairIdentifier(s)
	}
}

@JvmInline
@Serializable
value class KeypairFingerprintV2String(
	val s: String
) {
	companion object {
		private val pattern = Regex("^[0-9a-f]{22}\$")

		fun fromV1(v1: KeypairFingerprintV1String): KeypairFingerprintV2String {
			return KeypairFingerprintV2String(v1.s.dropLast(10))
		}

		fun fromPublicKeySpki(publicKeySpki: SpkiHexString): KeypairFingerprintV2String {
			return KeypairFingerprintV2String(publicKeySpki.s.dropLast(10).takeLast(22))
		}
	}

	init {
		require(pattern.matches(s)) { "Invalid fingerprint v2 string: $s" }
	}
}
