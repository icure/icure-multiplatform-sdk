package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.utils.PaginatedListIterator

object PaginationPlugin : MethodChannel.MethodCallHandler {

	@Suppress("UNCHECKED_CAST")
	override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
		if (
			!dispatch(
				methodName = call.method,
				parameters = (call.arguments as Map<String, String>?).orEmpty()
			) { success, errorCode, errorMessage ->
				if (errorCode != null)
					result.error(errorCode, errorMessage, null)
				else
					result.success(success)
			}
		) result.notImplemented()
	}

	fun dispatch(
		methodName: String,
		parameters: Map<String, String>,
		resultCallback: (
			String?,
			String?,
			String?,
		) -> Unit,
	): Boolean = when(methodName) {
		"hasNext" -> hasNext(parameters, resultCallback)
		"next" -> next(parameters, resultCallback)
		else -> null
	}?.let { true } ?: false

	private fun hasNext(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
	) -> Unit) {
		PaginatedListIterator.hasNext(
			resultCallback,
			parameters.getValue("sdkId")
		)
	}

	private fun next(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
	) -> Unit) {
		PaginatedListIterator.next(
			resultCallback,
			parameters.getValue("sdkId"),
			parameters.getValue("limit")
		)
	}

}