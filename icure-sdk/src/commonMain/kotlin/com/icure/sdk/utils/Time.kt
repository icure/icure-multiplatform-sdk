package com.icure.sdk.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime

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

fun currentFuzzyDateTime(timeZone: TimeZone): Long =
	Clock.System.now().toLocalDateTime(timeZone).format(LocalDateTime.Format {
		year()
		monthNumber()
		dayOfMonth()
		hour()
		minute()
		second()
	}).toLong()
