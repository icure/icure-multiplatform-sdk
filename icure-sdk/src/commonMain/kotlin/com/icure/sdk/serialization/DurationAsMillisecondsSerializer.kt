package com.icure.sdk.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

object DurationAsMillisecondsSerializer : KSerializer<Duration> {

	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("durationAsMilliseconds", PrimitiveKind.DOUBLE)

	override fun deserialize(decoder: Decoder): Duration = decoder.decodeDouble().toDuration(DurationUnit.MILLISECONDS)

	override fun serialize(encoder: Encoder, value: Duration) {
		encoder.encodeDouble(value.inWholeMilliseconds.toDouble())
	}
}
