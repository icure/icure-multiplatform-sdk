package com.icure.kryptom.crypto

import com.icure.kryptom.crypto.AesService.Companion.IV_BYTE_LENGTH
import com.icure.kryptom.crypto.AesService.Companion.aesEncryptedSizeFor
import com.icure.kryptom.utils.PlatformMethodException
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
import platform.CoreCrypto.kCCKeySizeAES256
import platform.CoreCrypto.kCCOptionPKCS7Padding
import platform.CoreCrypto.kCCSuccess

object IosAesService : AesService {
	override suspend fun <A : AesAlgorithm> generateKey(algorithm: A, size: AesService.KeySize): AesKey<A> =
		AesKey(
			IosStrongRandom.randomBytes(size.byteSize),
			algorithm
		)

	override suspend fun exportKey(key: AesKey<*>): ByteArray =
		key.rawKey.copyOf()

	override suspend fun <A : AesAlgorithm> loadKey(algorithm: A, bytes: ByteArray): AesKey<A> =
		AesKey(
			bytes.copyOf(),
			algorithm
		)

	override suspend fun encrypt(data: ByteArray, key: AesKey<*>, iv: ByteArray?): ByteArray {
		require (key.algorithm == AesAlgorithm.CbcWithPkcs7Padding) {
			"Unsupported aes algorithm: ${key.algorithm}"
		}
		if (iv != null) require(iv.size == IV_BYTE_LENGTH) {
			"Initialization vector must be $IV_BYTE_LENGTH bytes long (got ${iv.size})."
		}
		val generatedIv = iv ?: IosStrongRandom.randomBytes(IV_BYTE_LENGTH)
		val outBytes = generatedIv.copyOf(IV_BYTE_LENGTH + aesEncryptedSizeFor(data.size))
		memScoped {
			val dataOutMoved = alloc<ULongVar>()
			val operationResult = data.usePinned { pinnedData ->
				generatedIv.usePinned { pinnedIv ->
					outBytes.usePinned { pinnedOut ->
						// TODO if in future we need to support anything other than CBC we will need to use `CCCryptorCreateWithMode`
						key.rawKey.usePinned { pinnedKey ->
							CCCrypt(
								kCCEncrypt,
								kCCAlgorithmAES,
								kCCOptionPKCS7Padding,
								pinnedKey.addressOf(0),
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
			}
			if (operationResult != kCCSuccess) throw PlatformMethodException(
				"Encryption failed with error code $operationResult",
				operationResult
			)
			if (dataOutMoved.value != (outBytes.size - IV_BYTE_LENGTH).toULong()) throw PlatformMethodException(
				"Expected ${outBytes.size - IV_BYTE_LENGTH} encrypted bytes but got ${dataOutMoved.value}",
				null
			)
		}
		return outBytes
	}

	override suspend fun decrypt(ivAndEncryptedData: ByteArray, key: AesKey<*>): ByteArray {
		require (key.algorithm == AesAlgorithm.CbcWithPkcs7Padding) {
			"Unsupported aes algorithm: ${key.algorithm}"
		}
		val outBytes = ByteArray(ivAndEncryptedData.size - IV_BYTE_LENGTH)
		return memScoped {
			val dataOutMoved = alloc<ULongVar>()
			val operationResult = outBytes.usePinned { pinnedOutBytes ->
				ivAndEncryptedData.usePinned { pinnedIvAndEncryptedData ->
					key.rawKey.usePinned { pinnedKey ->
						// TODO if in future we need to support anything other than CBC we will need to use `CCCryptorCreateWithMode`
						CCCrypt(
							kCCDecrypt,
							kCCAlgorithmAES,
							kCCOptionPKCS7Padding,
							pinnedKey.addressOf(0),
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
			}
			// Refer to Applications/Xcode.app/Contents/Developer/Platforms/iPhoneOS.platform/Developer/SDKs/iPhoneOS.sdk/usr/include/CommonCrypto/CommonCryptoError.h
			if (operationResult != kCCSuccess) throw PlatformMethodException(
				"Decryption failed with error code: $operationResult",
				operationResult
			)
			outBytes.copyOf(dataOutMoved.value.toInt())
		}
	}

	private fun validateAndGetKeySize(key: AesKey<*>): ULong = when (key.rawKey.size) {
		AesService.KeySize.Aes128.byteSize -> kCCKeySizeAES128.toULong()
		// AesCryptoService.KeySize.AES_192.byteSize.toULong() -> kCCKeySizeAES192.toULong()
		AesService.KeySize.Aes256.byteSize -> kCCKeySizeAES256.toULong()
		else -> throw IllegalArgumentException("Invalid size for key: ${key.rawKey.size}")
	}
}