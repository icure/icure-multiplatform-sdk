import 'package:cardinal_sdk/subscription/entity_subscription_close_reason.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';
import 'package:flutter/services.dart';

abstract class CardinalSdkPlatformSubscriptionPlugin {
  Future<void> close(String sdkId);
  Future<EntitySubscriptionCloseReason?> getCloseReason(String sdkId);
  Future<Map<String, dynamic>?> getEvent(String sdkId);
  Future<Map<String, dynamic>?> waitForEvent(String sdkId, Duration timeout);
}

class CardinalSdkMethodChannelSubscription extends CardinalSdkPlatformSubscriptionPlugin {
  final MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/subscription");

  CardinalSdkMethodChannelSubscription();

  @override
  Future<void> close(String subscriptionId) async {
    await _methodChannel.invokeMethod<String>(
        'close',
        {
          "subscriptionId": subscriptionId
        }
    ).catchError(convertPlatformException);
    return;
  }

  @override
  Future<EntitySubscriptionCloseReason?> getCloseReason(String subscriptionId) async {
    final res = await _methodChannel.invokeMethod<String>(
        'getCloseReason',
        {
          "subscriptionId": subscriptionId
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method getEvent");
    final decodedRes = jsonDecode(res);
    return decodedRes == null ? null : EntitySubscriptionCloseReason.fromJSON(decodedRes);
  }

  @override
  Future<Map<String, dynamic>?> getEvent(String subscriptionId) async {
    final res = await _methodChannel.invokeMethod<String>(
        'getEvent',
        {
          "subscriptionId": subscriptionId
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method getEvent");
    return jsonDecode(res);
  }

  @override
  Future<Map<String, dynamic>?> waitForEvent(String subscriptionId, Duration timeout) async {
    final res = await _methodChannel.invokeMethod<String>(
        'waitForEvent',
        {
          "subscriptionId": subscriptionId,
          "timeout": jsonEncode(timeout.inMilliseconds)
        }
    ).catchError(convertPlatformException);
    if (res == null) throw AssertionError("received null result from platform method waitForEvent");
    return jsonDecode(res);
  }
}