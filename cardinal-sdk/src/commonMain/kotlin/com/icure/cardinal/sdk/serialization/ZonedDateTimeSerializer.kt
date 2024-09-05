package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.utils.time.ZonedDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object ZonedDateTimeSerializer : KSerializer<ZonedDateTime> {
	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ZonedDateTime", PrimitiveKind.STRING)

	override fun serialize(encoder: Encoder, value: ZonedDateTime) {
		encoder.encodeString(value.toIso8601String())
	}

	override fun deserialize(decoder: Decoder): ZonedDateTime {
		return ZonedDateTime.fromIso8601String(decoder.decodeString())
	}
}