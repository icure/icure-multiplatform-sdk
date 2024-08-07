package com.icure.sdk.utils

import kotlinx.coroutines.delay
import kotlin.time.Duration

tailrec suspend fun <T> retryWithDelays(
	delays: List<Duration>,
	block: suspend () -> T
): T {
	val result = kotlin.runCatching { block() }
	return if (result.isSuccess || delays.isEmpty()) {
		result.getOrThrow()
	} else {
		delay(delays.first())
		retryWithDelays(delays.drop(1), block)
	}
}