package com.icure.sdk.utils.time

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset

data class ZonedDateTime(
	val dateTime: LocalDateTime,
	val zoneOffset: UtcOffset,
	val zoneId: TimeZone
)