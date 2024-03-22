package com.icure.sdk.serialization

import com.icure.sdk.model.EntityTemplate
import com.icure.sdk.model.HealthElementTemplate
import com.icure.sdk.model.embed.Medication
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.internal.decodeStringToJsonTree
import kotlinx.serialization.json.internal.decodeToSequenceByReader

/**
 * Serializer for [EntityTemplate].
 *
 */
object EntityTemplateSerializer : KSerializer<EntityTemplate> {

    private const val HEALTH_ELEMENT_TEMPLATE_QUALIFIED_NAME =
        "org.taktik.icure.entities.HealthElementTemplate" // TODO CV: Check if this is the correct qualified name
    private const val MEDICATION_TEMPLATE_QUALIFIED_NAME =
        "org.taktik.icure.entities.Medication" // TODO CV: Check if this is the correct qualified name

    override val descriptor: SerialDescriptor
        get() = buildClassSerialDescriptor("EntityTemplate") {
            element<String>(elementName = "id")
            element<String>(elementName = "rev", isOptional = true)
            element<Long>(elementName = "deletionDate", isOptional = true)
            element<String>(elementName = "userId", isOptional = true)
            element<String>(elementName = "descr", isOptional = true)
            element<Set<String>>(elementName = "keywords", isOptional = true)
            element<String>(elementName = "entityType", isOptional = true)
            element<String>(elementName = "subType", isOptional = true)
            element<Boolean>(elementName = "defaultTemplate", isOptional = true)
            element<List<Map<String, Any>>>(elementName = "entity")
        }

    /**
     * Deserializes an [EntityTemplate] from the given [decoder].
     *
     * We need to use [JsonElement] to store the entity, because it depends on the [entityType] value. There's no guarantee that the [entityType] will be decoded
     */
    @OptIn(ExperimentalSerializationApi::class)
    override fun deserialize(decoder: Decoder): EntityTemplate {
        decoder.beginStructure(descriptor)

        return decoder.decodeStructure(descriptor) {

            lateinit var id: String
            var rev: String? = null
            var deletionDate: Long? = null
            var userId: String? = null
            var descr: String? = null
            var keywords: Set<String>? = null
            var entityType: String? = null
            var subType: String? = null
            var defaultTemplate: Boolean? = null
            var entity: List<Map<String, Any>>

            lateinit var entityJsonElement: JsonElement

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> id = decodeStringElement(descriptor, index)
                    1 -> rev = decodeNullableSerializableElement(descriptor, index, String.serializer().nullable)
                    2 -> deletionDate = decodeNullableSerializableElement(descriptor, index, Long.serializer().nullable)
                    3 -> userId = decodeNullableSerializableElement(descriptor, index, String.serializer().nullable)
                    4 -> descr = decodeNullableSerializableElement(descriptor, index, String.serializer().nullable)
                    5 -> keywords = decodeSerializableElement(descriptor, index, SetSerializer(String.serializer()).nullable)
                    6 -> entityType = decodeNullableSerializableElement(descriptor, index, String.serializer().nullable)
                    7 -> subType = decodeNullableSerializableElement(descriptor, index, String.serializer().nullable)
                    8 -> defaultTemplate = decodeNullableSerializableElement(descriptor, index, Boolean.serializer().nullable)
                    9 -> entityJsonElement = decodeSerializableElement(descriptor, index, JsonElement.serializer())

                    CompositeDecoder.DECODE_DONE -> {
                        entity = when (entityType) {
                            HEALTH_ELEMENT_TEMPLATE_QUALIFIED_NAME -> Serialization.json.decodeFromJsonElement<List<Map<String, HealthElementTemplate>>>(entityJsonElement)
                            MEDICATION_TEMPLATE_QUALIFIED_NAME -> Serialization.json.decodeFromJsonElement<List<Map<String, Medication>>>(entityJsonElement)
                            null -> emptyList()
                            else -> throw IllegalStateException("Unknown entity type: $entityType, unable to deserialize EntityTemplate")
                        }
                        break
                    }
                    else -> error("Unexpected index: $index")
                }
            }
            EntityTemplate(
                id = id,
                rev = rev,
                deletionDate = deletionDate,
                userId = userId,
                descr = descr,
                keywords = keywords,
                entityType = entityType,
                subType = subType,
                defaultTemplate = defaultTemplate,
                entity = entity
            )
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: EntityTemplate) {
        encoder.encodeStructure(descriptor) {
            encodeStringElement(descriptor, 0, value.id)
            encodeNullableSerializableElement(descriptor, 1, String.serializer().nullable, value.rev)
            encodeNullableSerializableElement(descriptor, 2, Long.serializer().nullable, value.deletionDate)
            encodeNullableSerializableElement(descriptor, 3, String.serializer().nullable, value.userId)
            encodeNullableSerializableElement(descriptor, 4, String.serializer().nullable, value.descr)
            encodeSerializableElement(descriptor, 5, SetSerializer(String.serializer()).nullable, value.keywords)
            encodeNullableSerializableElement(descriptor, 6, String.serializer().nullable, value.entityType)
            encodeNullableSerializableElement(descriptor, 7, String.serializer().nullable, value.subType)
            encodeNullableSerializableElement(descriptor, 8, Boolean.serializer().nullable, value.defaultTemplate)
            when (value.entityType) {
                HEALTH_ELEMENT_TEMPLATE_QUALIFIED_NAME -> encodeSerializableElement(
                    descriptor,
                    9,
                    ListSerializer(MapSerializer(String.serializer(), HealthElementTemplate.serializer())),
                    value.entity as List<Map<String, HealthElementTemplate>>
                )
                MEDICATION_TEMPLATE_QUALIFIED_NAME -> encodeSerializableElement(
                    descriptor,
                    9,
                    ListSerializer(MapSerializer(String.serializer(), Medication.serializer())),
                    value.entity as List<Map<String, Medication>>
                )
                null -> {
                    if (value.entity.isNotEmpty()) {
                        throw IllegalStateException("entityType is null, but entity is not empty")
                    }
                }
                else -> throw IllegalStateException("Unknown entity type: ${value.entityType}, unable to serialize EntityTemplate")
            }
        }
    }
}