package com.icure.sdk.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

/**
 * Get the epoch timestamp in milliseconds (since midnight, January 1, 1970 UTC).
 */
fun currentEpochMs(): Long =
	currentEpochInstant().toEpochMilliseconds()

/**
 * Get the current epoch timestamp.

 */
fun currentEpochInstant(): Instant =
	Clock.System.now()