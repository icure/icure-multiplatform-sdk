import 'package:cardinal_sdk/cardinal_sdk.dart';

abstract class CardinalSdkInitializersPlugin {
  Future<CardinalSdk> initialize(String username, String longToken);
}
