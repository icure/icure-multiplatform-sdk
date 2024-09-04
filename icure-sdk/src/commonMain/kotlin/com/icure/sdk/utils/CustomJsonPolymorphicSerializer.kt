package com.icure.sdk.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlin.reflect.KClass

internal inline fun <reified T : Any> KSerializer<T>.info(): Pair<KSerializer<T>, KClass<T>> =
	this to T::class

@OptIn(ExperimentalSerializationApi::class)
internal abstract class CustomJsonPolymorphicSerializer<T : Any>(
	private val discriminatorField: String,
	private val tSerialName: String,
) : KSerializer<T> {
	abstract fun getSerializerBySerialName(serialName: String): KSerializer<out T>?
	abstract fun getSerializerByClass(kclass: KClass<out T>): KSerializer<out T>?

	override val descriptor: SerialDescriptor = buildClassSerialDescriptor(tSerialName) {
		element(discriminatorField, String.serializer().descriptor)
	}

	override fun deserialize(decoder: Decoder): T {
		require(decoder is JsonDecoder) { "This class only supports JSON serialization" }
		val json = decoder.decodeJsonElement() as? JsonObject ?: throw SerializationException("Expected to decode a JSON object")
		val serialNameElement = json.jsonObject[discriminatorField] ?: throw SerializationException("Field '$discriminatorField' not found")
		val serialName = (serialNameElement as? JsonPrimitive)?.takeIf { it.isString }?.content ?: throw SerializationException("Field '$discriminatorField' is not a string")
		val serializer = getSerializerBySerialName(serialName) ?: throw SerializationException("Unknown serial name for deserialization of $tSerialName: $serialName")
		return decoder.json.decodeFromJsonElement(serializer, JsonObject(json - discriminatorField))
	}

	override fun serialize(encoder: Encoder, value: T) {
		require(encoder is JsonEncoder) { "This class only supports JSON serialization" }
		val serializer = getSerializerByClass(value::class)?.cast() ?: throw SerializationException("Can't serialize ${value::class} as $tSerialName")
		val json = encoder.json.encodeToJsonElement(serializer, value) as? JsonObject ?: throw SerializationException("Expected to encode a JSON object for ${serializer.descriptor.serialName}")
		encoder.encodeJsonElement(JsonObject(mapOf(discriminatorField to JsonPrimitive(serializer.descriptor.serialName)) + json))
	}

	@Suppress("UNCHECKED_CAST")
	private fun KSerializer<out T>.cast(): KSerializer<T> = this as KSerializer<T>
}
