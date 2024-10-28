package com.icure.cardinal.sdk.dart.utils

import com.icure.cardinal.sdk.utils.Serialization
import kotlinx.serialization.KSerializer

object DartResult {
	fun <T> resolve(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?) -> Unit,
		resultSerializer: KSerializer<T>,
		method: () -> T
	) {
		inlineResolve(resultCallback, resultSerializer) { method() }
	}

	inline fun <T> inlineResolve(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?) -> Unit,
		resultSerializer: KSerializer<T>,
		method:  () -> T
	) {
		try {
			resultCallback(
				Serialization.fullJson.encodeToString(resultSerializer, method()),
				null,
				null
			)
		} catch (e: Exception) {
			resultCallback(
				null,
				e::class.simpleName ?: "UnknownException",
				e.stackTraceToString()
			)
		}
	}
}