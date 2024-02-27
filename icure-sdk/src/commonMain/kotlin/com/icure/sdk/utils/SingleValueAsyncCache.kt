package com.icure.sdk.utils

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.completeWith
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.concurrent.Volatile

/**
 * Caches a single value with unlimited duration. The cache population/value retrieval function can be a suspend
 * function when retrieving the value.
 * If multiple coroutines try to retrieve the value at once only one will actually perform the work, while others will
 * wait for the result.
 * If a coroutine B is waiting for the result that is being processed by coroutine A, and coroutine A is cancelled, then
 * coroutine B (or another coroutine that was waiting for the result) will restart the retrieval process.
 * @param TCached type of the cached value.
 * @param TRetrieved type of the retrieved value. Usually it is the same as the cached type, but it can be different if
 * the retrieved value has some potential uses but can't be safely cached long term (it is subject to too many changes).
 */
class SingleValueAsyncCache<TCached : Any, TRetrieved : Any> { // TODO test
	private val mutex: Mutex = Mutex(false)
	@Volatile
	private var cache: Deferred<TCached>? = null

	/**
	 * Get the cached value if it exists, or retrieve it if it doesn't.
	 * @return the existing cached value and null, or the newly cached value and the retrieved value if the calling
	 * coroutine was the one that retrieved it.
	 */
	suspend fun getCachedOrRetrieve(
		doRetrieve: suspend () -> Pair<TCached, TRetrieved>
	): Pair<TCached, TRetrieved?> = cache?.takeIf{
		it.isCompleted && !it.isCancelled // Terminated successfully
	}?.await()?.let {
		it to null
	} ?: joinOrRetrieve(doRetrieve)

	private tailrec suspend fun joinOrRetrieve(
		doRetrieve: suspend () -> Pair<TCached, TRetrieved>
	): Pair<TCached, TRetrieved?> = coroutineScope {
		val cacheInfo: Deferred<Pair<TCached, TRetrieved?>?> = mutex.withLock {
			cache?.takeIf { !it.isCancelled }?.let {
				async(start = CoroutineStart.LAZY) {
					try {
						it.await() to null
					} catch (e: Throwable) {
						null
					}
				}
			} ?: kotlin.run {
				val completableCache = CompletableDeferred<TCached>()
				cache = completableCache
				async(start = CoroutineStart.LAZY) {
					kotlin.runCatching {
						doRetrieve()
					}.also { res ->
						completableCache.completeWith(res.map { it.first })
					}.getOrThrow()
				}
			}
		}
		/*
		 * If this coroutine was doing retrieval job, and it failed (the job was cancelled or threw exception) the
		 * error is propagated to the caller.
		 * If another coroutine was doing the job, and it failed, we will catch the error and get null. .
		 */
		cacheInfo.await()
	} ?: joinOrRetrieve(doRetrieve)

	suspend fun update(
		doUpdate: suspend (TCached?) -> Pair<TCached, TRetrieved>
	): Pair<TCached, TRetrieved> = coroutineScope {
		val updated = mutex.withLock {
			val currCache = cache
			val completableCache = CompletableDeferred<TCached>()
			async(start = CoroutineStart.LAZY) {
				kotlin.runCatching {
					// If I inline prev in the do update the compiler crashes... on 1.9.22
					val prev = currCache?.takeIf { !it.isCancelled }?.await()
					doUpdate(prev)
				}.also {
					completableCache.completeWith(it.map { it.first })
				}.getOrThrow()
			}
		}
		updated.await()
	}

	/**
	 * Delete the cached value. It will be retrieved again the next time it is requested.
	 * Calls to retrieve the cached method executed concurrently to the deletion may return the obsolete value. Any
	 * coroutine already waiting on a result still being processed will not be affected either.
	 */
	fun deleteCache() {
		cache = null
	}
}