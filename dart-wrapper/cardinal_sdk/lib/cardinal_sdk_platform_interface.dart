import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'cardinal_sdk_method_channel.dart';

abstract class CardinalSdkPlatform extends PlatformInterface {
  /// Constructs a CardinalSdkPlatform.
  CardinalSdkPlatform() : super(token: _token);

  static final Object _token = Object();

  static CardinalSdkPlatform _instance = MethodChannelCardinalSdk();

  /// The default instance of [CardinalSdkPlatform] to use.
  ///
  /// Defaults to [MethodChannelCardinalSdk].
  static CardinalSdkPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [CardinalSdkPlatform] when
  /// they register themselves.
  static set instance(CardinalSdkPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> usePlatformMethod(int n) {
    throw UnimplementedError('usePlatformMethod() has not been implemented.');
  }
}
