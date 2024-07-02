package com.icure.sdk.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A serializer that does not actually allow to serialize/deserialize the entity. Can be used in place of the generic
 * serializer for classes where the type parameter is actually just a marker.
 */
class NoSerializer(name: String) : KSerializer<Nothing> {
	companion object {
		@Suppress("UNCHECKED_CAST")
		inline fun <reified T> get(): KSerializer<T> = NoSerializer(T::class.qualifiedName!!) as KSerializer<T>
	}

	override fun deserialize(decoder: Decoder): Nothing =
		throw UnsupportedOperationException("Should not serialize/deserialize")

	override val descriptor: SerialDescriptor = buildClassSerialDescriptor(name)

	override fun serialize(encoder: Encoder, value: Nothing) {
		throw UnsupportedOperationException("Should not serialize/deserialize")
	}
}