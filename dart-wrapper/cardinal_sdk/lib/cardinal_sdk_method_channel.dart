import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'cardinal_sdk_platform_interface.dart';

/// An implementation of [CardinalSdkPlatform] that uses method channels.
class MethodChannelCardinalSdk extends CardinalSdkPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('cardinal_sdk');

  @override
  Future<String?> usePlatformMethod(int n) async {
    final version = await methodChannel.invokeMethod<String>('usePlatformMethod', { "data": n });
    return version;
  }
}
