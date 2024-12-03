import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:flutter/services.dart';

abstract class CardinalSdkPlatformUtilsPlugin {
  Future<void> releasePlatformResource(String resourceId);
  Future<void> cancelJob(int cancellationToken);
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
    ).catchError(convertPlatformException);
    return;
  }

  @override
  Future<void> cancelJob(int cancellationToken) async {
    await _methodChannel.invokeMethod<String>(
        'cancelJob',
        {
          "cancellationToken": cancellationToken.toString()
        }
    ).catchError(convertPlatformException);
    return;
  }
}