import 'dart:convert';
import 'package:flutter/services.dart';

abstract class CardinalSdkPlatformUtilsPlugin {
  Future<void> releasePlatformResource(String resourceId);
}

class CardinalSdkMethodChannelUtils extends CardinalSdkPlatformUtilsPlugin {
  final MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/utils");

  CardinalSdkMethodChannelUtils();

  @override
  Future<void> releasePlatformResource(String resourceId) async {
    await _methodChannel.invokeMethod<String>(
        'releasePlatformResource',
        {
          "resourceId": resourceId
        }
    );
    return;
  }
}