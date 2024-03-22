package com.icure.sdk.utils

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * A wrapper around an LRU cache that protects all the operations with a mutex.
 */
@InternalIcureApi
class SynchronisedLruCache<K : Any, V : Any>(
	maxCacheSize: Int,
) {
	private val mutex = Mutex()
	private val cache = LruCache<K, V>(maxCacheSize)

	suspend fun clear() = mutex.withLock { cache.clear() }

	/**
	 * Get the value cached for [key] or null if there is no cached value.
	 */
	suspend fun get(key: K): V? = mutex.withLock { cache.get(key) }

	/**
	 * Updates the value for [key] to [value].
	 */
	suspend fun set(key: K, value: V) = mutex.withLock { cache.set(key, value) }

	/**
	 * Gets all the values cached for the keys in [keys]. You can get an equivalent result by calling get many times, but
	 * this ensures the lock is taken only once.
	 */
	suspend fun getMany(keys: Collection<K>): Map<K, V> = mutex.withLock {
		keys.mapNotNull { k -> cache.get(k)?.let { v -> k to v } }
	}.toMap()

	/**
	 * Sets the provided values. You can get an equivalent result by calling set many times, but
	 * this ensures the lock is taken only once.
	 */
	suspend fun setMany(keys: Collection<Pair<K, V>>): Unit = mutex.withLock {
		keys.forEach { (k, v) -> cache.set(k, v) }
	}
}
