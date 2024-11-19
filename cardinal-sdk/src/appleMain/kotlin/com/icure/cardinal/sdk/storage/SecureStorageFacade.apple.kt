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
import platform.Security.SecAccessControlCreateWithFlags
import platform.Security.SecItemAdd
import platform.Security.SecItemCopyMatching
import platform.Security.errSecItemNotFound
import platform.Security.errSecSuccess
import platform.Security.kSecAccessControlBiometryAny
import platform.Security.kSecAccessControlDevicePasscode
import platform.Security.kSecAttrAccessControl
import platform.Security.kSecAttrAccessibleWhenUnlockedThisDeviceOnly
import platform.Security.kSecAttrApplicationTag
import platform.Security.kSecClass
import platform.Security.kSecClassKey
import platform.Security.kSecMatchLimit
import platform.Security.kSecMatchLimitOne
import platform.Security.kSecReturnData
import platform.Security.kSecValueData

actual suspend fun getOrCreateSecretKey(storageFacade: StorageFacade, key: String, accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService): AesKey<AesAlgorithm.CbcWithPkcs7Padding> {
	return getSecretKey(cryptoService, key) ?: createSecretKey(accessLevel, cryptoService, key)
}

@OptIn(ExperimentalForeignApi::class)
private suspend fun getSecretKey(cryptoService: CryptoService, key: String): AesKey<AesAlgorithm.CbcWithPkcs7Padding>? {
	val query = CFDictionaryCreateMutable(
		allocator = kCFAllocatorDefault,
		capacity = 4,
		keyCallBacks = kCFTypeDictionaryKeyCallBacks.ptr,
		valueCallBacks = kCFTypeDictionaryValueCallBacks.ptr
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

@OptIn(ExperimentalForeignApi::class)
private suspend fun createSecretKey(accessLevel: Set<SecureKeyAccessLevel>, cryptoService: CryptoService, key: String): AesKey<AesAlgorithm.CbcWithPkcs7Padding> {

	val aesKey = cryptoService.aes.generateKey(AesAlgorithm.CbcWithPkcs7Padding)
	val bytes = cryptoService.aes.exportKey(aesKey)

	val accessControlFlags: SecAccessControlCreateFlags = accessLevel.fold(0.toULong()) { acc, level -> acc or level.toSecAccessControlCreateFlags() }

	val accessControl = SecAccessControlCreateWithFlags(
		allocator = kCFAllocatorDefault,
		protection = kSecAttrAccessibleWhenUnlockedThisDeviceOnly,
		flags = accessControlFlags,
		error = null
	)

	val query = CFDictionaryCreateMutable(
		allocator = kCFAllocatorDefault,
		capacity = 4,
		keyCallBacks = kCFTypeDictionaryKeyCallBacks.ptr,
		valueCallBacks = kCFTypeDictionaryValueCallBacks.ptr
	).also {
		CFDictionaryAddValue(it, kSecClass, kSecClassKey)
		CFDictionaryAddValue(it, kSecAttrApplicationTag, CFBridgingRetain(key.toByteArray().toNSData()))
		CFDictionaryAddValue(it, kSecValueData, CFBridgingRetain(bytes.toNSData()))
		CFDictionaryAddValue(it, kSecAttrAccessControl, accessControl)
	}

	val status = SecItemAdd(query, null)

	if (status == errSecSuccess) {
		return aesKey
	} else {
		throw IllegalStateException("Failed to generate key data")
	}
}

private fun SecureKeyAccessLevel.toSecAccessControlCreateFlags(): SecAccessControlCreateFlags {
	return when (this) {
		SecureKeyAccessLevel.DevicePasscode -> kSecAccessControlDevicePasscode
		SecureKeyAccessLevel.Biometric -> kSecAccessControlBiometryAny
	}
}
