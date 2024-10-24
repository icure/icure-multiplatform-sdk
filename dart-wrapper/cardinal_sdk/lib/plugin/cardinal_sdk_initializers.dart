import 'dart:convert';

import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:flutter/services.dart';

abstract class CardinalSdkInitializersPlugin {
  Future<CardinalSdk> initialize(String username, String longToken);
}

class CardinalSdkMethodChannelInitializers extends CardinalSdkInitializersPlugin {
  static const MethodChannel _methodChannel = MethodChannel("com.icure.cardinal.sdk/initializers");

  @override
  Future<CardinalSdk> initialize(String username, String longToken) async {
    final res = await _methodChannel.invokeMethod<String>(
      "initialize",
      {
        "username": username,
        "longToken": longToken
      }
    );
    if (res == null) throw AssertionError("received null result from platform method matchAccessLogsBy");
    final parsedResJson = jsonDecode(res);
    return CardinalSdk(parsedResJson as String);
  }
}