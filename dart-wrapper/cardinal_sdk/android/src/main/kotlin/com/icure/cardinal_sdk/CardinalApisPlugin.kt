package com.icure.cardinal_sdk

import com.icure.cardinal_sdk.api.dispatchApi
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

object CardinalApisPlugin : MethodChannel.MethodCallHandler {
    @Suppress("UNCHECKED_CAST")
    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        val methodNameSplit = call.method.split(".")
        val methodName = methodNameSplit.drop(1).joinToString(".")
        val apiName = methodNameSplit.first()
        if (
            !dispatchApi(
                apiName = apiName,
                methodName = methodName,
                parameters = (call.arguments as Map<String, String>?).orEmpty()
            ) { success, errorCode, errorMessage, errorDetail ->
                if (errorCode != null)
                    result.error(errorCode, errorMessage, errorDetail)
                else
                    result.success(success)
            }
        ) result.notImplemented()
    }
}