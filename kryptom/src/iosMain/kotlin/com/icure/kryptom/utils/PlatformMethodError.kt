package com.icure.kryptom.utils

/**
 * Represents an unexpected error that occurred while using a platform method.
 * This could happen if the method returns an error code or if the result of the method does not conform to the
 * format expected by this library.
 */
class PlatformMethodException(
	message: String,
	val errorCode: Int?
) : Exception(message)