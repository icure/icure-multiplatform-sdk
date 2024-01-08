package com.icure.sdk.crypto

import com.icure.sdk.ios.toByteArray
import com.icure.sdk.ios.toCFData
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
import platform.Security.SecKeyCreateWithData
import platform.Security.SecKeyRef
import platform.Security.kSecAttrKeyClass
import platform.Security.kSecAttrKeyClassPrivate
import platform.Security.kSecAttrKeyClassPublic
import platform.Security.kSecAttrKeySizeInBits
import platform.Security.kSecAttrKeyType
import platform.Security.kSecAttrKeyTypeRSA
import platform.Security.kSecKeyAlgorithmRSAEncryptionOAEPSHA1
import platform.Security.kSecKeyAlgorithmRSAEncryptionOAEPSHA256

object IosRsaCryptoService : RsaCryptoService {
    private val secKeyEncryptionAlgorithms: Map<RsaAlgorithm, SecKeyAlgorithm> = mapOf(
        RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1 to checkNotNull(kSecKeyAlgorithmRSAEncryptionOAEPSHA1) { "kSecKeyAlgorithmRSAEncryptionOAEPSHA1 is null" },
        RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256 to checkNotNull(kSecKeyAlgorithmRSAEncryptionOAEPSHA256) { "kSecKeyAlgorithmRSAEncryptionOAEPSHA256 is null" },
    )

    private val generationAttr = RsaCryptoService.KeySize.values().associateWith { keySize ->
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
        keySize: RsaCryptoService.KeySize
    ): RsaKeypair<A> = memScoped {
        // https://github.com/JetBrains/kotlin-native/issues/3013
        // https://youtrack.jetbrains.com/issue/KT-50990
        val error = alloc<CFErrorRefVar>()
        val privateKey = SecKeyCreateRandomKey(generationAttr.getValue(keySize), error.ptr)
        check(error.value == null) {
            val nsError = CFBridgingRelease(error.value) as NSError
            if (privateKey != null) CFRelease(privateKey)
            "Failed to create private key (error code ${nsError.code}): ${nsError.localizedDescription}"
        }
        checkNotNull(privateKey) { "Private key should not be null if key creation did not give any error" }
        val publicKey = SecKeyCopyPublicKey(privateKey)
        checkNotNull(publicKey) {
            CFRelease(privateKey)
            "Public key extraction from private key should not fail"
        }
        try {
            RsaKeypair(PrivateRsaKey(privateKey.toPkcs1()), PublicRsaKey(publicKey.toPkcs1()))
        } finally {
            CFRelease(privateKey)
            CFRelease(publicKey)
        }
    }

    override suspend fun <A : RsaAlgorithm> loadKeyPairPkcs8(algorithm: A, privateKeyPkcs8: ByteArray): RsaKeypair<A> {
        val privateKey = pkcs8ToPcks1(privateKeyPkcs8)
        val privateSecKey = toSecKey(privateKey, loadPrivateSecKeyAttr)
        val publicSecKey = SecKeyCopyPublicKey(privateSecKey)
        checkNotNull(publicSecKey) {
            CFRelease(privateSecKey)
            "Public key extraction from private key should not fail"
        }
        return try {
            RsaKeypair(PrivateRsaKey(privateKey), PublicRsaKey(publicSecKey.toPkcs1()))
        } finally {
            CFRelease(privateSecKey)
            CFRelease(publicSecKey)
        }
    }

    override suspend fun <A : RsaAlgorithm> loadPublicKeySpki(algorithm: A, publicKeySpki: ByteArray): PublicRsaKey<A> =
        PublicRsaKey(spkiToPcks1(publicKeySpki))

    override suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> encrypt(
        algorithm: A,
        data: ByteArray,
        publicKey: PublicRsaKey<A>
    ): ByteArray {
        val secKey = publicKey.toSecKey()
        val cfData = data.toCFData()
        return try {
            memScoped {
                val error = alloc<CFErrorRefVar>()
                val encrypted = SecKeyCreateEncryptedData(
                    secKey,
                    secKeyEncryptionAlgorithms.getValue(algorithm),
                    cfData,
                    error.ptr
                )
                check(error.value == null) {
                    val nsError = CFBridgingRelease(error.value) as NSError
                    if (encrypted != null) CFRelease(encrypted)
                    "Failed to encrypt data: ${nsError.localizedDescription}"
                }
                checkNotNull(encrypted) { "Encryption didn't give an error but result is null" }
                encrypted.toByteArray()
            }
        } finally {
            CFRelease(cfData)
            CFRelease(secKey)
        }
    }

    override suspend fun <A : RsaAlgorithm.RsaEncryptionAlgorithm> decrypt(
        algorithm: A,
        data: ByteArray,
        privateKey: PrivateRsaKey<A>
    ): ByteArray {
        val secKey = privateKey.toSecKey()
        val cfData = data.toCFData()
        return try {
            memScoped {
                val error = alloc<CFErrorRefVar>()
                val decrypted = SecKeyCreateDecryptedData(
                    secKey,
                    secKeyEncryptionAlgorithms.getValue(algorithm),
                    cfData,
                    error.ptr
                )
                check(error.value == null) {
                    val nsError = CFBridgingRelease(error.value) as NSError
                    if (decrypted != null) CFRelease(decrypted)
                    "Failed to decrypt data: ${nsError.localizedDescription}"
                }
                checkNotNull(decrypted) { "Decryption didn't give an error but result is null" }
                decrypted.toByteArray()
            }
        } finally {
            CFRelease(cfData)
            CFRelease(secKey)
        }
    }

    override suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> sign(
        algorithm: A,
        data: ByteArray,
        privateKey: PrivateRsaKey<A>
    ): ByteArray {
        TODO("iOS RSA sign/verify")
    }

    override suspend fun <A : RsaAlgorithm.RsaSignatureAlgorithm> verifySignature(
        algorithm: A,
        signature: ByteArray,
        data: ByteArray,
        publicKey: PublicRsaKey<A>
    ): Boolean {
        TODO("iOS RSA sign/verify")
    }

    override suspend fun exportPrivateKeyPkcs8(key: PrivateRsaKey<*>): ByteArray =
        pkcs1ToPcks8(key.rawKey)

    override suspend fun exportPublicKeySpki(key: PublicRsaKey<*>): ByteArray =
        pkcs1ToSpki(key.rawKey)

    private fun SecKeyRef.toPkcs1(): ByteArray = memScoped {
        val error = alloc<CFErrorRefVar>()
        val result = SecKeyCopyExternalRepresentation(this@toPkcs1, error.ptr)
        check(error.value == null) {
            val nsError = CFBridgingRelease(error.value) as NSError
            if (result != null) CFRelease(result)
            "Failed to export SecKey: ${nsError.localizedDescription}"
        }
        checkNotNull(result) { "SecKey export didn't give an error but result is null" }
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
        check(error.value == null) {
            val nsError = CFBridgingRelease(error.value) as NSError
            if (result != null) CFRelease(result)
            "Failed to import SecKey: ${nsError.localizedDescription}"
        }
        checkNotNull(result) { "SecKey import didn't give an error but result is null" }
        result
    }
}
