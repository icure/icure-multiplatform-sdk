import 'package:cardinal_sdk/auth/authentication_method.dart';
import 'package:cardinal_sdk/cardinal_sdk.dart';

abstract class CardinalSdkInitializersPlugin {
  Future<CardinalSdk> initialize(AuthenticationMethod authenticationMethod);
}
