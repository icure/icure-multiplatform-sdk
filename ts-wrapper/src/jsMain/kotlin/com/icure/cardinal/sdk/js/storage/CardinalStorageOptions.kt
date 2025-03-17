package com.icure.cardinal.sdk.js.storage

import com.icure.cardinal.sdk.storage.KeyStorageFacade
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.storage.impl.FileStorageFacade
import com.icure.cardinal.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.cardinal.sdk.storage.impl.JwkKeyStorage
import com.icure.cardinal.sdk.storage.impl.LocalStorageStorageFacade
import kotlinx.coroutines.await

@JsExport
sealed interface CardinalStorageOptions

internal data class FileSystemStorageOptions(val directory: String): CardinalStorageOptions

internal data object BrowserLocalStorageOptions : CardinalStorageOptions

@JsExport
sealed interface CardinalKeyStorageOptions

internal data class JsonAndBase64KeyStorageOptions(val baseStorage: dynamic) : CardinalKeyStorageOptions

internal data class JwkKeyStorageOptions(val baseStorage: dynamic) : CardinalKeyStorageOptions

@JsExport
object InternalCardinalStorageOptionsFactory {
	fun fileSystem(directory: String): CardinalStorageOptions = FileSystemStorageOptions(directory)

	fun browserLocalStorage(): CardinalStorageOptions = BrowserLocalStorageOptions
}

@JsExport
object InternalCardinalKeyStorageOptionsFactory {
	fun encodingAsBase64(baseStorage: dynamic): CardinalKeyStorageOptions = JsonAndBase64KeyStorageOptions(baseStorage)

	fun encodingAsJwk(baseStorage: dynamic): CardinalKeyStorageOptions = JwkKeyStorageOptions(baseStorage)
}

internal suspend fun loadStorageOptions(
	options: dynamic
): StorageFacade = if (options is CardinalStorageOptions) when (options) {
	BrowserLocalStorageOptions -> LocalStorageStorageFacade()
	is FileSystemStorageOptions -> FileStorageFacade(options.directory)
	else -> throw IllegalArgumentException("Invalid storage options")
} else {
	require(
		jsTypeOf(options.getItem) == "function" &&
		jsTypeOf(options.setItem) == "function" &&
		jsTypeOf(options.removeItem) == "function"
	) {
		"Provided storage options do not respect the interface of the storage facade and are not standard icure storage options"
	}
	@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
	StorageFacadeBridge(options as StorageFacadeJs)
}

private class StorageFacadeBridge(
	private val jsFacade: StorageFacadeJs
): StorageFacade {
	override suspend fun getItem(key: String): String? =
		jsFacade.getItem(key).await()

	override suspend fun setItem(key: String, value: String) {
		jsFacade.setItem(key, value).await()
	}

	override suspend fun removeItem(key: String) {
		jsFacade.removeItem(key).await()
	}
}

internal suspend fun loadKeyStorageOptions(
	options: dynamic
): KeyStorageFacade = if (options is CardinalKeyStorageOptions) when (options) {
	is JsonAndBase64KeyStorageOptions -> JsonAndBase64KeyStorage(loadStorageOptions(options))
	is JwkKeyStorageOptions -> JwkKeyStorage(loadStorageOptions(options))
	else -> throw IllegalArgumentException("Invalid key storage options")
} else {
	require(
		jsTypeOf(options.getPublicKeySpki) == "function" &&
			jsTypeOf(options.getPrivateKeyPkcs8) == "function" &&
			jsTypeOf(options.deleteKey) == "function" &&
			jsTypeOf(options.storePublicKey) == "function" &&
			jsTypeOf(options.storePrivateKey) == "function"
	) {
		"Provided storage options do not respect the interface of the key storage facade and are not standard icure storage options"
	}
	@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
	KeyStorageFacadeBridge(options as KeyStorageFacadeJs)
}

private class KeyStorageFacadeBridge(
	private val jsFacade: KeyStorageFacadeJs
): KeyStorageFacade {
	override suspend fun getPublicKeySpki(storageEntryKey: String): ByteArray? {
		return jsFacade.getPublicKeySpki(storageEntryKey).await()
	}

	override suspend fun getPrivateKeyPkcs8(storageEntryKey: String): ByteArray? {
		return jsFacade.getPrivateKeyPkcs8(storageEntryKey).await()
	}

	override suspend fun deleteKey(storageEntryKey: String) {
		jsFacade.deleteKey(storageEntryKey).await()
	}

	override suspend fun storePublicKey(storageEntryKey: String, publicKeySpki: ByteArray) {
		jsFacade.storePublicKey(storageEntryKey, publicKeySpki).await()
	}

	override suspend fun storePrivateKey(storageEntryKey: String, privateKey: ByteArray) {
		jsFacade.storePrivateKey(storageEntryKey, privateKey).await()
	}
}
