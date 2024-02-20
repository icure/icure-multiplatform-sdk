package com.icure.sdk.crypto.entities

import com.icure.sdk.model.Encryptable
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface ShareResult<out T : Encryptable> {
	val isSuccess: Boolean

	/**
	 * Return the updated entity if the share operation was successful, else throw an error.
	 */
	fun updatedEntityOrThrow(): T

	/**
	 * Represents the result of a successful share operation.
	 */
	data class Success<T : Encryptable>(val updatedEntity: T) : ShareResult<T> {
		override val isSuccess: Boolean get() = true
		override fun updatedEntityOrThrow(): T = updatedEntity
	}

	data class Failure(val errorsDetails: List<FailedRequestDetails>) : ShareResult<Nothing> {
		override val isSuccess: Boolean get() = false

		override fun updatedEntityOrThrow(): Nothing {
			throw IllegalStateException("One or more share requests failed. Details: $errorsDetails")
		}
	}
}