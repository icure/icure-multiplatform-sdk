package com.icure.cardinal.sdk.serialization

import com.icure.kryptom.crypto.RsaAlgorithm
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object RsaAlgorithmAsIdentifierSerializer : KSerializer<RsaAlgorithm> {
	override val descriptor: SerialDescriptor =
		PrimitiveSerialDescriptor("RsaEncryptionAlgorithm", PrimitiveKind.STRING)

	override fun deserialize(decoder: Decoder): RsaAlgorithm =
		RsaAlgorithm.fromIdentifier(decoder.decodeString())

	override fun serialize(encoder: Encoder, value: RsaAlgorithm) =
		encoder.encodeString(value.identifier)
}

object RsaEncryptionAlgorithmAsIdentifierSerializer : KSerializer<RsaAlgorithm.RsaEncryptionAlgorithm> {
	override val descriptor: SerialDescriptor =
		PrimitiveSerialDescriptor("RsaEncryptionAlgorithm", PrimitiveKind.STRING)

	override fun deserialize(decoder: Decoder): RsaAlgorithm.RsaEncryptionAlgorithm =
		RsaAlgorithm.RsaEncryptionAlgorithm.fromIdentifier(decoder.decodeString())

	override fun serialize(encoder: Encoder, value: RsaAlgorithm.RsaEncryptionAlgorithm) =
		encoder.encodeString(value.identifier)
}

object RsaSignatureAlgorithmAsIdentifierSerializer : KSerializer<RsaAlgorithm.RsaSignatureAlgorithm> {
	override val descriptor: SerialDescriptor =
		PrimitiveSerialDescriptor("RsaEncryptionAlgorithm", PrimitiveKind.STRING)

	override fun deserialize(decoder: Decoder): RsaAlgorithm.RsaSignatureAlgorithm =
		RsaAlgorithm.RsaSignatureAlgorithm.fromIdentifier(decoder.decodeString())

	override fun serialize(encoder: Encoder, value: RsaAlgorithm.RsaSignatureAlgorithm) =
		encoder.encodeString(value.identifier)
}