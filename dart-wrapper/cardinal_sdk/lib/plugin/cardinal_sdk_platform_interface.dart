import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'cardinal_sdk_platform_apis_plugin.dart';
import 'cardinal_sdk_method_channel_apis.dart';

abstract class CardinalSdkPlatformInterface extends PlatformInterface with CardinalSdkPlatformApisPlugin {
  CardinalSdkPlatformInterface() : super(token: _token);

  static final Object _token = Object();

  static CardinalSdkPlatformInterface _instance = CardinalSdkMethodChannelApis();

  static CardinalSdkPlatformInterface get instance => _instance;

  static set instance(CardinalSdkPlatformInterface instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }
}
