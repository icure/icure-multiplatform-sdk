package com.icure.kryptom.crypto

import com.icure.kryptom.ios.toByteArray
import com.icure.kryptom.ios.toCFData
import com.icure.kryptom.utils.PlatformMethodException
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.CoreFoundation.CFDictionaryAddValue
import platform.CoreFoundation.CFDictionaryCreateMutable
import platform.CoreFoundation.CFErrorRefVar
import platform.CoreFoundation.CFMutableDictionaryRef
import platform.CoreFoundation.CFRelease
import platform.CoreFoundation.kCFAllocatorDefault
import platform.CoreFoundation.kCFTypeDictionaryKeyCallBacks
import platform.CoreFoundation.kCFTypeDictionaryValueCallBacks
import platform.Foundation.CFBridgingRelease
import platform.Foundation.CFBridgingRetain
import platform.Foundation.NSError
import platform.Foundation.NSNumber
import platform.Security.SecKeyAlgorithm
import platform.Security.SecKeyCopyExternalRepresentation
import platform.Security.SecKeyCopyPublicKey
import platform.Security.SecKeyCreateDecryptedData
import platform.Security.SecKeyCreateEncryptedData
import platform.Security.SecKeyCreateRandomKey
import platform.Security.SecKeyCreateSignature
import platform.Security.SecKeyCreateWithData
import platform.Security.SecKeyRef
import platform.Security.SecKeyVerifySignature
import platform.Security.kSecAttrKeyClass
import platform.Security.kSecAttrKeyClassPrivate
import platform.Security.kSecAttrKeyClassPublic
import platform.Security.kSecAttrKeySizeInBits
import platform.Security.kSecAttrKeyType
import platform.Security.kSecAttrKeyTypeRSA
import platform.Security.kSecKeyAlgorithmRSAEncryptionOAEPSHA1
import platform.Security.kSecKeyAlgorithmRSAEncryptionOAEPSHA256
import platform.Security.kSecKeyAlgorithmRSASignatureMessagePSSSHA256

object IosRsaService : RsaService {
	private val secKeyEncryptionAlgorithms: Map<RsaAlgorithm.RsaEncryptionAlgorithm, SecKeyAlgorithm> = mapOf(
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 to checkNotNull(kSecKeyAlgorithmRSAEncryptionOAEPSHA1) { "kSecKeyAlgorithmRSAEncryptionOAEPSHA1 is null" },
		RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 to checkNotNull(kSecKeyAlgorithmRSAEncryptionOAEPSHA256) { "kSecKeyAlgorithmRSAEncryptionOAEPSHA256 is null" },
	)

	private val secKeySignatureAlgorithms: Map<RsaAlgorithm.RsaSignatureAlgorithm, SecKeyAlgorithm> = mapOf(
		RsaAlgorithm.RsaSignatureAlgorithm.PssWithSha256 to checkNotNull(kSecKeyAlgorithmRSASignatureMessagePSSSHA256) { "kSecKeyAlgorithmRSASignatureMessagePSSSHA256 is null" },
	)


	private val generationAttr = RsaService.KeySize.entries.associateWith { keySize ->
		CFDictionaryCreateMutable(
			kCFAllocatorDefault,
			2,
			kCFTypeDictionaryKeyCallBacks.ptr,
			kCFTypeDictionaryValueCallBacks.ptr
		).also {
			CFDictionaryAddValue(it, kSecAttrKeyType, kSecAttrKeyTypeRSA)
			CFDictionaryAddValue(it, kSecAttrKeySizeInBits, CFBridgingRetain(NSNumber(int = keySize.bitSize)))
		}
	}

	val loadPrivateSecKeyAttr = CFDictionaryCreateMutable(
		kCFAllocatorDefault,
		2,
		kCFTypeDictionaryKeyCallBacks.ptr,
		kCFTypeDictionaryValueCallBacks.ptr
	).also {
		CFDictionaryAddValue(it, kSecAttrKeyType, kSecAttrKeyTypeRSA)
		CFDictionaryAddValue(it, kSecAttrKeyClass, kSecAttrKeyClassPrivate)
	}

	val loadPublicSecKeyAttr = CFDictionaryCreateMutable(
		kCFAllocatorDefault,
		2,
		kCFTypeDictionaryKeyCallBacks.ptr,
		kCFTypeDictionaryValueCallBacks.ptr
	).also {
		CFDictionaryAddValue(it, kSecAttrKeyType, kSecAttrKeyTypeRSA)
		CFDictionaryAddValue(it, kSecAttrKeyClass, kSecAttrKeyClassPublic)
	}

