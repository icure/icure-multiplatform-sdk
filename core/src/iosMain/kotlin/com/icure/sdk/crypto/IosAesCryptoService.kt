package com.icure.sdk.crypto

import com.icure.sdk.crypto.AesCryptoService.Companion.aesEncryptedSizeFor
import com.icure.sdk.crypto.AesCryptoService.Companion.IV_BYTE_LENGTH
import com.icure.sdk.ios.toByteArray
import com.icure.sdk.ios.toNSData
import kotlinx.cinterop.ULongVar
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.usePinned
import kotlinx.cinterop.value
import platform.CoreCrypto.CCCrypt
import platform.CoreCrypto.kCCAlgorithmAES
import platform.CoreCrypto.kCCDecrypt
import platform.CoreCrypto.kCCEncrypt
import platform.CoreCrypto.kCCKeySizeAES128
import platform.CoreCrypto.kCCKeySizeAES192
import platform.CoreCrypto.kCCKeySizeAES256
import platform.CoreCrypto.kCCOptionPKCS7Padding
import platform.CoreCrypto.kCCSuccess
import platform.Foundation.NSData

object IosAesCryptoService : AesCryptoService {
    override suspend fun generateKey(size: AesCryptoService.KeySize): NSData =
        strongRandom.randomBytes(size.byteSize).toNSData()

    override suspend fun exportKey(key: AesKey): ByteArray =
        key.toByteArray()

    override suspend fun loadKey(bytes: ByteArray): NSData =
        bytes.toNSData()

    override suspend fun encrypt(data: ByteArray, key: NSData, iv: ByteArray?): ByteArray {
        if (iv != null) require(iv.size == IV_BYTE_LENGTH) {
            "Initialization vector must be $IV_BYTE_LENGTH bytes long (got ${iv.size})."
        }
        val generatedIv = iv ?: strongRandom.randomBytes(IV_BYTE_LENGTH)
        val outBytes = generatedIv.copyOf(IV_BYTE_LENGTH + aesEncryptedSizeFor(data.size))
        memScoped {
            val dataOutMoved = alloc<ULongVar>()
            val operationResult = data.usePinned { pinnedData ->
                generatedIv.usePinned { pinnedIv ->
                    outBytes.usePinned { pinnedOut ->
                        CCCrypt(
                            kCCEncrypt,
                            kCCAlgorithmAES,
                            kCCOptionPKCS7Padding,
                            key.bytes,
                            validateAndGetKeySize(key),
                            pinnedIv.addressOf(0),
                            pinnedData.addressOf(0),
                            data.size.toULong(),
                            pinnedOut.addressOf(IV_BYTE_LENGTH),
                            (outBytes.size - IV_BYTE_LENGTH).toULong(),
                            dataOutMoved.ptr
                        )
                    }
                }
            }
            check(dataOutMoved.value == (outBytes.size - IV_BYTE_LENGTH).toULong()) {
                "Expected ${outBytes.size - IV_BYTE_LENGTH} encrypted bytes but got ${dataOutMoved.value}"
            }
            check(operationResult == kCCSuccess) {
                "Encryption failed with error code $operationResult"
            }
        }
        return outBytes
    }

    override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: NSData): ByteArray {
        val outBytes = ByteArray(ivAndEncryptedData.size - IV_BYTE_LENGTH)
        return memScoped {
            val dataOutMoved = alloc<ULongVar>()
            val operationResult = outBytes.usePinned { pinnedOutBytes ->
                ivAndEncryptedData.usePinned { pinnedIvAndEncryptedData ->
                    CCCrypt(
                        kCCDecrypt,
                        kCCAlgorithmAES,
                        kCCOptionPKCS7Padding,
                        key.bytes,
                        validateAndGetKeySize(key),
                        pinnedIvAndEncryptedData.addressOf(0),
                        pinnedIvAndEncryptedData.addressOf(IV_BYTE_LENGTH),
                        (ivAndEncryptedData.size - IV_BYTE_LENGTH).toULong(),
                        pinnedOutBytes.addressOf(0),
                        outBytes.size.toULong(),
                        dataOutMoved.ptr
                    )
                }
            }
            // Refer to Applications/Xcode.app/Contents/Developer/Platforms/iPhoneOS.platform/Developer/SDKs/iPhoneOS.sdk/usr/include/CommonCrypto/CommonCryptoError.h
            check(operationResult == kCCSuccess) { "Decryption failed with error code: $operationResult" }
            outBytes.copyOf(dataOutMoved.value.toInt())
        }
    }

    private fun validateAndGetKeySize(key: NSData): ULong = when (key.length) {
        AesCryptoService.KeySize.AES_128.byteSize.toULong() -> kCCKeySizeAES128.toULong()
        // AesCryptoService.KeySize.AES_192.byteSize.toULong() -> kCCKeySizeAES192.toULong()
        AesCryptoService.KeySize.AES_256.byteSize.toULong() -> kCCKeySizeAES256.toULong()
        else -> throw IllegalArgumentException("Invalid size for key: ${key.length}")
    }
}