package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.Example
import com.icure.cardinal.sdk.dart.utils.ResourceUtils
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

object CryptoPlugin : MethodChannel.MethodCallHandler {

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
		"KeyPairRecoverer.recoverWithRecoveryKey" -> recoverWithRecoveryKey(parameters, resultCallback)
		"KeyPairRecoverer.waitForRecoveryKey" -> waitForRecoveryKey(parameters, resultCallback)
		else -> null
	}?.let { true } ?: false

	private fun recoverWithRecoveryKey(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
		String?,
	) -> Unit) {
		KeyPairRecoverer.recoverWithRecoveryKey(
			resultCallback,
			referenceId = parameters.getValue("referenceId"),
			recoveryKeyString = parameters.getValue("recoveryKey"),
			autoDeleteString = parameters.getValue("autoDelete")
		)
	}

	private fun waitForRecoveryKey(parameters: Map<String, String>, resultCallback: (
		String?,
		String?,
		String?,
		String?,
	) -> Unit) {
		KeyPairRecoverer.waitForRecoveryKey(
			resultCallback,
			cancellationToken = parameters.getValue("cancellationToken").toLong(),
			referenceId = parameters.getValue("referenceId"),
			recoveryKeyString = parameters.getValue("recoveryKey"),
			autoDeleteString = parameters.getValue("autoDelete"),
			waitSecondsString = parameters.getValue("waitSeconds")
		)
	}
}