	override suspend fun <A : RsaAlgorithm> generateKeyPair(
		algorithm: A,
		keySize: RsaService.KeySize
	): RsaKeypair<A> = memScoped {
		// https://github.com/JetBrains/kotlin-native/issues/3013
		// https://youtrack.jetbrains.com/issue/KT-50990
		val error = alloc<CFErrorRefVar>()
		val privateKey = SecKeyCreateRandomKey(generationAttr.getValue(keySize), error.ptr)
		if (error.value != null) {
			val nsError = CFBridgingRelease(error.value) as NSError
			if (privateKey != null) CFRelease(privateKey)
			throw PlatformMethodException(
				"Failed to create private key (error code ${nsError.code}): ${nsError.localizedDescription}",
				nsError.code.toInt()
			)
		}
		if (privateKey == null) throw PlatformMethodException(
			"Private key creation didn't give an error but result is null",
			null
		)
		val publicKey = SecKeyCopyPublicKey(privateKey)
		if (publicKey == null) {
			CFRelease(privateKey)
			throw PlatformMethodException("Public key extraction from private key should not fail", null)
		}
		try {
			RsaKeypair(PrivateRsaKey(privateKey.toPkcs1(), algorithm), PublicRsaKey(publicKey.toPkcs1(), algorithm))
		} finally {
			CFRelease(privateKey)
			CFRelease(publicKey)
		}
	}

	override suspend fun <A : RsaAlgorithm> loadKeyPairPkcs8(algorithm: A, privateKeyPkcs8: ByteArray): RsaKeypair<A> {
		val privateKey = pkcs8ToPcks1(privateKeyPkcs8)
		val privateSecKey = toSecKey(privateKey, loadPrivateSecKeyAttr)
		val publicSecKey = SecKeyCopyPublicKey(privateSecKey)
		if (publicSecKey == null) {
			CFRelease(privateSecKey)
			throw PlatformMethodException("Public key extraction from private key should not fail", null)
		}
		return try {
			RsaKeypair(PrivateRsaKey(privateKey, algorithm), PublicRsaKey(publicSecKey.toPkcs1(), algorithm))
		} finally {
			CFRelease(privateSecKey)
			CFRelease(publicSecKey)
		}
	}

	override suspend fun <A : RsaAlgorithm> loadPrivateKeyPkcs8(
		algorithm: A,
		privateKeyPkcs8: ByteArray
	): PrivateRsaKey<A> =
		PrivateRsaKey(pkcs8ToPcks1(privateKeyPkcs8), algorithm)

	override suspend fun <A : RsaAlgorithm> loadPublicKeySpki(algorithm: A, publicKeySpki: ByteArray): PublicRsaKey<A> =
		PublicRsaKey(spkiToPcks1(publicKeySpki), algorithm)

