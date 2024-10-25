package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.subscription.EntitySubscription

object SubscriptionPlugin : MethodChannel.MethodCallHandler {

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
		"close" -> close(parameters, resultCallback)
		"getCloseReason" -> next(parameters, resultCallback)
		"getEvent" -> getEvent(parameters, resultCallback)
		"waitForEvent" -> waitForEvent(parameters, resultCallback)
		else -> null
	}?.let { true } ?: false

	private fun close(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
	) -> Unit) {
		EntitySubscription.close(
			resultCallback,
			parameters.getValue("sdkId")
		)
	}

	private fun getCloseReason(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
	) -> Unit) {
		EntitySubscription.getCloseReason(
			resultCallback,
			parameters.getValue("sdkId")
		)
	}

	private fun getEvent(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
	) -> Unit) {
		EntitySubscription.getEvent(
			resultCallback,
			parameters.getValue("sdkId")
		)
	}

	private fun waitForEvent(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
	) -> Unit) {
		EntitySubscription.getEvent(
			resultCallback,
			parameters.getValue("sdkId"),
			parameters.getValue("timeout")
		)
	}

}