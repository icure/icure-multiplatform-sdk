package com.icure.cardinal.sdk.storage

import com.icure.kryptom.apple.toByteArray
import com.icure.kryptom.apple.toNSData
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import io.ktor.utils.io.core.toByteArray
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.CoreFoundation.CFDictionaryAddValue
import platform.CoreFoundation.CFDictionaryCreateMutable
import platform.CoreFoundation.CFTypeRefVar
import platform.CoreFoundation.kCFAllocatorDefault
import platform.CoreFoundation.kCFBooleanTrue
import platform.CoreFoundation.kCFTypeDictionaryKeyCallBacks
import platform.CoreFoundation.kCFTypeDictionaryValueCallBacks
import platform.Foundation.CFBridgingRetain
import platform.Foundation.NSData
import platform.Security.SecAccessControlCreateFlags
import platform.Security.SecItemCopyMatching
import platform.Security.errSecSuccess
import platform.Security.errSecItemNotFound
import platform.Security.kSecAccessControlBiometryAny
import platform.Security.kSecAccessControlDevicePasscode
import platform.Security.kSecAttrApplicationTag
import platform.Security.kSecClass
import platform.Security.kSecClassKey
import platform.Security.kSecMatchLimit
import platform.Security.kSecMatchLimitOne
import platform.Security.kSecReturnData

actual suspend fun getOrCreateSecretKey(storageFacade: StorageFacade, key: String, accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService): AesKey<AesAlgorithm.CbcWithPkcs7Padding> {
	return getSecretKey(cryptoService) ?: createSecretKey(accessLevel, cryptoService)
}

@OptIn(ExperimentalForeignApi::class)
private suspend fun getSecretKey(cryptoService: CryptoService): AesKey<AesAlgorithm.CbcWithPkcs7Padding>? {
	val query = CFDictionaryCreateMutable(
		kCFAllocatorDefault,
		4,
		kCFTypeDictionaryKeyCallBacks.ptr,
		kCFTypeDictionaryValueCallBacks.ptr
	).also {
		CFDictionaryAddValue(it, kSecClass, kSecClassKey)
		CFDictionaryAddValue(it, kSecAttrApplicationTag, CFBridgingRetain(key.toByteArray().toNSData()))
		CFDictionaryAddValue(it, kSecReturnData, kCFBooleanTrue)
		CFDictionaryAddValue(it, kSecMatchLimit, kSecMatchLimitOne)
	}

	return memScoped {
		var item = alloc<CFTypeRefVar>()
		val status = SecItemCopyMatching(query, item.ptr)

		if (status == errSecSuccess) {
			val data = item.value as? NSData
			val bytes = data?.toByteArray() ?: throw IllegalStateException("Failed to get key data or cast to NSData went wrong")
			cryptoService.aes.loadKey(AesAlgorithm.CbcWithPkcs7Padding, bytes)
		} else {
			if (status == errSecItemNotFound) {
				return null
			}
			throw IllegalStateException("Failed to get key data")
		}
	}
}

private suspend fun createSecretKey(accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService): AesKey<AesAlgorithm.CbcWithPkcs7Padding> {
	val aesKey = cryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
	val bytes = cryptoService.aes.exportKey(aesKey)

	val accessControl: SecAccessControlCreateFlags = accessLevel.first().toSecAccessControlCreateFlags()
}

private fun SecureKeyAccessLevel.toSecAccessControlCreateFlags(): SecAccessControlCreateFlags {
	return when (this) {
		SecureKeyAccessLevel.DevicePasscode -> kSecAccessControlDevicePasscode
		SecureKeyAccessLevel.Biometric -> kSecAccessControlBiometryAny
	}
}