	override suspend fun encrypt(
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray {
		val secKey = publicKey.toSecKey()
		val cfData = data.toCFData()
		return try {
			memScoped {
				val error = alloc<CFErrorRefVar>()
				val encrypted = SecKeyCreateEncryptedData(
					secKey,
					secKeyEncryptionAlgorithms.getValue(publicKey.algorithm),
					cfData,
					error.ptr
				)
				if (error.value != null) {
					val nsError = CFBridgingRelease(error.value) as NSError
					if (encrypted != null) CFRelease(encrypted)
					throw PlatformMethodException(
						"Failed to encrypt data: ${nsError.localizedDescription}",
						nsError.code.toInt()
					)
				}
				if (encrypted == null) throw PlatformMethodException(
					"Encryption didn't give an error but result is null",
					null
				)
				encrypted.toByteArray()
			}
		} finally {
			CFRelease(cfData)
			CFRelease(secKey)
		}
	}

	override suspend fun decrypt(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaEncryptionAlgorithm>
	): ByteArray {
		val secKey = privateKey.toSecKey()
		val cfData = data.toCFData()
		return try {
			memScoped {
				val error = alloc<CFErrorRefVar>()
				val decrypted = SecKeyCreateDecryptedData(
					secKey,
					secKeyEncryptionAlgorithms.getValue(privateKey.algorithm),
					cfData,
					error.ptr
				)
				if (error.value != null) {
					val nsError = CFBridgingRelease(error.value) as NSError
					if (decrypted != null) CFRelease(decrypted)
					throw PlatformMethodException(
						"Failed to decrypt data: ${nsError.localizedDescription}",
						nsError.code.toInt()
					)
				}
				if (decrypted == null) throw PlatformMethodException(
					"Decryption didn't give an error but result is null",
					null
				)
				decrypted.toByteArray()
			}
		} finally {
			CFRelease(cfData)
			CFRelease(secKey)
		}
	}

	override suspend fun sign(
		data: ByteArray,
		privateKey: PrivateRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): ByteArray {
		val secKey = privateKey.toSecKey()
		val cfData = data.toCFData()
		return try {
			memScoped {
				val error = alloc<CFErrorRefVar>()
				val signature = SecKeyCreateSignature(
					secKey,
					secKeySignatureAlgorithms.getValue(privateKey.algorithm),
					cfData,
					error.ptr
				)
				if (error.value != null) {
					val nsError = CFBridgingRelease(error.value) as NSError
					if (signature != null) CFRelease(signature)
					throw PlatformMethodException(
						"Failed to sign data: ${nsError.localizedDescription}",
						nsError.code.toInt()
					)
				}
				if (signature == null) throw PlatformMethodException(
					"Signing didn't give an error but result is null",
					null
				)
				signature.toByteArray()
			}
		} finally {
			CFRelease(cfData)
			CFRelease(secKey)
		}
	}

	override suspend fun verifySignature(
		signature: ByteArray,
		data: ByteArray,
		publicKey: PublicRsaKey<RsaAlgorithm.RsaSignatureAlgorithm>
	): Boolean {
		val secKey = publicKey.toSecKey()
		val cfData = data.toCFData()
		val cfSignature = signature.toCFData()
		return try {
			memScoped {
				val error = alloc<CFErrorRefVar>()
				val verification = SecKeyVerifySignature(
					secKey,
					secKeySignatureAlgorithms.getValue(publicKey.algorithm),
					cfData,
					cfSignature,
					error.ptr
				)
				if (error.value != null) {
					val nsError = CFBridgingRelease(error.value) as NSError
					// Error code for invalid signature
					if (nsError.code != -67808L) throw PlatformMethodException(
						"Failed to verify data: ${nsError.localizedDescription}",
						nsError.code.toInt()
					)
					false
				} else {
					verification
				}
			}
		} finally {
			CFRelease(cfData)
			CFRelease(secKey)
		}
	}

	override suspend fun exportPrivateKeyPkcs8(key: PrivateRsaKey<*>): ByteArray =
		pkcs1ToPcks8(key.rawKey)

	override suspend fun exportPublicKeySpki(key: PublicRsaKey<*>): ByteArray =
		pkcs1ToSpki(key.rawKey)

	private fun SecKeyRef.toPkcs1(): ByteArray = memScoped {
		val error = alloc<CFErrorRefVar>()
		val result = SecKeyCopyExternalRepresentation(this@toPkcs1, error.ptr)
		if (error.value != null) {
			val nsError = CFBridgingRelease(error.value) as NSError
			if (result != null) CFRelease(result)
			throw PlatformMethodException(
				"Failed to export SecKey: ${nsError.localizedDescription}",
				nsError.code.toInt()
			)
		}
		if (result == null) throw PlatformMethodException(
			"SecKey export didn't give an error but result is null",
			null
		)
		result.toByteArray()
	}

	private fun PrivateRsaKey<*>.toSecKey(): SecKeyRef = toSecKey(rawKey, loadPrivateSecKeyAttr)

	private fun PublicRsaKey<*>.toSecKey(): SecKeyRef = toSecKey(rawKey, loadPublicSecKeyAttr)

	private fun toSecKey(
		pkcs1Key: ByteArray,
		attrs: CFMutableDictionaryRef?
	): SecKeyRef = memScoped {
		val error = alloc<CFErrorRefVar>()
		val cfdata = pkcs1Key.toCFData()
		val result = SecKeyCreateWithData(cfdata, attrs, error.ptr)
		CFRelease(cfdata)
		if (error.value != null) {
			val nsError = CFBridgingRelease(error.value) as NSError
			if (result != null) CFRelease(result)
			throw PlatformMethodException(
				"Failed to import SecKey: ${nsError.localizedDescription}",
				nsError.code.toInt()
			)
		}
		if (result == null) throw PlatformMethodException(
			"SecKey import didn't give an error but result is null",
			null
		)
		result
	}
}
