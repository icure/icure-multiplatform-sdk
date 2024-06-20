package com.icure.sdk.py

import kotlinx.serialization.Serializable

@Serializable
data class PyResult<T>(
	val success: T?,
	val failure: String?
)

internal fun <T> Result<T>.toPy() =
	fold(
		onSuccess = { PyResult(it, null) },
		onFailure = { PyResult(null, "${it::class.simpleName} - ${it.message}")}
	)

// TODO we can add specific overloads of Result<T>.toPy() for non-data classes to help with handling them
