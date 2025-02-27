package com.icure.cardinal.sdk.utils.time

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset

data class ZonedDateTime(
	val dateTime: LocalDateTime,
	val zoneOffset: UtcOffset,
	val zoneId: TimeZone
) {
	fun toIso8601AndZoneString(): String {
		return if (zoneOffset.toString() == zoneId.id) {
			"$dateTime$zoneOffset"
		} else {
			"$dateTime$zoneOffset[$zoneId]"
		}
	}

	companion object {
		fun fromIso8601AndZoneString(isoAndZoneDateString: String): ZonedDateTime {
			val zoneId = if (isoAndZoneDateString.last() == ']') {
				val zoneIdStartIndex = isoAndZoneDateString.indexOfLast { it == '[' }.also {
					require(it > 0) {
						"Invalid isoAndZoneDateString \"$isoAndZoneDateString\""
					}
				} + 1
				require(zoneIdStartIndex < isoAndZoneDateString.length - 1) {
					"Invalid isoAndZoneDateString \"$isoAndZoneDateString\""
				}
				isoAndZoneDateString.substring(zoneIdStartIndex, isoAndZoneDateString.length - 1)
			} else null
			val stringWithoutZoneId = if (zoneId != null) {
				isoAndZoneDateString.substring(0, isoAndZoneDateString.length - zoneId.length - 2)
			} else isoAndZoneDateString
			val offsetString = if (stringWithoutZoneId.last() == 'Z') {
				"Z"
			} else {
				val offsetStartIndex = stringWithoutZoneId.indexOfLast { it == '+' || it == '-' }.also {
					require(it > 0) {
						"Invalid isoAndZoneDateString \"$isoAndZoneDateString\""
					}
				}
				stringWithoutZoneId.substring(offsetStartIndex)
			}
			val localTimeString = stringWithoutZoneId.dropLast(offsetString.length)
			return ZonedDateTime(
				dateTime = LocalDateTime.parse(localTimeString),
				zoneOffset = UtcOffset.parse(offsetString),
				zoneId = TimeZone.of(zoneId ?: offsetString)
			)
		}
	}
}