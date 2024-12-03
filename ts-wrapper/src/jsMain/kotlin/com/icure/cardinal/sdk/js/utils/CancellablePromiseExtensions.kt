package com.icure.cardinal.sdk.js.utils

import com.icure.cardinal.sdk.js.exceptions.CancellationExceptionJs
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.js.Promise

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> CoroutineScope.cancellablePromise(
	context: CoroutineContext = EmptyCoroutineContext,
	start: CoroutineStart = CoroutineStart.DEFAULT,
	block: suspend CoroutineScope.() -> T
): CancellablePromise<T> {
	val deferred = async(context, start, block)
	val deferredPromise = Promise { resolve, reject ->
		with(deferred) {
			invokeOnCompletion {
				val e = getCompletionExceptionOrNull()
				if (e != null) {
					if (e is CancellationException) {
						reject(CancellationExceptionJs())
					} else {
						reject(e)
					}
				} else {
					resolve(getCompleted())
				}
			}
		}
	}
	val promiseDynamic = deferredPromise.asDynamic()
	promiseDynamic.deferred = deferred
	val cancel: () -> Unit = { deferred.cancel() }
	promiseDynamic.cancel = cancel
	@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
	return promiseDynamic as CancellablePromise<T>
}
