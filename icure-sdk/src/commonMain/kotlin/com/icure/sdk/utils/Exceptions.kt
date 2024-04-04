package com.icure.sdk.utils

import io.ktor.http.HttpMethod
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import kotlin.reflect.KClass

/**
 * Exception thrown when a certain resource is not found.
 * @param resourceId An identifier that does not match some expected resource. The format of this identifier depends on
 * the resource type.
 * @param resourceClass The type of the missing resource that was not found.
 */
class ResourceNotFoundException(
	val resourceId: String,
	val resourceClass: KClass<*>
) : Exception("Resource $resourceId of type ${resourceClass.simpleName} not found")

/**
 * Exception thrown when a retrieved entity does not conform to the expected format.
 */
class IllegalEntityException(message: String, cause: Throwable? = null) : Exception(message, cause)

/**
 * Signals that an error occurred during the encryption/decryption (e.g. can't find a key) or encryption validation (e.g. something that
 * should be encrypted according to the manifest is not encrypted) of an entity.
 */
class EntityEncryptionException(message: String, cause: Throwable? = null) : Exception(message, cause)

class RequestStatusException(
	val requestMethod: HttpMethod,
	val url: String,
	val statusCode: Int,
) : Exception(
	"Request $requestMethod $url failed with status code $statusCode"
)

class UnexpectedResponseContentException(message: String) : Exception(message)

/**
 * Represents a failure in the iCure SDK implementation. This exception is thrown in case of unexpected behaviours which
 * are most likely caused by bugs in the SDK. If you encounter this exception, please report it to the iCure team.
 */
class InternalIcureException(message: String, cause: Throwable? = null) : Exception(message, cause)

/**
 * Checks an invariant at runtime. If value is not true there is an implementation error on iCure's side.
 */
@OptIn(ExperimentalContracts::class)
@InternalIcureApi
inline fun ensure(value: Boolean, lazyMessage: () -> String) {
	contract {
		returns() implies value
	}
	if (!value) {
		throw InternalIcureException(lazyMessage())
	}
}

@OptIn(ExperimentalContracts::class)
@InternalIcureApi
inline fun <T> ensureNonNull(value: T?, lazyMessage: () -> String): T {
	contract {
		returns() implies (value != null)
	}
	if (value == null) {
		throw InternalIcureException(lazyMessage())
	} else return value
}


@OptIn(ExperimentalContracts::class)
@InternalIcureApi
inline fun validateResponseContent(
	isValid: Boolean,
	lazyMessage: () -> String
) {
	contract {
		returns() implies isValid
	}
	if (!isValid) {
		throw UnexpectedResponseContentException(lazyMessage())
	}
}

