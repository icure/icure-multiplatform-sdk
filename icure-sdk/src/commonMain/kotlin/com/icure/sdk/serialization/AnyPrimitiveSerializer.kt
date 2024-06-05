package com.icure.sdk.serialization

import com.icure.sdk.model.specializations.AnyPrimitive
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull

object AnyPrimitiveSerializer : KSerializer<AnyPrimitive> {
	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("AnyPrimitive", PrimitiveKind.STRING)

	override fun deserialize(decoder: Decoder): AnyPrimitive {
		val primitive = decoder.decodeSerializableValue(JsonElement.serializer()).jsonPrimitive
		return AnyPrimitive(primitive.longOrNull ?: primitive.doubleOrNull ?: primitive.booleanOrNull ?: primitive.content)
	}

	override fun serialize(encoder: Encoder, value: AnyPrimitive) {
		encoder.encodeString(value.v.toString())
	}
}