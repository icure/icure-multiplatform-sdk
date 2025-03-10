package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Failure
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Success
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

@Serializable(with = RecoveryResultSerializer::class)
sealed interface RecoveryResult<out T : Any> {
	val isSuccess: Boolean
	val value: T

	@Serializable
	data class Success<T : Any>(val data: T) : RecoveryResult<T> {
		override val isSuccess: Boolean get() = true
		override val value: T get() = data
	}

	@Serializable
	data class Failure(val reason: RecoveryDataUseFailureReason) : RecoveryResult<Nothing> {
		override val isSuccess: Boolean get() = false
		override val value: Nothing get() = throw IllegalStateException("No value for failure result")
	}
}

// Currently there is an issue with the default serializers for sealed interfaces with generic types, this custom serializer solves the issue
// https://github.com/Kotlin/kotlinx.serialization/issues/1784 - issue
// https://github.com/Kotlin/kotlinx.serialization/issues/1252#issuecomment-1780935921 - another possible serializer implementation, simpler but uses arrays
// https://github.com/Kotlin/kotlinx.serialization/issues/2555 - feature request
@OptIn(ExperimentalSerializationApi::class)
internal class RecoveryResultSerializer<T : Any>(private val valueSerializer: KSerializer<T>): KSerializer<RecoveryResult<T>> {
	companion object {
		private val SUCCESS_QUALIFIED_NAME = "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Success"
		private val FAILURE_QUALIFIED_NAME = "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Failure"
	}
	private val failureReasonSerializer = RecoveryDataUseFailureReason.serializer()
	override val descriptor: SerialDescriptor = buildClassSerialDescriptor("RecoveryResult<${valueSerializer.descriptor.serialName}>") {
		element<String>("kotlinType")
		element("data", valueSerializer.descriptor, isOptional = true)
		element("reason", failureReasonSerializer.descriptor, isOptional = true)
	}

	override fun deserialize(decoder: Decoder): RecoveryResult<T> = decoder.decodeStructure(descriptor) {
		var kotlinType: String? = null
		var data: T? = null
		var reason: RecoveryDataUseFailureReason? = null

		while (true) {
			when (val index = decodeElementIndex(descriptor)) {
				0 -> kotlinType = decodeStringElement(String.serializer().descriptor, 0)
				1 -> data = decodeSerializableElement(descriptor, 1, valueSerializer)
				2 -> reason = decodeSerializableElement(descriptor, 2, failureReasonSerializer)
				CompositeDecoder.DECODE_DONE -> break
			}
		}

		when (kotlinType) {
			SUCCESS_QUALIFIED_NAME -> {
				if (data == null) throw SerializationException("Missing data for success recovery result")
				Success(data)
			}
			FAILURE_QUALIFIED_NAME -> {
				if (reason == null) throw SerializationException("Missing reason for failure recovery result")
				Failure(reason)
			}
			else -> {
				throw SerializationException("Invalid/missing type for recovery result: $kotlinType")
			}
		}
	}
	override fun serialize(encoder: Encoder, value: RecoveryResult<T>) {
		encoder.encodeStructure(descriptor) {

			when (value) {
				is Success -> {
					encodeStringElement(descriptor, 0,  SUCCESS_QUALIFIED_NAME)
					encodeSerializableElement(descriptor, 1, valueSerializer, value.data)
				}
				is Failure -> {
					encodeStringElement(descriptor, 0, FAILURE_QUALIFIED_NAME)
					encodeSerializableElement(descriptor, 2, failureReasonSerializer, value.reason)
				}
			}
		}
	}
}

inline fun <T : Any, R : Any> RecoveryResult<T>.map(transform: (T) -> R): RecoveryResult<R> = when (this) {
	is RecoveryResult.Success -> RecoveryResult.Success(transform(this.data))
	is RecoveryResult.Failure -> this
}

@Serializable
enum class RecoveryDataUseFailureReason {
	/**
	 * The recovery data matching the provided recovery key does not exist. It could have been deleted, or it could have been expired.
	 */
	Missing,

	/**
	 * The recovery data exists but it is not available to the current user. The user may have used a recovery key that he created while logged in as
	 * a different user.
	 */
	Unauthorized,

	/**
	 * The recovery data exists and is available to the current user, but it is not of the expected type.
	 */
	InvalidType,

	/**
	 * The recovery data exists and is available to the current user, but its content could not be interpreted. The data may have been created
	 * with an unsupported SDK version.
	 */
	InvalidContent,
}