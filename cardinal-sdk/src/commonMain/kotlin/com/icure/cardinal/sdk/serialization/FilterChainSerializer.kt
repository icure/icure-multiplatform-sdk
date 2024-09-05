package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

@OptIn(ExperimentalSerializationApi::class)
class FilterChainSerializer<O : Identifiable<String>>(
	private val abstractFilterSerializer: KSerializer<AbstractFilter<O>>
) : KSerializer<FilterChain<O>> {

	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("FilterChain") {
		element("filter", abstractFilterSerializer.descriptor)
		element("predicate", Predicate.serializer().descriptor)
	}

	override fun deserialize(decoder: Decoder): FilterChain<O> =
		decoder.decodeStructure(descriptor) {
			var filter: AbstractFilter<O>? = null
			var predicate: Predicate? = null
			while (true) {
				when (val index = decodeElementIndex(descriptor)) {
					0 -> filter = decodeSerializableElement(descriptor, 0, abstractFilterSerializer)
					1 -> predicate = decodeNullableSerializableElement(descriptor, 1, Predicate.serializer())
					CompositeDecoder.DECODE_DONE -> break
					else -> error("Unexpected index: $index")
				}
			}
			FilterChain(
				filter = checkNotNull(filter) { "Cannot deserialize a FilterChain with a null filter" },
				predicate = predicate,
			)
		}

	override fun serialize(encoder: Encoder, value: FilterChain<O>) = encoder.encodeStructure(descriptor) {
		encodeSerializableElement(descriptor, 0, abstractFilterSerializer, value.filter)
		encodeNullableSerializableElement(descriptor, 1, Predicate.serializer(), value.predicate)
	}
}
