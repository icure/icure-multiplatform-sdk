package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.ResourceUtils
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

object UtilsPlugin : MethodChannel.MethodCallHandler {

	@Suppress("UNCHECKED_CAST")
	override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
		if (
			!dispatch(
				methodName = call.method,
				parameters = (call.arguments as Map<String, String>?).orEmpty()
			) { success, errorCode, errorMessage, errorDetail ->
				if (errorCode != null)
					result.error(errorCode, errorMessage, errorDetail)
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
			String?,
		) -> Unit,
	): Boolean = when(methodName) {
		"releasePlatformResource" -> releasePlatformResource(parameters, resultCallback)
		"cancelJob" -> cancelJob(parameters, resultCallback)
		else -> null
	}?.let { true } ?: false

	private fun releasePlatformResource(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
		String?,
	) -> Unit) {
		ResourceUtils.releasePlatformResource(
			resultCallback,
			parameters.getValue("resourceId")
		)
	}

	private fun cancelJob(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
		String?,
	) -> Unit) {
		ApiScope.cancel(
			resultCallback,
			parameters.getValue("cancellationToken").toLong()
		)
	}
}