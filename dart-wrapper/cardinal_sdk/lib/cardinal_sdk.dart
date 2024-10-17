
import 'cardinal_sdk_platform_interface.dart';

class CardinalSdk {
  Future<String?> example(int n) {
    return CardinalSdkPlatform.instance.usePlatformMethod(n);
  }
}
