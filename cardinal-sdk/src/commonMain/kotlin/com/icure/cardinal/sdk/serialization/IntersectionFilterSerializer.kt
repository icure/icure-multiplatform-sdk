package com.icure.cardinal.sdk.serialization

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.IntersectionFilter
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

@OptIn(ExperimentalSerializationApi::class)
internal class IntersectionFilterSerializer<O : Identifiable<String>>(
	private val abstractFilterSerializer: KSerializer<AbstractFilter<O>>
): KSerializer<IntersectionFilter<O>> {

	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("IntersectionFilter") {
		element("filters", ListSerializer(abstractFilterSerializer).descriptor)
		element<String?>("desc")
	}

	override fun deserialize(decoder: Decoder): IntersectionFilter<O> =
		decoder.decodeStructure(descriptor) {
			var filters: List<AbstractFilter<O>> = emptyList()
			var desc: String? = null
			while (true) {
				when (val index = decodeElementIndex(descriptor)) {
					0 -> filters = decodeSerializableElement(descriptor, 0, ListSerializer(abstractFilterSerializer))
					1 -> desc = decodeNullableSerializableElement(descriptor, 1, String.serializer())
					CompositeDecoder.DECODE_DONE -> break
					else -> error("Unexpected index: $index")
				}
			}
			IntersectionFilter(
				filters = filters,
				desc = desc,
			)
		}

	override fun serialize(encoder: Encoder, value: IntersectionFilter<O>) = encoder.encodeStructure(descriptor) {
		encodeSerializableElement(descriptor, 0, ListSerializer(abstractFilterSerializer), value.filters)
		encodeNullableSerializableElement(descriptor, 1, String.serializer(), value.desc)
	}
}
