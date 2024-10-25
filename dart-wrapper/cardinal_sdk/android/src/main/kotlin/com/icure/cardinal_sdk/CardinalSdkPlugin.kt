package com.icure.cardinal_sdk

import CardinalApisPlugin
import InitializersPlugin
import com.icure.cardinal.sdk.dart.utils.ApiScope
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel

class CardinalSdkPlugin: FlutterPlugin {
  private lateinit var apiChannel : MethodChannel
  private lateinit var initializersChannel : MethodChannel

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    ApiScope.setup()
    apiChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/api")
    apiChannel.setMethodCallHandler(CardinalApisPlugin)
    filtersChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/filters")
    filtersChannel.setMethodCallHandler(CardinalFiltersPlugin)
    initializersChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/initializers")
    initializersChannel.setMethodCallHandler(InitializersPlugin)
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    apiChannel.setMethodCallHandler(null)
    initializersChannel.setMethodCallHandler(null)
    ApiScope.teardown()
  }
}
