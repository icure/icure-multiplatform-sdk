import 'dart:convert';

import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:flutter/services.dart';

abstract class CardinalSdkInitializersPlugin {
  Future<CardinalSdk> initialize(String username, String longToken);
}