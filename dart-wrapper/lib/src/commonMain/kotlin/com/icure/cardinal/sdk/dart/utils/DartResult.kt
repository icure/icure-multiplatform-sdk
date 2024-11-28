package com.icure.cardinal.sdk.dart.utils

import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.KSerializer

object DartResult {
	fun <T> resolve(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?, failureDetails: String?) -> Unit,
		resultSerializer: KSerializer<T>,
		method: () -> T
	) {
		inlineResolve(resultCallback, resultSerializer) { method() }
	}

	@OptIn(InternalIcureApi::class)
	inline fun <T> inlineResolve(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?, failureDetails: String?) -> Unit,
		resultSerializer: KSerializer<T>,
		method:  () -> T
	) {
		try {
			resultCallback(
				Serialization.fullLanguageInteropJson.encodeToString(resultSerializer, method()),
				null,
				null,
				null
			)
		} catch (e: Exception) {
			resultCallback(
				null,
				e::class.simpleName ?: "UnknownException",
				e.message,
				e.stackTraceToString()
			)
		}
	}
}