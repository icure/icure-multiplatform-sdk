package com.icure.cardinal_sdk

import CardinalApisPlugin
import InitializersPlugin
import com.icure.cardinal.sdk.dart.utils.ApiScope
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodChannel

class CardinalSdkPlugin: FlutterPlugin {
  private lateinit var apiChannel : MethodChannel
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
    initializersChannel.setMethodCallHandler(InitializersPlugin)
    paginationChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/pagination")
    paginationChannel.setMethodCallHandler(PaginationPlugin)
    subscriptionChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/subscription")
    subscriptionChannel.setMethodCallHandler(SubscriptionPlugin)
    utilsChannel = MethodChannel(flutterPluginBinding.binaryMessenger, "com.icure.cardinal.sdk/utils")
    utilsChannel.setMethodCallHandler(UtilsPlugin)
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    apiChannel.setMethodCallHandler(null)
    initializersChannel.setMethodCallHandler(null)
    paginationChannel.setMethodCallHandler(null)
    subscriptionChannel.setMethodCallHandler(null)
    utilsChannel.setMethodCallHandler(null)
    ApiScope.teardown()
  }
}
