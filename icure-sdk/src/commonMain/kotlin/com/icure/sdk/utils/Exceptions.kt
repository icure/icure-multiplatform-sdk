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
) : Exception("Resource $resourceId of type $resourceClass not found")

/**
 * Exception thrown when a retrieved entity does not conform to the expected format.
 */
class IllegalEntityException(message: String, cause: Throwable? = null) : Exception(message, cause)

class RequestStatusException(
	val requestMethod: HttpMethod,
	val url: String,
	val statusCode: Int,
) : Exception(
	"Request $requestMethod $url failed with status code $statusCode"
)

class UnexpectedResponseContentException(message: String) : Exception(message)

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
		throw AssertionError(lazyMessage())
	}
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

