package com.icure.sdk.crypto.entities


sealed interface RecoveryResult<out T> {
	data class Success<T>(val data: T) : RecoveryResult<T>

	data class Failure(val reason: RecoveryDataUseFailureReason) : RecoveryResult<Nothing>
}

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