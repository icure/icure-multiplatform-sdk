package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import com.icure.kryptom.utils.base64Decode
import com.icure.kryptom.utils.base64Encode
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object Pkcs8BytesAsBase64Serializer: KSerializer<Pkcs8Bytes> {
	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Pkcs8BytesBase64", PrimitiveKind.STRING)
	override fun deserialize(decoder: Decoder): Pkcs8Bytes = Pkcs8Bytes(base64Decode(decoder.decodeString()))
	override fun serialize(encoder: Encoder, value: Pkcs8Bytes) = encoder.encodeString(base64Encode(value.bytes))
}
