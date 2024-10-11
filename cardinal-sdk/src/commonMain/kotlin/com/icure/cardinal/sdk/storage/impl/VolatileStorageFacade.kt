package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade

/**
 * Facade that does not actually store any data and just keeps it in memory.
 * For testing purposes only: the data will be lost between restarts.
 */
class VolatileStorageFacade : StorageFacade {
	private val storage = mutableMapOf<String, String>()

	override suspend fun getItem(key: String): String? = storage[key]

	override suspend fun setItem(key: String, value: String) {
		storage[key] = value
	}

	override suspend fun removeItem(key: String) {
		storage.remove(key)
	}
}