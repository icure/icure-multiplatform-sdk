package com.icure.cardinal.sdk.utils

import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Thread-safe wrapper for an LRU cache that allows for asynchronous value retrieval. Ensures that retrieval job is
 * performed only once per key.
 */
@InternalIcureApi
class LruCacheWithAsyncRetrieve<K : Any, V : Any>(
	maxCacheSize: Int,
) { // TODO test
	private data class ValueHolder<V>(var valueJob: Deferred<V>)

	private val mutex: Mutex = Mutex()
	private val cache: LruCache<K, ValueHolder<V>> = LruCache(maxCacheSize)


	/**
	 * Get the value cached for [key] if it exists and it is valid according to [validate], else retrieve it using
	 * [doRetrieve] and cache it, evicting the least recently used key if necessary.
	 * If another coroutine is already retrieving the value, this coroutine will wait for that job to complete. If the
	 * job started by another coroutine fails, one of the waiting coroutines will reattempt the job. If this coroutine
	 * was performing the job and it fails to retrieve the value, the error is propagated to the caller.
	 * Note that validate is not called if there is no value cached (the retrieved value is automatically considered as
	 * valid)
	 */
	suspend fun getCachedOrRetrieve(
		key: K,
		validate: suspend (V) -> Boolean = { true},
		doRetrieve: suspend () -> V
	): V = coroutineScope {
		val (holder, job, createdByThis) = mutex.withLock {
			(
				cache.get(key)?.let { Pair(it, false) }
					?: Pair(ValueHolder(async(start = CoroutineStart.LAZY) { doRetrieve() }), true).also {
						cache.set(key, it.first)
					}
			).let { Triple(it.first, it.first.valueJob, it.second) }
		}
		if (createdByThis) {
			job.await()
		} else {
			awaitOtherCoroutineNodeJob(holder, job, validate, doRetrieve)
		}
	}

	private suspend fun awaitOtherCoroutineNodeJob(
		holder: ValueHolder<V>,
		initialJob: Deferred<V>,
		validate: suspend (V) -> Boolean,
		doRetrieve: suspend () -> V
	): V = coroutineScope {
		tailrec suspend fun recursively(latestJob: Deferred<V>): V {
			val res = kotlin.runCatching { latestJob.await() }.getOrNull()?.takeIf { validate(it) }
			if (res != null) return res
			val (newJob, createdByThis) = mutex.withLock {
				if (holder.valueJob === latestJob) { // No one has updated the job between me awaiting and me getting the lock
					holder.valueJob = async(start = CoroutineStart.LAZY) { doRetrieve() }
					Pair(holder.valueJob, true)
				} else {
					Pair(holder.valueJob, false)
				}
			}
			return if (createdByThis) {
				newJob.await()
			} else {
				recursively(newJob)
			}
		}
		recursively(initialJob)
	}


	/**
	 * Get the value cached for [key], or if another coroutine is already retrieving the value wait for it to be ready.
	 * If that job fails the value is considered as if it was not cached and this method returns null.
	 */
	suspend fun getIfCached(key: K): V? = mutex.withLock {
		cache.get(key)?.valueJob
	}?.await()

	/**
	 * Updates the value for [key] to [value]. If there were some coroutines waiting for a value of key to be retrieved
	 * they will not be notified of the updated value, and just continue waiting for the original request, but new
	 * `get` requests will see [value] as the cached value for [key].
	 */
	suspend fun set(key: K, value: V) = mutex.withLock {
		cache.set(key, ValueHolder(CompletableDeferred(value)))
	}

	/**
	 * Clears the cache. Does not affect coroutines that are currently waiting for a value to be retrieved, but the
	 * value won't be cached once retrieved.
	 */
	suspend fun clear() = mutex.withLock {
		cache.clear()
	}
}