package com.icure.sdk.utils

import kotlin.reflect.KClass

class ResourceNotFoundException(
	val resourceId: String,
	val resourceClass: KClass<*>
) : Exception("Resource $resourceId of type $resourceClass not found")