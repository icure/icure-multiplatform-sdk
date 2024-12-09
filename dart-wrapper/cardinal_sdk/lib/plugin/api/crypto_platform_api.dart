// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'dart:convert';


class CryptoPlatformApi {
	MethodChannel _methodChannel;
	CryptoPlatformApi(this._methodChannel);

	Future<void> forceReload(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.forceReload',
			{
				"sdkId": sdkId,
			}
		).catchError(convertPlatformException);
	}

	Future<Map<String, Map<CardinalRsaPublicKeyFingerprint, CardinalRsaPrivateKey>>> currentDataOwnerKeys(String sdkId, bool filterTrustedKeys) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.currentDataOwnerKeys',
			{
				"sdkId": sdkId,
				"filterTrustedKeys": jsonEncode(filterTrustedKeys),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method currentDataOwnerKeys");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry(CardinalRsaPublicKeyFingerprint(k2), (v2 as CardinalRsaPrivateKey)))));
	}
}