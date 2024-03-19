package com.icure.sdk.serialization

import com.icure.sdk.model.embed.form.template.StructureElement
import com.icure.sdk.model.embed.form.template.TextField
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object StructureElementSerializer: KSerializer<StructureElement> {
    override val descriptor: SerialDescriptor
        get() =

    override fun deserialize(decoder: Decoder): StructureElement {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: StructureElement) {
        TODO("Not yet implemented")
    }

}

Json {
    serializersModule = SerializersModule {
        polymorphic(StructureElement::class) {
            subclass(TextField::class)
                ...
            defaultDeserializer
        }
    }
}
