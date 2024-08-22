@file:JsQualifier("storage")
package com.icure.sdk.js.storage

import kotlin.js.Promise

@JsName("KeyStorageFacade")
external interface KeyStorageFacadeJs {
	fun getPublicKeySpki(storageEntryKey: String): Promise<ByteArray?>
	fun getPrivateKeyPkcs8(storageEntryKey: String): Promise<ByteArray?>
	fun deleteKey(storageEntryKey: String): Promise<Unit>
	fun storePublicKey(storageEntryKey: String, publicKeySpki: ByteArray): Promise<Unit>
	fun storePrivateKey(storageEntryKey: String, privateKey: ByteArray): Promise<Unit>
}

@JsName("KeyStorageFacade")
external interface StorageFacadeJs {
	fun getItem(key: String): Promise<String?>
	fun setItem(key: String, value: String): Promise<Unit>
	fun removeItem(key: String): Promise<Unit>
}