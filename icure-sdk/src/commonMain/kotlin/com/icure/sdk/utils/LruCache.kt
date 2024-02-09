package com.icure.sdk.utils

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Note: not thread safe
 */
@InternalIcureApi
class LruCache<K : Any, V : Any>(
	private val maxCacheSize: Int,
) {
	// Most recently used
	private var lastNode: CacheNode<K, V>? = null
	// Least recently used
	private var firstNode: CacheNode<K, V>? = null
	private val cache: MutableMap<K, CacheNode<K, V>> = mutableMapOf()

	private data class CacheNode<K : Any, V : Any>(
		val key: K,
		val value: V,
		var prev: CacheNode<K, V>? = null,
		var next: CacheNode<K, V>? = null,
	)

	/**
	 * Get the value cached for [key] or null if there is no cached value.
	 */
	fun get(key: K): V? =
		cache[key]?.also { setUsed(it) }?.value

	/**
	 * Updates the value for [key] to [value].
	 */
	fun set(key: K, value: V) {
		val node = cache[key] ?: CacheNode(key, value).also {
			if (cache.size >= maxCacheSize) evictOldest()
			cache[key] = it
		}
		setUsed(node)
	}

	private fun evictOldest() {
		firstNode?.also { oldest ->
			cache.remove(oldest.key)
			firstNode = oldest.next
			firstNode?.prev = null
		}
	}

	private fun setUsed(node: CacheNode<K, V>) {
		if (node !== lastNode) {
			if (node === firstNode) {
				firstNode = node.next
				firstNode?.prev = null
			} else {
				node.prev?.next = node.next
				node.next?.prev = node.prev
			}
			lastNode?.next = node
			node.prev = lastNode
			node.next = null
			lastNode = node
		}
	}

	fun clear() {
		cache.clear()
		lastNode = null
		firstNode = null
	}
}
