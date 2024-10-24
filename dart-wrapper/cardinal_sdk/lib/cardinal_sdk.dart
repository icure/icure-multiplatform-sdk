import 'package:cardinal_sdk/api/patient_platform_api.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:flutter/cupertino.dart';

class CardinalSdk {
  final String _sdkId;
  PatientPlatformApi patient;

  @protected
  CardinalSdk(this._sdkId) : patient = PatientPlatformApi(_sdkId);

  static Future<CardinalSdk> initialize(
    String username,
    String longToken
  ) {
    return CardinalSdkPlatformInterface.instance.initializers.initialize(username, longToken);
  }
}