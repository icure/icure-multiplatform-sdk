package com.icure.cardinal.sdk.dart.utils

import com.icure.cardinal.sdk.utils.Serialization
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.serialization.KSerializer

object ApiScope {
	private lateinit var scope: CoroutineScope

	fun setup() {
		scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
	}

	fun teardown() {
		scope.cancel()
	}

	fun <T> execute(
		resultCallback: (success: String?, failureCode: String?, failureMessage: String?) -> Unit,
		resultSerializer: KSerializer<T>,
		method: suspend () -> T
	) {
		scope.launch {
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
}
