package com.icure.sdk.storage

import com.icure.sdk.utils.IllegalEntityException

interface KeyStorageFacade {
	/**
	 * Returns the publicKey of the provided key from the storage
	 * @param storageEntryKey Key of the value to retrieve
	 * @return The publicKey associated to the provided storageEntryKey in spki format or null if no entry has such key.
	 * @throws IllegalEntityException if there is a value stored at the provided entry key, but it is not a public key
	 */
	suspend fun getPublicKeySpki(storageEntryKey: String): ByteArray?

	/**
	 * Returns the privateKey of the provided key from the storage
	 * @param storageEntryKey Key of the value to retrieve
	 * @return The privateKey associated to the provided storageEntryKey in pkcs8 format or null if no entry has such key.
	 * @throws IllegalEntityException if there is a value stored at the provided entry key, but it is not a private key
	 */
	suspend fun getPrivateKeyPkcs8(storageEntryKey: String): ByteArray?

	/**
	 * Delete the key associated to the provided storage entry key
	 * @param storageEntryKey Key of the value to delete
	 */
	suspend fun deleteKey(storageEntryKey: String)

	/**
	 * Stores the given public key under the given key in the storage. If an entry already exists for the given storage
	 * key, it will be overwritten; if you want to store the keypair just store the private key instead (with
	 * [storePrivateKey]), since the public key is derivable from the private key.
	 * @param storageEntryKey The id of the entry in storage
	 * @param publicKeySpki the public key to store, in spki format
	 */
	suspend fun storePublicKey(storageEntryKey: String, publicKeySpki: ByteArray)

	/**
	 * Stores the given public key under the given key in the storage. If an entry already exists for the given storage
	 * key, it will be overwritten.
	 * @param storageEntryKey The id of the entry in storage
	 * @param privateKey the private key to store, in pkcs8 format
	 */
	suspend fun storePrivateKey(storageEntryKey: String, privateKey: ByteArray)
}