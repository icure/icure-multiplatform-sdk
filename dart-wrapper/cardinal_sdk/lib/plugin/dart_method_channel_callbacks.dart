import 'dart:convert';

import 'package:cardinal_sdk/utils/internal/callback_references.dart';
import 'package:cardinal_sdk/utils/internal/error_references.dart';
import 'package:flutter/services.dart';

class DartMethodChannelCallbacks {
  static const MethodChannel _methodChannel = MethodChannel("com.icure.cardinal.sdk/dartCallbacks");
  static Future<dynamic> Function(MethodCall) callHandler = (MethodCall call) async {
    final args = call.arguments as Map;
    final callbackId = args["callbackId"]! as String;
    switch (call.method) {
      case "invoke":
        final callbackParams = jsonDecode(args["params"]!) as Map<String, dynamic>;
        try {
          return await CallbackReferences.get(callbackId)(callbackParams);
        } catch (e, trace) {
          throw PlatformException(
            code: "CardinalDartCallbackException",
            details: ErrorReferences.create(ErrorReference(e, trace))
          );
        }
      case "delete":
        CallbackReferences.delete(callbackId);
        return "";
      case "markUsed":
        CallbackReferences.markUsed(callbackId);
        return "";
      default:
        throw UnsupportedError("Unsupported method ${call.method}");
    }
  };

  static void register() {
    _methodChannel.setMethodCallHandler(callHandler);
  }
}