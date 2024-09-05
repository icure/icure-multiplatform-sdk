package com.icure.cardinal.sdk.serialization

import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object ByteArraySerializer: KSerializer<ByteArray> {
	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ByteArrayBase64", PrimitiveKind.STRING)
	override fun deserialize(decoder: Decoder): ByteArray = base64Decode(decoder.decodeString())
	override fun serialize(encoder: Encoder, value: ByteArray) = encoder.encodeString(base64Encode(value))
}
