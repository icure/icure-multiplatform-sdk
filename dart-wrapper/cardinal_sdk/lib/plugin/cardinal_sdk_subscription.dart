import 'package:cardinal_sdk/subscription/entity_subscription_close_reason.dart';
import 'dart:convert';
import 'package:flutter/services.dart';

abstract class CardinalSdkPlatformSubscriptionPlugin {
  Future<void> close(String sdkId);
  Future<EntitySubscriptionCloseReason?> getCloseReason(String sdkId);
  Future<Map<String, dynamic>> getEvent(String sdkId);
  Future<Map<String, dynamic>> waitForEvent(String sdkId, timeout: Duration);
}

class CardinalSdkMethodChannelSubscription extends CardinalSdkPlatformSubscriptionPlugin {
  final MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/subscription");

  CardinalSdkMethodChannelSubscription();

  @override
  Future<void> close(String sdkId) async {
    await _methodChannel.invokeMethod<String>(
        'close',
        {
          "sdkId": sdkId
        }
    );
    return;
  }

  @override
  Future<EntitySubscriptionCloseReason?> getCloseReason(String sdkId) async {
    final res = await _methodChannel.invokeMethod<String>(
        'getCloseReason',
        {
          "sdkId": sdkId
        }
    );
    return res == null ? null : EntitySubscriptionCloseReason.fromJson(jsonDecode(res));
  }

  @override
  Future<Map<String, dynamic>> getEvent(String sdkId) async {
    final res = await _methodChannel.invokeMethod<String>(
        'getEvent',
        {
          "sdkId": sdkId
        }
    );
    if (res == null) throw AssertionError("received null result from platform method getEvent");
    return res;
  }

  @override
  Future<Map<String, dynamic>> waitForEvent(String sdkId, timeout: Duration) async {
    final res = await _methodChannel.invokeMethod<String>(
        'getEvent',
        {
          "sdkId": sdkId,
          "timeout": timeout.inMilliseconds
        }
    );
    if (res == null) throw AssertionError("received null result from platform method waitForEvent");
    return res;
  }
}