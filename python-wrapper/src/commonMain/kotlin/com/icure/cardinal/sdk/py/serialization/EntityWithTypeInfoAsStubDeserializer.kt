package com.icure.cardinal.sdk.py.serialization

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataStub
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject


/**
 * A deserializer that always deserializes an EntityWithTypeInfo<*> always using stubs for the entity.
 */
@OptIn(InternalIcureApi::class)
internal object EntityWithTypeInfoAsStubDeserializer : KSerializer<EntityWithTypeInfo<*>> {
	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("EntityWithTypeInfo") {
		element("entity", EntityWithEncryptionMetadataStubSerializer.descriptor)
		element<EntityWithEncryptionMetadataTypeName>("type")
	}

	override fun serialize(encoder: Encoder, value: EntityWithTypeInfo<*>) {
		throw UnsupportedOperationException("EntityWithTypeInfo<*> can only be deserialized")
	}

	override fun deserialize(decoder: Decoder): EntityWithTypeInfo<*> =
		decoder.decodeStructure(descriptor) {
			var entity: EntityWithEncryptionMetadataStub? = null
			var type: EntityWithEncryptionMetadataTypeName? = null

			while (true) {
				when (val index = decodeElementIndex(descriptor)) {
					0 -> entity = decodeSerializableElement(descriptor, 0, EntityWithEncryptionMetadataStubSerializer)
					1 -> type = decodeSerializableElement(descriptor, 1, EntityWithEncryptionMetadataTypeName.serializer())
					CompositeDecoder.DECODE_DONE -> break
					else -> throw SerializationException("Unknown index $index")
				}
			}

			EntityWithTypeInfo(
				entity ?: throw SerializationException("Missing value for entity"),
				type ?: throw SerializationException("Missing value for type")
			)
		}
}

// Always ignores any unknown keys, regardless of the Json configuration
@OptIn(InternalIcureApi::class)
private object EntityWithEncryptionMetadataStubSerializer : KSerializer<EntityWithEncryptionMetadataStub> {
	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("EntityWithEncryptionMetadataStub") {
		element<String>("id")
		element<String?>("rev")
		element<Set<String>>("secretForeignKeys")
		element<Map<String, Set<Delegation>>>("cryptedForeignKeys")
		element<Map<String, Set<Delegation>>>("delegations")
		element<Map<String, Set<Delegation>>>("encryptionKeys")
		element<SecurityMetadata?>("securityMetadata")
	}

	override fun serialize(encoder: Encoder, value: EntityWithEncryptionMetadataStub) {
		throw UnsupportedOperationException("EntityWithEncryptionMetadataStub can only be deserialized")
	}

	override fun deserialize(decoder: Decoder): EntityWithEncryptionMetadataStub {
		val jsonDecoder = decoder as? JsonDecoder
			?: throw SerializationException("This serializer only supports json decoding")
		val jsonObject = jsonDecoder.decodeJsonElement().jsonObject
		return EntityWithEncryptionMetadataStub(
			jsonObject["id"]?.let {
				jsonDecoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for id"),
			jsonObject["rev"]?.let {
				jsonDecoder.json.decodeFromJsonElement(it)
			},
			jsonObject["secretForeignKeys"]?.let {
				jsonDecoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for secretForeignKeys"),
			jsonObject["cryptedForeignKeys"]?.let {
				jsonDecoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for cryptedForeignKeys"),
			jsonObject["delegations"]?.let {
				jsonDecoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for delegations"),
			jsonObject["encryptionKeys"]?.let {
				jsonDecoder.json.decodeFromJsonElement(it)
			} ?: throw SerializationException("Missing value for encryptionKeys"),
			jsonObject["securityMetadata"]?.let {
				jsonDecoder.json.decodeFromJsonElement(it)
			}
		)
	}
}