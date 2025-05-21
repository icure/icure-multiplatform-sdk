// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'dart:convert';


class AuthPlatformApi {
	MethodChannel _methodChannel;
	AuthPlatformApi(this._methodChannel);

	Future<String> getBearerToken(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AuthApi.getBearerToken',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getBearerToken");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as String);
	}
}