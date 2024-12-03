package com.icure.cardinal.sdk.utils

internal object LongPollingUtils {
	/**
	 * Gives a list of integers summing up to [totalWait] with each int not exceeding [maxRequestLength], which can be
	 * used as parameter for the timeout of long-polling requests.
	 * Favors returning more medium-length calls over all [maxRequestLength] calls + a very short last call.
	 */
	fun splitForRequestsDuration(
		totalWait: Int,
		maxRequestLength: Int
	): List<Int> {
		require(totalWait > 0) { "Total wait must be positive" }
		require(maxRequestLength > 0) { "Max request length must be positive" }
		val nOfCalls = totalWait / maxRequestLength + if (totalWait % maxRequestLength > 0) 1 else 0
		val callLength = totalWait / nOfCalls
		val totalRemainder = totalWait - callLength * nOfCalls
		val maxAddableToEachCall = maxRequestLength - callLength
		return if (totalRemainder == 0) List(nOfCalls) { callLength } else List(nOfCalls) {
			when {
				it < totalRemainder / maxAddableToEachCall -> maxAddableToEachCall + callLength
				it == totalRemainder / maxAddableToEachCall -> (totalRemainder % maxAddableToEachCall) + callLength
				else -> callLength
			}
		}
	}

	/**
	 * Performs long polling, doing multiple requests if needed (at most as many as the entries in [timeouts]).
	 * Returns the first successful [request] result ([shouldRetry] is false for that result), or the last result if
	 * no request was successful for the provided timeouts.
	 */
	inline fun <T> doLongPoll(
		timeouts: List<Int>,
		request: (timeout: Int) -> T,
		shouldRetry: (T) -> Boolean
	): T {
		require(timeouts.isNotEmpty()) { "Timeouts can't be empty" }
		var latestResponse: T
		val timeoutsIterator = timeouts.iterator()
		do {
			latestResponse = request(timeoutsIterator.next())
		} while (shouldRetry(latestResponse) && timeoutsIterator.hasNext())
		return latestResponse
	}
}