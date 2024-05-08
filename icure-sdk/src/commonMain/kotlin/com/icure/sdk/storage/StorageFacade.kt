package com.icure.sdk.storage

/**
 * Provides permanent storage capabilities to the SDK
 */
interface StorageFacade {
	/**
	 * Returns the value of the provided key from the storage
	 * @param key Key of the value to retrieve
	 * @return The value associated to the provided key or null if there is no value stored at the provided key.
	 */
	suspend fun getItem(key: String): String?

	/**
	 * Set an item in the storage for the given key. If an item already exists for the given key, it will be overwritten.
	 * @param key Key of the value to set
	 * @param value the value to store
	 */
	suspend fun setItem(key: String, value: String)

	/**
	 * Removes the item with the given key from the storage, if present.
	 * Does nothing if there is no value.
	 * @param key The key of the item to remove.
	 */
	suspend fun removeItem(key: String)
}