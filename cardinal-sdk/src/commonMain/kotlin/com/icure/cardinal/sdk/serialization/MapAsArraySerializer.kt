package com.icure.cardinal.sdk.serialization

import com.icure.utils.InternalIcureApi
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ArraySerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Serializer needed for maps with a key type that is not a valid json key type
 */
@InternalIcureApi
@OptIn(ExperimentalSerializationApi::class)
class MapAsArraySerializer<K, V>(
	keySerializer: KSerializer<K>,
	valueSerializer: KSerializer<V>
) : KSerializer<Map<K, V>> {
	@Serializable
	private data class KeyValue<K, V>( val k: K, val v: V )

	private val arraySerializer = ArraySerializer(KeyValue.serializer(keySerializer, valueSerializer))

	override val descriptor: SerialDescriptor get() = arraySerializer.descriptor

	override fun deserialize( decoder: Decoder): Map<K, V> = decoder
		.decodeSerializableValue(arraySerializer)
		.groupBy { it.k }
		.mapValues {
			(it.value.singleOrNull() ?: throw SerializationException("Map has duplicate keys ${it.key}")).v
		}

	override fun serialize(encoder: Encoder, value: Map<K, V>) = encoder.encodeSerializableValue(
		arraySerializer,
		value.map { KeyValue( it.key, it.value ) }.toTypedArray()
	)
}