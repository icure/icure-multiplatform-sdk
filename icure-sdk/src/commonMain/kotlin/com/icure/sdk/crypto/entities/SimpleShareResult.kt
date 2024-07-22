package com.icure.sdk.crypto.entities

import com.icure.sdk.model.base.HasEncryptionMetadata
import kotlinx.serialization.Serializable

@Serializable
sealed interface SimpleShareResult<out T : HasEncryptionMetadata> {
	val isSuccess: Boolean

	/**
	 * Return the updated entity if the share operation was successful, else throw an error.
	 */
	fun updatedEntityOrThrow(): T

	/**
	 * Represents the result of a successful share operation.
	 */
	@Serializable
	data class Success<T : HasEncryptionMetadata>(val updatedEntity: T) : SimpleShareResult<T> {
		override val isSuccess: Boolean get() = true
		override fun updatedEntityOrThrow(): T = updatedEntity
	}

	@Serializable
	data class Failure(val errorsDetails: List<FailedRequestDetails>) : SimpleShareResult<Nothing> {
		override val isSuccess: Boolean get() = false

		override fun updatedEntityOrThrow(): Nothing {
			throw IllegalStateException("One or more share requests failed. Details: $errorsDetails")
		}
	}
}