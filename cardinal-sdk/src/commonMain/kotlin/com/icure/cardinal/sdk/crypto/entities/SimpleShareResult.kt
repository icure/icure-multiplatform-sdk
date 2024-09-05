package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
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

@Serializable(with = SimpleShareResultSerializer::class)
sealed interface SimpleShareResult<out T : HasEncryptionMetadata> {
	val isSuccess: Boolean

	/**
	 * Return the updated entity if the share operation was successful, else throw an error.
	 */
	fun updatedEntityOrThrow(): T

	/**
	 * Represents the result of a successful share operation.
	 */
	data class Success<T : HasEncryptionMetadata>(val updatedEntity: T) : SimpleShareResult<T> {
		override val isSuccess: Boolean get() = true
		override fun updatedEntityOrThrow(): T = updatedEntity
	}

	data class Failure(val errorsDetails: List<FailedRequestDetails>) : SimpleShareResult<Nothing> {
		override val isSuccess: Boolean get() = false

		override fun updatedEntityOrThrow(): Nothing {
			throw IllegalStateException("One or more share requests failed. Details: $errorsDetails")
		}
	}
}

// Currently there is an issue with the default serializers for sealed interfaces with generic types, this custom serializer solves the issue
// https://github.com/Kotlin/kotlinx.serialization/issues/1784 - issue
// https://github.com/Kotlin/kotlinx.serialization/issues/1252#issuecomment-1780935921 - another possible serializer implementation, simpler but uses arrays
// https://github.com/Kotlin/kotlinx.serialization/issues/2555 - feature request
@OptIn(ExperimentalSerializationApi::class)
internal class SimpleShareResultSerializer<T : HasEncryptionMetadata>(private val valueSerializer: KSerializer<T>):
	KSerializer<SimpleShareResult<T>> {
	companion object {
		private val SUCCESS_QUALIFIED_NAME = "com.icure.cardinal.sdk.crypto.entities.SimpleShareResult.Success"
		private val FAILURE_QUALIFIED_NAME = "com.icure.cardinal.sdk.crypto.entities.SimpleShareResult.Failure"
	}
	private val errorsDetailsSerializer = ListSerializer(FailedRequestDetails.serializer())
	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("RecoveryResult<${valueSerializer.descriptor.serialName}>") {
		element<String>("type")
		element("updatedEntity", valueSerializer.descriptor, isOptional = true)
		element("errorsDetails", errorsDetailsSerializer.descriptor, isOptional = true)
	}

	override fun deserialize(decoder: Decoder): SimpleShareResult<T> = decoder.decodeStructure(descriptor) {
		var type: String? = null
		var data: T? = null
		var errors: List<FailedRequestDetails>? = null

		while (true) {
			when (val index = decodeElementIndex(descriptor)) {
				0 -> type = decodeStringElement(String.serializer().descriptor, 0)
				1 -> data = decodeSerializableElement(descriptor, 1, valueSerializer)
				2 -> errors = decodeSerializableElement(descriptor, 2, errorsDetailsSerializer)
				CompositeDecoder.DECODE_DONE -> break
			}
		}

		when (type) {
			SUCCESS_QUALIFIED_NAME -> {
				if (data == null) throw SerializationException("Missing updatedEntity for success recovery result")
				SimpleShareResult.Success(data)
			}
			FAILURE_QUALIFIED_NAME -> {
				if (errors == null) throw SerializationException("Missing errorsDetails for failure recovery result")
				SimpleShareResult.Failure(errors)
			}
			else -> {
				throw SerializationException("Invalid/missing type for recovery result: $type")
			}
		}
	}

	override fun serialize(encoder: Encoder, value: SimpleShareResult<T>) {
		encoder.encodeStructure(descriptor) {
			when (value) {
				is SimpleShareResult.Success -> {
					encodeStringElement(descriptor, 0,  SUCCESS_QUALIFIED_NAME)
					encodeSerializableElement(descriptor, 1, valueSerializer, value.updatedEntity)
				}
				is SimpleShareResult.Failure -> {
					encodeStringElement(descriptor, 0, FAILURE_QUALIFIED_NAME)
					encodeSerializableElement(descriptor, 2, errorsDetailsSerializer, value.errorsDetails)
				}
			}
		}
	}
}
