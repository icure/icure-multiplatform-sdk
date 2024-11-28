package com.icure.cardinal.sdk.dart.utils

import io.ktor.util.collections.ConcurrentMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.serialization.KSerializer

object ApiScope {
	private lateinit var scope: CoroutineScope
	val cancellableJobs = ConcurrentMap<Long, Job>()

	fun setup() {
		scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
	}

	fun teardown() {
		scope.cancel()
	}

	fun <T> execute(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?) -> Unit,
		resultSerializer: KSerializer<T>,
		method: suspend () -> T
	) {
		scope.launch {
			DartResult.inlineResolve(resultCallback, resultSerializer) { method() }
		}
	}

	fun <T> executeCancellable(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?) -> Unit,
		resultSerializer: KSerializer<T>,
		cancellationToken: Long,
		method: suspend () -> T,
	) {
		scope.launch {
			cancellableJobs[cancellationToken] = coroutineContext[Job]!!
			try {
				DartResult.inlineResolve(resultCallback, resultSerializer) { method() }
			} finally {
				cancellableJobs.remove(cancellationToken)
			}
		}
	}

	fun cancel(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?) -> Unit,
		cancellationToken: Long
	) {
		cancellableJobs[cancellationToken]?.cancel()
		resultCallback("{}", null, null)
	}
}
