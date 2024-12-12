package com.icure.cardinal.sdk.dart.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.JsonObject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

interface DartCallbacksHandler {
	suspend fun invoke(callbackId: String, params: JsonObject): String
	suspend fun delete(callbackId: String)
	suspend fun duplicate(callbackId: String): String

	companion object {
		private var _registered: DartCallbacksHandler? = null

		val registered: DartCallbacksHandler get() =
			checkNotNull(_registered) { "Instance is not registered" }

		fun unregister() {
			_registered = null
		}

		fun registerUsingMethodChannel(
			invokeOnChannel: (
				methodName: String,
				callbackId: String,
				args: String?,
				resultCallback: (
					success: String?,
					errorCode: String?,
					errorMessage: String?,
					errorDetails: String?
				) -> Unit
			) -> Unit
		) {
			_registered = MethodChannelDartCallbacksHandler(invokeOnChannel)
		}
	}
}

private class MethodChannelDartCallbacksHandler(
	private val invokeOnChannel: (
		methodName: String,
		callbackId: String,
		args: String?,
		resultCallback: (
			success: String?,
			errorCode: String?,
			errorMessage: String?,
			errorDetails: String?
		) -> Unit
	) -> Unit
) : DartCallbacksHandler {
	override suspend fun invoke(callbackId: String, params: JsonObject): String =
		suspendInvokeOnChannel("invoke", callbackId, params.toString()).successOrThrow()

	override suspend fun delete(callbackId: String) {
		suspendInvokeOnChannel("delete", callbackId, null).successOrThrow().also {
			if (it != "") throw AssertionError("Delete should return empty string")
		}
	}

	override suspend fun duplicate(callbackId: String): String =
		suspendInvokeOnChannel("duplicate", callbackId, null).successOrThrow()

	private suspend fun suspendInvokeOnChannel(
		methodName: String,
		callbackId: String,
		args: String?,
	): MethodChannelResult = withContext(Dispatchers.Main) {
		suspendCoroutine { continuation ->
			invokeOnChannel(
				methodName,
				callbackId,
				args
			) { success, errorCode, errorMessage, errorDetails ->
				continuation.resume(MethodChannelResult(success, errorCode, errorMessage, errorDetails))
			}
		}
	}

	private data class MethodChannelResult(
		val success: String?,
		val errorCode: String?,
		val errorMessage: String?,
		val errorDetails: String?
	) {
		fun successOrThrow(): String = when {
			errorCode == "CardinalDartCallbackException" -> throw DartCallbackException(checkNotNull(errorDetails) {
				"CardinalDartCallbackException is missing dart error reference id"
			})
			errorCode != null -> throw AssertionError("Unexpected dart callback error: $errorCode $errorMessage $errorDetails")
			success != null -> success
			else -> throw AssertionError("Method channel result has all null values")
		}
	}
}

class DartCallbackException(
	referenceId: String
) : Exception(referenceId)

