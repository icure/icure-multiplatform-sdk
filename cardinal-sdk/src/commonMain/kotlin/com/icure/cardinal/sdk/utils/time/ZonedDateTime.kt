package com.icure.cardinal.sdk.utils.time

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset

data class ZonedDateTime(
	val dateTime: LocalDateTime,
	val zoneOffset: UtcOffset,
	val zoneId: TimeZone
) {
	fun toIso8601String(): String {
		return "$dateTime$zoneOffset[$zoneId]"
	}

	companion object {
		private val isoRegex = "^(?<localTime>[^+]+)(?<offset>[^\\[]+)\\[(?<zoneId>.+)]".toRegex()

		fun fromIso8601String(isoDateString: String): ZonedDateTime {
			val matches = isoRegex.find(isoDateString)?.groups as? MatchNamedGroupCollection
			val localTimeString = requireNotNull(matches?.get("localTime")?.value) { "Cannot extract LocalDateTime" }
			val zoneOffsetString = requireNotNull(matches?.get("offset")?.value) { "Cannot extract ZoneOffset" }
			val zoneIdString = requireNotNull(matches?.get("zoneId")?.value) { "Cannot extract ZoneId" }
			return ZonedDateTime(
				dateTime = LocalDateTime.parse(localTimeString),
				zoneOffset = UtcOffset.parse(zoneOffsetString),
				zoneId = TimeZone.of(zoneIdString)
			)
		}
	}
}