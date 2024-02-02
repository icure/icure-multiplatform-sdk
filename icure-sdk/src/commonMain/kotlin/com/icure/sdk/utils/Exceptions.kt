package com.icure.sdk.utils

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