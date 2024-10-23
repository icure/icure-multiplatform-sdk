package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.utils.ApiScope
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

class CardinalSdkPlugin: FlutterPlugin, MethodCallHandler {
  private lateinit var channel : MethodChannel

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    ApiScope.setup()
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/api")
    channel.setMethodCallHandler(this)
  }

  @Suppress("UNCHECKED_CAST")
  override fun onMethodCall(call: MethodCall, result: Result) {
    val methodNameSplit = call.method.split(".")
    val methodName = methodNameSplit.drop(1).joinToString(".")
    val apiName = methodNameSplit.first()
    if (
      !dispatchApi(
        apiName = apiName,
        methodName = methodName,
        parameters = (call.arguments as Map<String, String>?).orEmpty()
      ) { success, errorCode, errorMessage ->
        if (errorCode != null)
          result.error(errorCode, errorMessage, null)
        else
          result.success(success)
      }
    ) result.notImplemented()
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
    ApiScope.teardown()
  }
}
