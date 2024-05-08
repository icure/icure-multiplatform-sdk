package com.icure.sdk.serialization

import com.icure.sdk.utils.time.ZonedDateTime
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.UtcOffset
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object ZonedDateTimeSerializer : KSerializer<ZonedDateTime> {

	private val isoRegex = "^(?<localTime>[^+]+)(?<offset>[^\\[]+)\\[(?<zoneId>.+)]".toRegex()

	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ZonedDateTime", PrimitiveKind.STRING)

	override fun serialize(encoder: Encoder, value: ZonedDateTime) {
		val dateAsString = buildString {
			append(value.dateTime)
			append(value.zoneOffset)
			append("[${value.zoneId}]")
		}
		encoder.encodeString(dateAsString)
	}

	override fun deserialize(decoder: Decoder): ZonedDateTime {
		val isoDateString = decoder.decodeString()
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