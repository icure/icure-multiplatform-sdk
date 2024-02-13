package com.icure.sdk.model

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.hexToByteArray
import com.icure.kryptom.utils.toHexString
import io.ktor.utils.io.charsets.Charsets
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline



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
	suspend fun allAccessControlKeys(cryptoService: CryptoService): Set<AccessControlKeyString> =
		EntityWithDelegationTypeName.entries.mapTo(mutableSetOf()) { toAccessControlKeyStringFor(it, cryptoService) }

	/**
	 * Get the secure delegation key corresponding to an access control secret for a specific entity type
	 */
	suspend fun toAccessControlKeyStringFor(
		entityType: EntityWithDelegationTypeName,
		cryptoService: CryptoService
	): AccessControlKeyString =
		AccessControlKeyString(cryptoService.digest.sha256((s + entityType.id).toByteArray(Charsets.UTF_8)).toHexString())

	suspend fun toSecureDelegationKeyFor(
		entityType: EntityWithDelegationTypeName,
		cryptoService: CryptoService
	) = toAccessControlKeyStringFor(entityType, cryptoService).toSecureDelegationKeyString(cryptoService)
}

@JvmInline
@Serializable
value class AccessControlKeyString(val s: String) {
	/**
	 * One way operation to get the secure delegation key string corresponding to an access control key string
	 */
	suspend fun toSecureDelegationKeyString(cryptoService: CryptoService): SecureDelegationKeyString {
		return SecureDelegationKeyString(cryptoService.digest.sha256(bytes()).toHexString())
	}

	fun bytes(): ByteArray = hexToByteArray(s)
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

	fun bytes(): ByteArray =
		hexToByteArray(s)
}

@JvmInline
@Serializable
value class KeypairFingerprintV1String(
	val s: String
) {
	companion object {
		private const val TRAILING_CONSTANT = "0203010001"
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