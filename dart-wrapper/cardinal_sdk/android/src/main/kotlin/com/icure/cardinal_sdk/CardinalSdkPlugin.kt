package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.DartCallbacksHandler
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel

class CardinalSdkPlugin: FlutterPlugin {
  private lateinit var apiChannel : MethodChannel
  private lateinit var filtersChannel : MethodChannel
  private lateinit var initializersChannel : MethodChannel
  private lateinit var paginationChannel : MethodChannel
  private lateinit var subscriptionChannel : MethodChannel
  private lateinit var utilsChannel : MethodChannel

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    ApiScope.setup()
    apiChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/api")
    apiChannel.setMethodCallHandler(CardinalApisPlugin)
    filtersChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/filters")
    filtersChannel.setMethodCallHandler(CardinalFiltersPlugin)
    initializersChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/initializers")
    initializersChannel.setMethodCallHandler(InitializersPlugin(flutterPluginBinding.applicationContext))
    paginationChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/pagination")
    paginationChannel.setMethodCallHandler(PaginationPlugin)
    subscriptionChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/subscription")
    subscriptionChannel.setMethodCallHandler(SubscriptionPlugin)
    utilsChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/utils")
    utilsChannel.setMethodCallHandler(UtilsPlugin)
    val callbackMethodChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/dartCallbacks")
    DartCallbacksHandler.registerUsingMethodChannel { methodName, callbackId, args, resultCallback ->
      val arguments = listOfNotNull(
        Pair("callbackId", callbackId),
        args?.let { Pair("params", it) }
      ).toMap()
      callbackMethodChannel.invokeMethod(
        methodName,
        arguments,
        object : MethodChannel.Result {
          override fun success(p0: Any?) {
            if (p0 is String) {
              resultCallback(p0, null, null, null)
            } else {
              resultCallback(
                null,
                "UnexpectedSuccessType",
                "Got ${p0?.javaClass?.simpleName}",
                null
              )
            }
          }

          override fun error(p0: String, p1: String?, p2: Any?) {
            resultCallback(null, p0, p1, p2?.toString())
          }

          override fun notImplemented() {
            resultCallback(null, "NotImplemented", null, null)
          }
        }
      )
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    apiChannel.setMethodCallHandler(null)
    initializersChannel.setMethodCallHandler(null)
    paginationChannel.setMethodCallHandler(null)
    subscriptionChannel.setMethodCallHandler(null)
    utilsChannel.setMethodCallHandler(null)
    ApiScope.teardown()
    DartCallbacksHandler.unregister()
  }
}
